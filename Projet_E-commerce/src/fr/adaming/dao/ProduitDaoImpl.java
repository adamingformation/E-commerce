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
	public Produit getProduitById(long id) {
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
	public int deleteProduitPanier(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteProduitStock(long id) {
		Produit p=em.find(Produit.class, id);
		em.remove(p);
		return 1;

	}

	@Override
	public Produit updateProduit(Produit p) {
		em.merge(p);
		return p;
	}
	
	@Override
	public List<Produit> getAllPorduitByCategorie(int id_c) {
		// Creation de la requete JPQL
		String req = "select p from Produit as p where categorie_id=:pcId";
		System.out.println("ID categorie =" +id_c);
		// Creer un query
		Query query = em.createQuery(req);
		
		// passage des param
		query.setParameter("pcId", id_c);

		// Envoyer la requete
		return query.getResultList();
	}

}
