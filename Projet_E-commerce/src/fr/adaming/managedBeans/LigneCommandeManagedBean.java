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

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "lcMB")
@RequestScoped
public class LigneCommandeManagedBean implements Serializable{
	
	//asso uml en java
	@EJB
	private ILigneCommandeService lcService;
	
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
			
			
		public String ajouterLCommande() {
			LigneCommande verif = lcService.addLCommande(this.lcommande);

			if (verif != null) {
				// recuperer la nouvelle liste de la BD
				List<LigneCommande> liste = lcService.getAllLCommande();

				// mettre à jour la liste des Categories dans la session
				maSession.setAttribute("LCommandeList", liste);

				return "gestionStock";

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("l'ajout n'a pas marché"));
				return "ajoutLCommande";
			}
		}
		
		
		public String deleteLCommande() {

			// pas de retour avec un void sinon comme autre en modifiant en int
			long verif = lcService.deleteLCommande(this.lcommande.getIdNumLigne());
			if (verif == 1) {
				// recuperer la nouvelle liste de la BD
				List<LigneCommande> liste = lcService.getAllLCommande();

				// mettre à jour la liste des Categories dans la session
				maSession.setAttribute("LCommandeList", liste);

				return "gestionStock";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la supression n'a pas marché"));
				return "supLCommande";
			}

		}
		
		public String updateLCommande(){
			LigneCommande verif = lcService.updateLCommande(this.lcommande);

			if (verif != null) {
				// recuperer la nouvelle liste de la BD
				List<LigneCommande> liste = lcService.getAllLCommande();

				// mettre à jour la liste des Categories dans la session
				maSession.setAttribute("LCommandeList", liste);

				return "gestionStock";

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la modfication n'a pas marché"));
				return "modif";
			}
		}

}
