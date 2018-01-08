package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;



public class Panier {
	

	//transformation uml en java
	private List<LigneCommande> listeLigne;

	public Panier() {
		super();
	}

	public Panier(List<LigneCommande> listeLigne) {
		super();
		this.listeLigne = listeLigne;
	}

	public List<LigneCommande> getListeLigne() {
		return listeLigne;
	}

	public void setListeLigne(List<LigneCommande> listeLigne) {
		this.listeLigne = listeLigne;
	}
	
	

}
