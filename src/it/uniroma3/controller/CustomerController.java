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
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Customer customer;
	private String dateOfBirth;
	private String errMessage;
	
	public void createCustomer() {
		this.customer=customerFacade.createCustomer(firstName, lastName, email, password, phoneNumber, dateOfBirth);
	}
	
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
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
