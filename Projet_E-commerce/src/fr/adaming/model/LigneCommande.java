package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lignecommandes")
public class LigneCommande implements Serializable {

	//attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNumLigne;
	private int quantite;
	private int prix;
	
	//3 constructeurs
	public LigneCommande() {
		super();
	}
	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}
	
	
	
	public LigneCommande(Long idNumLigne, int quantite, int prix) {
		super();
		this.idNumLigne = idNumLigne;
		this.quantite = quantite;
		this.prix = prix;
	}
	//getters et setters
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Long getIdNumLigne() {
		return idNumLigne;
	}
	public void setIdNumLigne(Long idNumLigne) {
		this.idNumLigne = idNumLigne;
	}
	@Override
	public String toString() {
		return "LigneCommande [idNumLigne=" + idNumLigne + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
}
