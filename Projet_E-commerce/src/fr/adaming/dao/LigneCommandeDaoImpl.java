package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.LigneCommande;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	
	@PersistenceContext(unitName = "PU_E")
	private EntityManager em;
	
	

	public void setEm(EntityManager em) {
		this.em = em;
		
}



	@Override
	public LigneCommande addLCommande(LigneCommande LC) {
		em.persist(LC);
		return LC;
	}



	@Override
	public long deleteLCommande(long idLC) {
		LigneCommande lcOut=em.find(LigneCommande.class, idLC);
		em.remove(lcOut);
		return 1;
	}



	@Override
	public LigneCommande updateLCommande(LigneCommande LC) {
		em.merge(LC);
		return LC;
	}

	
	public LigneCommande getLCommande(long idLC){
		LigneCommande lcOut=em.find(LigneCommande.class, idLC);
		return lcOut;
	}
	
	public List<LigneCommande> getAllLCommandeByIdCommande(long idCommande){
		//construire la requete
		String req="SELECT lc FROM LigneCommande AS lc WHERE commande_id=:idC";
		
		//creation query 
		Query query=em.createQuery(req);
		
		//Spe des param
		query.setParameter("idC", idCommande);
		
		//creation de la nouvelle liste des lignes commandes
		List<LigneCommande> listeLigneCommande=query.getResultList();
		
		return listeLigneCommande;
	}
}
