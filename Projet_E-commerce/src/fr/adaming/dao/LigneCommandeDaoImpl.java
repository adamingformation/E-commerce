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
	public void deleteLCommande(long idLC) {
		LigneCommande lcOut=em.find(LigneCommande.class, idLC);
		em.remove(lcOut);
	}
	@Override
	public List<LigneCommande> getAllLCommande(){
				// construire la requete JPQL
				String req = "SELECT lc FROM LigneCommande as lc WHERE lc.commande IS NULL";

				// creer la query
				Query query = em.createQuery(req);
				System.out.println("query : " + query);
				// mettre les parametres
				System.out.println("liste avant evoyer liste : " + query.getResultList());
				// cr�ation de la nouvelle liste des lignes commandes
				List<LigneCommande> listeLCommande = query.getResultList();
				System.out.println("liste : " + listeLCommande);

				return listeLCommande;
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
		String req="SELECT lc FROM LigneCommande AS lc WHERE lc.commande.idCommande=:pidC";
		
		//creation query 
		Query query=em.createQuery(req);
		
		//Spe des param
		query.setParameter("pidC", idCommande);
		
		//creation de la nouvelle liste des lignes commandes
		List<LigneCommande> listeLCommande=query.getResultList();
		
		return listeLCommande;
	}



	@Override
	public double calculPrixLigneCommande(LigneCommande lc, Produit p) {

		//System.out.println("lc :" + lc + "\n" + "p : " + p);
		//System.out.println("p.getprix : " + p.getPrix());
		double prixTotal = p.getPrix() * lc.getQuantite();
		//System.out.println("prix :" + prixTotal);
		return prixTotal;
	}
}
