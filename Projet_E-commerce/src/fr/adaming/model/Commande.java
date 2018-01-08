package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commandes")

public class Commande implements Serializable{
	
	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCommande;
	private Date dateCommande;
	
	//transformation uml en java
	private List<ligneCommande> listeligne;
	
	
	
	
	//constructeur
	public Commande() {
		super();
	}


	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}


	public Commande(long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	//getter et setter
	public long getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}
	
	
	
	
	

}