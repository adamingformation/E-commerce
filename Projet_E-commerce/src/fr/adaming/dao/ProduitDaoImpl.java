package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao {

	// injection d'un entityManager
	@PersistenceContext(unitName = "PU_E")
	private EntityManager em;

	// getter et setter em
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Produit addProduitPanier(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public Produit addProduitStock(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public List<Produit> getAllProduit() {
		// requete JPQL
		String req = "SELECT p FROM Produit as p ";

		// creer query
		Query query = em.createQuery(req);

		// envoyer la req et recup la liste
		List<Produit> liste = query.getResultList();

		return liste;

	}

	@Override
	public Produit getProduitById(int id) {
		// requete JPQL
		String req = "SELECT p FROM Produit as p WHERE p.id=:pId";

		// creer query
		Query query = em.createQuery(req);
		
		query.setParameter("pId", id);

		try {
			// envoyer et recup la liste
			Produit p = (Produit) query.getSingleResult();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteProduitPanier(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduitStock(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

}
