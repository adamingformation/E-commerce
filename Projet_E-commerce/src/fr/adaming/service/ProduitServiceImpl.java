package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
@Stateful
public class ProduitServiceImpl implements IProduitService {
	
	@EJB
	private IProduitDao produitDao;
	@EJB
	private ICategorieDao catDao;
	
	private List<Produit> listeCat1;
	private List<Produit> listeCat2;
	
	@Override
	public Produit addProduitPanier(Produit p) {
		
		return produitDao.addProduitPanier(p);
	}

	@Override
	public Produit addProduitStock(Produit p,Categorie c) {
		Categorie cOut=catDao.getCategorieById(c.getIdCategorie());
		p.setCategorie(cOut);
		return produitDao.addProduitStock(p);
	}

	@Override
	public List<Produit> getAllProduit() {
		
		return produitDao.getAllProduit();
	}

	@Override
	public Produit getProduitById(long id) {
		
		return produitDao.getProduitById(id);
	}

	@Override
	public int deleteProduitPanier(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduitStock(long id) {
		
		return produitDao.deleteProduitStock(id);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitDao.updateProduit(p);
	}
	

	public List<Produit> trierCat() {
		// recup liste produit
		List<Produit> liste = produitDao.getAllProduit();

		for (Produit p : liste) {
			if (p.getCategorie().getIdCategorie() == 1) {
				listeCat1.add(p);
				return listeCat1;

			} else {

				listeCat2.add(p);
				return listeCat2;
			}

		}
		return liste;
	}

	@Override
	public List<Produit> getAllPorduitByCategorie(int id_c) {
		return produitDao.getAllPorduitByCategorie(id_c);
	}

}
