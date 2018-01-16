package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "comMB")
@RequestScoped
public class CommandeManagedBean implements Serializable{

	@EJB
	ICommandeService commandeService;
	@EJB
	ILigneCommandeService ligneCommandeService;
	
//attributs
	private Commande commande;
	private Client client;
	private List<LigneCommande> listeLCo;
	private LigneCommande ligneCommande;
	private long idCommande;
	
	//Constructeurs
	public CommandeManagedBean() {
		this.commande = new Commande();
		this.client = new Client();
		this.ligneCommande = new LigneCommande();
	}

	//Getters et Setters
	
	
	public Commande getCommande() {
		return commande;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getListeLCo() {
		return listeLCo;
	}

	public void setListeLCo(List<LigneCommande> listeLCo) {
		this.listeLCo = listeLCo;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	//les methodes
	public String ajouterCommande(){
		//Créer une commande
		this.commande = commandeService.addCommande(this.commande);
		
		//récupérer ligne co qui ont un id null
		this.listeLCo = ligneCommandeService.getAllLCommande();
		
		//Donne id de la commande a chaque ligne de co
		for (LigneCommande LC : this.listeLCo) {
			LC.setCommande(this.commande);
			this.ligneCommande = ligneCommandeService.updateLCommande(LC);
			System.out.println("commande de la LC : " + this.ligneCommande);
		}

		//générer une nouvelle liste des ligne commande qui sont associées à la commande
		this.listeLCo = ligneCommandeService.getAllLCommandeByIdCommande(this.commande.getIdCommande());
		System.out.println("liste des LC par id  de la commande : " + this.listeLCo);
		
		//On ajoute dans la session l'id de la commande pour l'avoir lors de l'affichage dans l'espace client(accueil)
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idCommande", this.commande.getIdCommande());
		if (this.commande != null) {
			return "loginClient";
		} else {
			return "panier";
		}
	}
	public String supprimerCommande(){
		commandeService.deleteCommande(this.commande.getIdCommande());
		Commande cOut = commandeService.getCommande(this.commande.getIdCommande());

		if (cOut == null) {
			return "accueil";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la suppression de la commande a échouée"));
			return "supprimerCommande";
		}
	}
	
	public String modifierCommande(){
		Commande c=commandeService.updateCommande(this.commande);
		if(c!=null){
			return "accueil";
			
		}else{
			return "modifierCommande";
		}
	}
	
	public String rechercherCommandeParIdClientNull() {
		Commande cOut = commandeService.getCommandeByIdClNULL(this.client.getIdClient());
		if (cOut != null) {
			this.commande = cOut;
			return "rechercheCommande";
		} else {
			return "rechercherCommande";
		}
	}
public String rechercherCommandeIDC(){
		
		this.commande=commandeService.getCommande(this.commande.getIdCommande());
		
		return "rechercherCommande";
		
	}
}
