package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;

@Stateful
public class AdminServiceImpl implements IAdminServive {

	//pour injecter un Dao
	@EJB
	private IAdminDao adminDao;
	
	
	//getters et setters pour l'injection de dependance
	public IAdminDao getAdminDao() {
		return adminDao;
	}



	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}



	@Override
	public Admin isExist(Admin a) throws Exception {
		
		return adminDao.isExist(a);
	}

}
