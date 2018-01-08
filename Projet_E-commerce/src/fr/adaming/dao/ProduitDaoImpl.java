package fr.adaming.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	
	//injection d'un entityManager
		@PersistenceContext(unitName="PU_E")
		private EntityManager em;
	
		//getter et setter em
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduitById() {
		// TODO Auto-generated method stub
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
