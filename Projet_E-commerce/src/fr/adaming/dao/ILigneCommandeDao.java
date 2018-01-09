package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;

@Local
public interface ILigneCommandeDao {

public LigneCommande addLCommande(LigneCommande LC);
	
	public long deleteLCommande(long idLC);

	public LigneCommande updateLCommande (LigneCommande LC);
	
	public LigneCommande getLCommande(long idLC);
	
	public List<LigneCommande> getAllLCommandeByIdCommande(long idCommande);
	
	
}
