package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.LigneCommande;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	
	@PersistenceContext(unitName = "PU_E")
	private EntityManager em;
	
	

	public void setEm(EntityManager em) {
		this.em = em;
		
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
