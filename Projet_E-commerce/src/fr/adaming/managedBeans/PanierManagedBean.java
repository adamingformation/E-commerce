package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "paMB")
@RequestScoped
public class PanierManagedBean implements Serializable {

	@EJB
	ILigneCommandeService ligneCoService;

	private Panier panier;
	private LigneCommande ligneCommande;
	private List<LigneCommande> listeLignecommande;


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
	public void envoyerPanier() {
		//Récupération de toutes les lignes de commandes associées à un idCommande null
		this.listeLignecommande = ligneCoService.getAllLCommande();
		
			
			if (this.listeLignecommande != null) {
				// passer la liste dans la session
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeLCoPanier",
						this.listeLignecommande);

			}
		}
		

		

	}



