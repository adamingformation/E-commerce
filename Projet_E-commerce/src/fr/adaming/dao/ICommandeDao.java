package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Commande;

@Local
public interface ICommandeDao {

	public Commande addCommande(Commande c);

	public Commande updateCommande(Commande c);

	public void deleteCommande(long idCommande);

	public List<Commande> gettAllCommande();

	public Commande getCommande(long idCommande);

}
