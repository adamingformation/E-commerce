package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		// construire la requete JPQL
		String req = "SELECT c FROM Categorie as c";

		// creer la query
		Query query = em.createQuery(req);

		// envoyer la requete et recup resultat

		return query.getResultList();
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
		 if(c==null){
			 return  1; 
		 }else{
			 return  0;
		 }
		
	}

	@Override
	public Categorie updateCategorie(Categorie C) {
		em.merge(C);
		return C;
	}
	
	
	
	

}
