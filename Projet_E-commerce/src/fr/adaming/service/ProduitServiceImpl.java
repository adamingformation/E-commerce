package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;
@Stateful
public class ProduitServiceImpl implements IProduitService {
	
	@EJB
	private IProduitDao produitDao;
	
	
	@Override
	public Produit addProduitPanier(Produit p) {
		
		return produitDao.addProduitPanier(p);
	}

	@Override
	public Produit addProduitStock(Produit p) {
		
		return produitDao.addProduitStock(p);
	}

	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduitById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteProduitPanier(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduitStock(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

}
