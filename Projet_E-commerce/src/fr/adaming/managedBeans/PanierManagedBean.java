package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "paMB")
@RequestScoped
public class PanierManagedBean implements Serializable {

	@EJB
	ILigneCommandeService ligneCoService;

	@EJB
	ICommandeService cService;

	private Panier panier;
	private LigneCommande ligneCommande;
	private List<LigneCommande> listeLignecommande;
	private long idCommande;
	private Commande commande;

	// constructeur
	public PanierManagedBean() {
		this.panier = new Panier();
		this.ligneCommande = new LigneCommande();
		this.listeLignecommande = new ArrayList<LigneCommande>();

	}

	// getter et setter

	public Panier getPanier() {
		return panier;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void setLigneCoService(ILigneCommandeService ligneCoService) {
		this.ligneCoService = ligneCoService;
	}

	public void setcService(ICommandeService cService) {
		this.cService = cService;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public List<LigneCommande> getListeLignecommande() {
		return listeLignecommande;
	}

	public void setListeLignecommande(List<LigneCommande> listeLignecommande) {
		this.listeLignecommande = listeLignecommande;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	// Les méthodes
	public String envoyerPanier() {
		// Récupération de toutes les lignes de commandes associées à un
		// idCommande null
		this.listeLignecommande = ligneCoService.getAllLCommande();

		// passer la liste dans la session
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeLCPanier",
				this.listeLignecommande);

		return "panier";
	}
}
