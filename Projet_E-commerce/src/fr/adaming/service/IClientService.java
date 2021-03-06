package fr.adaming.service;

import javax.ejb.Local;

import fr.adaming.model.Client;

@Local
public interface IClientService {

public Client addClient(Client cl);
	
	public void deleteClient(long idCl);
	
	public Client updateClient(Client cl);
	
	public Client getClientByNomEmail(String nom, String email);
}
