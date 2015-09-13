package it.uniroma3.controller;

import it.uniroma3.facade.AddressFacade;
import java.sql.Date;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;



@ManagedBean
@SessionScoped
public class CustomerController {
	
	@EJB
	private CustomerFacade customerFacade;
	
	@EJB
	private AddressFacade addressFacade;

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Date dateOfBirth;
	private Date registrationDate;
	private Customer customer;
	private Address address;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String errMessage; 
	
	public String createCustomer() {
		registrationDate= (Date) new java.util.Date();
		this.customer=customerFacade.createCustomer(firstName, lastName, email, password, phoneNumber, dateOfBirth, registrationDate);
		this.address=addressFacade.createAddress(street, city, state, zipcode, country);
		this.customer.setAddress(this.address);
		return "customerDetails.xhtml";
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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
