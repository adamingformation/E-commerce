package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Stateful
public class CategorieServiceImpl implements ICategorieService{

	
	@EJB
	private ICategorieDao categorieDao;
	
	
	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getCategorieById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie addCategorie(Categorie C) {
	
				return categorieDao.addCategorie(C);
	}

	@Override
	public int deleteCategorie(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Categorie updateCategorie(Categorie C) {
		// TODO Auto-generated method stub
		return null;
	}

}
