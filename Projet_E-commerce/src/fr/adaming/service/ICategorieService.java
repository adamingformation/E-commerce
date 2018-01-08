package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {

	public List<Categorie> getAllCategorie();
	
	public List<Categorie> getCategorieById(long id);
	
	public Categorie addCategorie(Categorie C);
	
	public int deleteCategorie(int id);

	public Categorie updateCategorie (Categorie C);
}
