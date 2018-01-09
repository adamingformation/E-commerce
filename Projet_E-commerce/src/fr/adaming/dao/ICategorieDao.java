package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieDao {
	
	public List<Categorie> getAllCategorie();
	
	public Categorie getCategorieById(long id);
	
	public Categorie addCategorie(Categorie C);
	
	public long deleteCategorie(long id);

	public Categorie updateCategorie (Categorie C);
}
