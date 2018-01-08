package fr.adaming.service;

import javax.ejb.Local;

import fr.adaming.model.Admin;

@Local
public interface IAdminServive {
	
	public Admin isExist(Admin a) throws Exception;

}
