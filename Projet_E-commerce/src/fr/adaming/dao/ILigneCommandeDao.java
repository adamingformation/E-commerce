package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface ILigneCommandeDao {

public LigneCommande addLCommande(LigneCommande LC);
	
	public long deleteLCommande(long idLC);

	public LigneCommande updateLCommande (LigneCommande LC);
	
	
	public List<LigneCommande> getAllLCommande();
	
	public LigneCommande getLCommandeById(long idLC);
	
	public List<LigneCommande> getAllLCommandeByIdCommande(long idCommande);
	
	public double calculPrixLigneCommande(LigneCommande lc, Produit p);
}
