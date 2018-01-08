package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "pMB")
@RequestScoped

public class ProduitManagedBean implements Serializable {

	@EJB
	private IProduitService produitService;

	private Admin admin;
	private List<Produit> listeProduit;
	private Produit produit;
	private Categorie categorie;

	public ProduitManagedBean() {
		this.produit = new Produit();
		this.categorie=new Categorie();
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String ajouterProduit() {
		this.produit = produitService.addProduitStock(this.produit);

		if (this.produit.getIdProduit() != 0) {
			// recup nouvelle liste
			//this.listeProduit = produitService.getAllProduit();
			// mettre a jour la liste dans la sesion
			//maSession.setAttribute("produitListe", this.listeProduit);
			return "gestionStock";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produit non Ajoutée !"));
			return "ajoutProduit";
		}
		
	}

}
