package it.uniroma3.controller;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.model.Customer;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;


@ManagedBean
@SessionScoped
public class CustomerController {
	
	@EJB
	private CustomerFacade customerFacade;

	private String email;
	private String password;
	private Customer customer;
	private String errMessage;
	
	public String Login() {
		try {
			 Customer customer = customerFacade.getCustomerByEmail(email);
			 customer.checkPassword(password);
			 this.customer = customer;
		} catch (Exception e) {
			errMessage = "Invalid credentials";
			return "loginCustomer.jsp";
		}
		return "customerArea.jsp";
	}
	
	public String Logout(){
		this.customer = null;
		this.email = null;
		this.password = null;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
}
