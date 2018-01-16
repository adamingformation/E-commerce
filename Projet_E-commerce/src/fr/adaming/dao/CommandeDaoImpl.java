package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Commande;

@Stateless
public class CommandeDaoImpl implements ICommandeDao {

	// injection d'un entityManager
	@PersistenceContext(unitName = "PU_E")
	private EntityManager em;

	//Setters
	public void setEm(EntityManager em) {
		this.em = em;
	}

	// m�thode
	@Override
	public Commande addCommande(Commande c) {
		em.persist(c);
		return c;
	}

	@Override
	public Commande updateCommande(Commande c) {
		em.merge(c);
		return c;
	}

	@Override
	public void deleteCommande(long idCommande) {
		Commande cOut = em.find(Commande.class, idCommande);
		em.remove(cOut);

	}

	@Override
	public List<Commande> gettAllCommande(long idCl) {
		// construre la requ�te
		String req = "SELECT c FROM Commande AS c WHERE c.client.idClient=:PidCl";

		// cr�ation du query
		Query query = em.createQuery(req);

		// Sp�cification des param�tres
		query.setParameter("PidCl", idCl);

		// cr�ation de la nouvelle liste des lignes commandes
		List<Commande> listeCommande = query.getResultList();

		return listeCommande;
	}

	@Override
	public Commande getCommande(long idCommande) {
	
		return em.find(Commande.class, idCommande);
	}
	
	@Override
	public Commande getCommandeByIdClNULL(long idCl) {
		// construre la requ�te
		String req = "SELECT c FROM Commande AS c WHERE c.client.idClient IS NULL";

		// cr�ation du query
		Query query = em.createQuery(req);

		// cr�ation de la nouvelle liste des lignes commandes
		Commande cOut = (Commande) query.getSingleResult();

		return cOut;
	}

}
