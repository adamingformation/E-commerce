package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;

@ManagedBean(name = "cliMB")
@RequestScoped
public class ClientManagedBean implements Serializable {

	@EJB
	private IClientService clientService;
	@EJB
	private ICommandeService commandeService;

	private Client client;
	private Commande commande;
	private List<Commande> listeCommandes;
	private Panier panier;

	// constructeur par defaut
	public ClientManagedBean() {
		this.client = new Client();
	}

	// Getters et Setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	// Les M�thodes
	public String ajouterClient() {
		this.client = clientService.addClient(this.client);
		// Passer le client dans la session
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("client", this.client);

		if (this.client.getIdClient() != 0) {
			return "accueil";
		} else {
			return "loginClient";
		}
	}

	public String supprimerClient() {
		clientService.deleteClient(this.client.getIdClient());
		if (this.client.getIdClient() == null) {
			return "accueil";
		} else {
			return "supprimerClient";
		}

	}

	public String modifierClient() {
		Client clOut = clientService.updateClient(this.client);
		if (clOut != null) {
			return "accueil";
		} else {
			return "modifierClient";
		}

	}

	public String rechercherClient() {
		Client clOut = clientService.getClientByNomEmail(this.client.getNomClient(), this.client.getEmail());
		if (clOut != null) {
			this.client = clOut;


			return "accueil";
		} else {
			return "loginClient";
		}

	}

	public void deconnexionClient() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

	}

}
