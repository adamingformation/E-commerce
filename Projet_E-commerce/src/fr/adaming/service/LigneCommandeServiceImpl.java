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
		
		return LCommandeDao.addLCommande(LC);
	}

	@Override
	public long deleteLCommande(long idLC) {
		
		return LCommandeDao.deleteLCommande(idLC);
	}

	@Override
	public LigneCommande updateLCommande(LigneCommande LC) {
		
		return LCommandeDao.updateLCommande(LC);
	}
	@Override
	public List<LigneCommande> getAllLCommande(){
		return LCommandeDao.getAllLCommande();
	}
	
	@Override
	public LigneCommande getLCommandeById(long idLC) {
		
		return LCommandeDao.getLCommandeById(idLC);
	}

	@Override
	public List<LigneCommande> getAllLCommandeByIdCommande(long idCommande) {
		
		return LCommandeDao.getAllLCommandeByIdCommande(idCommande);
	}


	
	
	
}
