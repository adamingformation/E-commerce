package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService{

	@EJB
	private IClientDao clientDao;

	//setters
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	//Methodes
	@Override
	public Client addClient(Client cl) {
		return clientDao.addClient(cl);
	}

	@Override
	public void deleteClient(long idCl) {
		clientDao.deleteClient(idCl);
		
	}

	@Override
	public Client updateClient(Client cl) {
		return clientDao.updateClient(cl);
	}

	@Override
	public Client getClientByNomEmail(String nom, String email) {
		return clientDao.getClientByNomEmail(nom, email);
	}
	
	
}
