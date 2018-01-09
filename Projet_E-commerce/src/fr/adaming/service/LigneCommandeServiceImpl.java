package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.LigneCommande;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService{

	@EJB
	private ILigneCommandeDao LCommandeDao;

	public void setLCommandeDao(ILigneCommandeDao lCommandeDao) {
		LCommandeDao = lCommandeDao;
	}

	@Override
	public LigneCommande addLCommande(LigneCommande LC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteLCommande(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LigneCommande updateLCommande(LigneCommande LC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> getAllLCommandeByIdCommande(int idCommande) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
