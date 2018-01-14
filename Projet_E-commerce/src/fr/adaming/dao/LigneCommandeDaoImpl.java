package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

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
	public List<LigneCommande> getAllLCommande(){
		// construire la requete JPQL
				String req = "SELECT lc FROM LigneCommande as lc";

				// creer la query
				Query query = em.createQuery(req);

				// envoyer la requete et recup resultat

				return query.getResultList();
			}


	@Override
	public LigneCommande updateLCommande(LigneCommande LC) {
		em.merge(LC);
		return LC;
	}

	
	public LigneCommande getLCommandeById(long idLC){
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



	@Override
	public double calculPrixLigneCommande(LigneCommande lc, Produit p) {

		double prixTotal = p.getPrix() * lc.getQuantite();
		
		return prixTotal;
	}
}
