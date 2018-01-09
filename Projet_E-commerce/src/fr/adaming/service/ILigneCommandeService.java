package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;

@Local
public interface ILigneCommandeService {

public LigneCommande addLCommande(LigneCommande LC);
	
	public long deleteLCommande(long id);

	public LigneCommande updateLCommande (LigneCommande LC);
	
	public List<LigneCommande> getAllLCommandeByIdCommande(int idCommande);
	
}
