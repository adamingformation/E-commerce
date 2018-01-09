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
		
		return categorieDao.getAllCategorie();
	}

	@Override
	public Categorie getCategorieById(long id) {
		
		return categorieDao.getCategorieById(id);
	}

	@Override
	public Categorie addCategorie(Categorie C) {
	
				return categorieDao.addCategorie(C);
	}

	@Override
	public long deleteCategorie(long id) {
		
		return categorieDao.deleteCategorie(id);
	}

	@Override
	public Categorie updateCategorie(Categorie C) {
		
		return categorieDao.updateCategorie(C);
	}

}
