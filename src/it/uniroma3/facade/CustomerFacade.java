package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="customerFacade")
public class CustomerFacade {

	@PersistenceContext(unitName="unit-siwProject")
	private EntityManager em;

	public Customer createCustomer(String firstName, String lastName, String email, String password, String phoneNumber,		
			Date dateOfBirth, Address address) {
		Customer customer = new Customer(firstName, lastName, email, password, phoneNumber, dateOfBirth, new Date());
		customer.setAddress(address);
		this.em.persist(customer);
		return customer;
	}

	public Customer getCustomerById(Long id) {
		return this.em.find(Customer.class, id);
	}
	
	public Customer getCustomerByEmail(String email) {
		TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c where c.email = :email" , Customer.class);
		return  q.setParameter("email",email).getSingleResult();
	}
	
	public List<Customer> getAllCustomers() {	
		CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
		cq.select(cq.from(Customer.class));
		List<Customer> customers = em.createQuery(cq).getResultList();
		return customers;
	}
	
	public void updateCustomer(Customer customer) {
        em.merge(customer);
	}

	public void deleteCustomer(Customer customer) {
		this.em.remove(customer);
	}
	
	public void deleteCustomerById(Long id){
		Customer customer = em.find(Customer.class, id);
		deleteCustomer(customer);
	}


}
