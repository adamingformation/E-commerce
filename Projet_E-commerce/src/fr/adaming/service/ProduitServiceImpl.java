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
	public Produit getProduitById(int id) {
		
		return produitDao.getProduitById(id);
	}

	@Override
	public int deleteProduitPanier(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduitStock(long id) {
		
		return produitDao.deleteProduitStock(id);
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

}
