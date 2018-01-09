package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Admin;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "lcMB")
@RequestScoped
public class LigneCommandeManagedBean implements Serializable{
	
	//asso uml en java
	@EJB
	private ILigneCommandeService lcservice;
	
	//Attributs
	private LigneCommande lcommande;
	private Admin admin;
	private HttpSession maSession;
	public LigneCommandeManagedBean() {
		this.lcommande=new LigneCommande();
	}
	
	// methode qui s'execute apres l'instanciation du managedBean
		@PostConstruct
		public void init() {
			// recup session
			this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			// recup agent a partir de la session
			this.admin = (Admin) maSession.getAttribute("adminSession");}

		public LigneCommande getLcommande() {
			return lcommande;
		}

		public void setLcommande(LigneCommande lcommande) {
			this.lcommande = lcommande;
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
			
			
	

}
