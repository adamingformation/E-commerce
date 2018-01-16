package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Admin;

@Stateless
public class AdminDaoImpl implements IAdminDao{

	//pour l'injection d'un em
	@PersistenceContext(unitName="PU_E")
	 EntityManager em;
	
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}



	@Override
	public Admin isExist(Admin a) throws Exception {
		
		// construire la requete JPQL
		String req= "SELECT a FROM Admin a WHERE a.mail=:pMail AND a.mdp=:pMdp";
		
		//crée un query
		Query query=em.createQuery(req);
		
		//passage des params
		query.setParameter("pMail", a.getMail());
		query.setParameter("pMdp", a.getMdp());
		
		//envoyer la requete et recup l'agent
		Admin aOut= (Admin) query.getSingleResult();
		
		return aOut;
	}

}
