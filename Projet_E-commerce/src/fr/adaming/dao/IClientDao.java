package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.model.Client;

@Local
public interface IClientDao {

public Client addClient(Client cl);
	
	public void deleteClient(long idCl);
	
	public Client updateClient(Client cl);
	
	public Client getClientByNomEmail(String nom, String email);
}
