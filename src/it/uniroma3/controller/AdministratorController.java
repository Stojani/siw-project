package it.uniroma3.controller;

import it.uniroma3.facade.AdministratorFacade;
import it.uniroma3.model.Administrator;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class AdministratorController {
	
	@EJB
	private AdministratorFacade administratorFacade;
	
	private String email;
	private String password;
	private String errMessage;
	private boolean esito;

	private Administrator administrator;
	
	public String login() {
		
		 Administrator administrator = administratorFacade.getAdminByEmail(email);
		 esito= administrator.checkPassword(password);
		 
		 if (esito=true) {
		    this.administrator = administrator;
		    return "adminDashboard.jsp";}
		 else 
			 return "loginAdministrator.xhtml";
}
	public String logout(){
		this.email = null;
		this.password = null;
		this.administrator = null;
		return "index.jsp";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	public boolean getEsito() {
		return esito;
	}
	
	

}
