package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.facade.AddressFacade;
import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	private java.util.Date registrationDate;
	private List<Order> orders;
	
	private Customer customer;
	
	private Address address;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country; 
	private String errMessage; 
	
	public String createCustomer() {

		this.address=addressFacade.createAddress(street, city, state, zipcode, country);
		this.customer=customerFacade.createCustomer(firstName, lastName, email, password, phoneNumber, dateOfBirth, this.address);
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
