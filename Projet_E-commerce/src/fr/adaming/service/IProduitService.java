package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
@Local
public interface IProduitService {
	public Produit addProduitPanier(Produit p);
	public Produit addProduitStock(Produit p ,Categorie c);
	public List<Produit> getAllProduit();
	public Produit getProduitById(long id);
	public int deleteProduitPanier(long id);
	public int deleteProduitStock(long id);
	public Produit updateProduit(Produit p);
	public List<Produit> trierCat();
	public List<Produit> getAllPorduitByCategorie(int id_c);
}
