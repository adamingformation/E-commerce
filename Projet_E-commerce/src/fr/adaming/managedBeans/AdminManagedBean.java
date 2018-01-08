package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Admin;
import fr.adaming.service.IAdminServive;



@ManagedBean(name="aMB")
@RequestScoped
public class AdminManagedBean implements Serializable {

	@EJB
	private IAdminServive adminService;
	
	private Admin admin;

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
			
			//ajouter l'agent dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSession", aOut);
			
			return "gestionStock";
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin n'existe pas"));
		}
			return "login";
		}
		
		
	}

