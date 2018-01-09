package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "pMB")
@ViewScoped

public class ProduitManagedBean implements Serializable {

	@EJB
	private IProduitService produitService;
	@EJB
	private ICategorieService categorieService;
	
	
	private Admin admin;
	private List<Produit> listeProduit;
	private Produit produit;
	private Categorie categorie;
	private List<Categorie> listeCategorie;
	private HttpSession maSession;
	private String image;
	
	public ProduitManagedBean() {
		this.produit = new Produit();
		this.categorie = new Categorie();
	}

	public Produit getProduit() {
		return produit;
	}

	// methode qui s'execute apres l'instanviation du managedBean
//	@PostConstruct
//	public void init() {
//		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);		
//	}

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
		this.produit = produitService.addProduitStock(this.produit,this.categorie);

		if (this.produit.getIdProduit() != 0) {
			// recup nouvelle liste
			this.getAllProduit();
			
			// mettre a jour la liste dans la sesion
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitList", listeProduit);
		
			return "gestionStock";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produit non Ajoutée !"));
			return "ajoutProduit";
		}

	}
	
	public String supprimeProduit(){
		
		int p=produitService.deleteProduitStock(this.produit.getIdProduit());
		
		if (p!=0) {
			// recup nouvelle liste
			this.listeProduit = produitService.getAllProduit();
			// mettre a jour la liste dans la sesion
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitList", listeProduit);
			return "gestionStock";
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produit non Supprimé !"));
			return"supprimeProduit";
		}
		
		
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// transformer une image uploadfile en byte array
	public void upload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();

		// recup contenu de l'image en byte array (pixels)
		byte[] contents = uploadedFile.getContents();
		// stock dans l'atttribut photo de la catégorie
		produit.setPhoto(contents);
		// tranformer byte array en string (format base64)
		this.image = "data:image/png;base64," + Base64.encodeBase64String(contents);

	}

	public void getAllProduit() {

		List<Produit> listOut = produitService.getAllProduit() ;
		this.listeProduit = new ArrayList<Produit>();

		for (Produit element : listOut) {
			if (element.getPhoto() == null) {
				
				element.setImage(null);

			} else {

				element.setImage("data:image/png;base64," + Base64.encodeBase64String(element.getPhoto()));
			}

			this.listeProduit.add(element);
		}

	}
}
