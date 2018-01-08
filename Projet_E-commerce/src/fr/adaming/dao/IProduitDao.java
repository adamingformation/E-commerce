package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Produit;
@Local
public interface IProduitDao {
	
	public Produit addProduitPanier(Produit p);
	public Produit addProduitStock(Produit p);
	public List<Produit> getAllProduit();
	public Produit getProduitById();
	public int deleteProduitPanier(int id);
	public int deleteProduitStock(int id);
	public Produit updateProduit(Produit p);
	
		

}
