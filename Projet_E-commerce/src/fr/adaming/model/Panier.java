package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="paniers")


public class Panier extends LigneCommande{
	

	//transformation uml en java
	@OneToMany(mappedBy="panier",cascade=CascadeType.ALL)
	private List<LigneCommande> listeLigne;
	

}
