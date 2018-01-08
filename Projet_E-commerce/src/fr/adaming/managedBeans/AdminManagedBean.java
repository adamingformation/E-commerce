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
import fr.adaming.service.IAdminServive;
import fr.adaming.service.ICategorieService;



@ManagedBean(name="aMB")
@RequestScoped
public class AdminManagedBean implements Serializable {

	
	@EJB
	private IAdminServive adminService;
	
	private Admin admin;
	
	@EJB
	private ICategorieService cService;
	
	private List<Categorie> listeCategories;

	public AdminManagedBean() {
		this.admin=new Admin();
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String seConnecter(){
		try{
		Admin aOut=adminService.isExist(this.admin);
		
		//recup liste catégorie
				List<Categorie> listeCategories=cService.getAllCategorie();
				
				//ajouter la liste deans la session
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categoriesList", listeCategories);
			
			//ajouter l'agent dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSession", aOut);
			
			return "gestionStock";
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin n'existe pas"));
		}
			return "login";
		}
		
		
	}

