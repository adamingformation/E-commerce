package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "cMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {

	// asso uml en java
	@EJB
	private ICategorieService cService;

	// attributs modele MVC
	private Categorie categorie;
	private Admin admin;
	private HttpSession maSession;
	private String image;
	
	
	// constructeur vide
	public CategorieManagedBean() {
		this.categorie = new Categorie();
	}

	// methode qui s'execute apres l'instanciation du managedBean
	@PostConstruct
	public void init() {
		// recup session
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// recup agent a partir de la session
		this.admin = (Admin) maSession.getAttribute("adminSession");
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public HttpSession getMaSession() {
		return maSession;
	}

	public void setMaSession(HttpSession maSession) {
		this.maSession = maSession;
	}

	public String ajouterCategorie() {
		Categorie verif = cService.addCategorie(this.categorie);

		if (verif != null) {
			// recuperer la nouvelle liste de la BD
			List<Categorie> liste = cService.getAllCategorie();

			// mettre à jour la liste des Categories dans la session
			maSession.setAttribute("categoriesList", liste);

			return "gestionStock";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("l'ajout n'a pas marché"));
			return "ajoutCategorie";
		}
	}

	public String deleteCategorie() {

		// pas de retour avec un void sinon comme autre en modifiant en int
		long verif = cService.deleteCategorie(this.categorie.getIdCategorie());
		if (verif == 1) {
			// recuperer la nouvelle liste de la BD
			List<Categorie> liste = cService.getAllCategorie();

			// mettre à jour la liste des Categories dans la session
			maSession.setAttribute("categoriesList", liste);

			return "gestionStock";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la supression n'a pas marché"));
			return "supCategorie";
		}

	}
	
	public String updateCategorie(){
		Categorie verif = cService.updateCategorie(this.categorie);

		if (verif != null) {
			// recuperer la nouvelle liste de la BD
			List<Categorie> liste = cService.getAllCategorie();

			// mettre à jour la liste des Categories dans la session
			maSession.setAttribute("categoriesList", liste);

			return "gestionStock";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la modfication n'a pas marché"));
			return "modifCategorie";
		}
	}

	
	public String rechercheCategorie() {
	Categorie verif = cService.getCategorieById(this.categorie.getIdCategorie());
				
		if (verif != null) {

			this.categorie = verif;

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("la recherche n'a pas marché"));

		}
		return "rechercheCategorie";
	}
	
	//transformer une image uploadfile en byte array
	public void upload(FileUploadEvent event){
		UploadedFile uploadedFile=event.getFile();
		
		//recup contenu de l'image en byte array (pixels)
		byte[] contents=uploadedFile.getContents();
		//stock dans l'atttribut photo de la catégorie
		categorie.setPhoto(contents);
		//tranformer byte array en string (format base64)
		setImage("data:image/png;base64,"+Base64.encodeBase64String(contents));
		
		
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}

