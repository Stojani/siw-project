package it.uniroma3.controller;

import it.uniroma3.facade.AdministratorFacade;
import it.uniroma3.model.Administrator;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class AdministratorController {
	
	@EJB
	private AdministratorFacade administratorFacade;
	
	private String email;
	private String password;
	private String errMessage;

	private Administrator administrator;
	
	public String loginAdministrator() {
		try {
			Administrator administrator = administratorFacade.getAdministrator(email, password);
			this.administrator = administrator;
			
		} catch (Exception e) {
			errMessage = "Invalid credentials";
			return "loginAdministrator.jsp";
		}
		return "administratorArea.jsp";
	}
	
	public String administratorLogout(){
		this.email = null;
		this.password = null;
		this.administrator = null;
		return "index";
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
	
	

}
