package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao{
	
	@PersistenceContext(unitName = "PU_E")
	private EntityManager em;
	
	

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorieById(long id) {
		Categorie c=em.find(Categorie.class,id);

				 return c;
	}

	@Override
	public Categorie addCategorie(Categorie C) {
		em.persist(C);

		// 1er C sans id mais retour aura un id
		return C;
	}

	@Override
	public long deleteCategorie(long id) {
		 Categorie c=em.find(Categorie.class,id);
		 em.remove(c);
		return  1;
	}

	@Override
	public Categorie updateCategorie(Categorie C) {
		em.merge(C);
		return C;
	}
	
	
	
	

}
