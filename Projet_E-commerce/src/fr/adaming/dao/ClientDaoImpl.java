package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;

@Stateless
public class ClientDaoImpl implements IClientDao {

	
	// injection d'un entityManager
		@PersistenceContext(unitName = "PU_E")
		private EntityManager em;

		public void setEm(EntityManager em) {
			this.em = em;
		}

		//méthodes
		@Override
		public Client addClient(Client cl) {
			em.persist(cl);
			return cl;
		}

		@Override
		public void deleteClient(long idCl) {
			Client clOut = em.find(Client.class, idCl);
			em.remove(clOut);
			
		}

		@Override
		public Client updateClient(Client cl) {
			em.merge(cl);
			return cl;
		}

		@Override
		public Client getClientByNomEmail(String nom, String email) {
			// création de la requete
			String req = "SELECT cl FROM Client AS cl WHERE cl.nomClient=:pNomCl AND cl.email=:pEmailCl";

			// création du query
			Query query = em.createQuery(req);

			// Spécification des paramètres
			query.setParameter("pNomCl", nom);
			query.setParameter("pEmailCl", email);

			// obtention du client en question
			Client clOut = (Client) query.getSingleResult();
			return clOut;
		}
		
		
		
		
		
}
