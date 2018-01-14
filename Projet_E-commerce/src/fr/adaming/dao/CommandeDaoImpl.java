package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	// méthode
	@Override
	public Commande addCommande(Commande c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande updateCommande(Commande c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommande(long idCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> gettAllCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande getCommande(long idCommande) {
		// TODO Auto-generated method stub
		return null;
	}

}
