package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless(name="addressFacade")
public class AddressFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	/* the address will be created at the same time of the registration of a new customer
	 * because of we don't have to get all the existing addresses in the DB */
	
    public Address createAddress(Long id, String street, String city, String state, String zipcode, String country) {
		Customer customer = this.em.find(Customer.class, id);
		Address address = new Address(street, city, state, zipcode, country);
		customer.setAddress(address);
		this.em.persist(address);
		return address;
	}
    
	public Address getAddress(Long id) {
		Address address = this.em.find(Address.class, id);
		return address;
	}
	

	public List<Address> getAllAddreses() {
		CriteriaQuery<Address> cq = em.getCriteriaBuilder().createQuery(Address.class);
		cq.select(cq.from(Address.class));
		List<Address> addresses = em.createQuery(cq).getResultList();
		return addresses;
	}
	
	public void updateAddress(Address address) {
        em.merge(address);
	}
	
	public void deleteAdddress(Address address) {
		this.em.remove(address);
	}
	
	public void deleteAddress(Long id) {
		Address address = this.em.find(Address.class, id);
		this.em.remove(address);
	}
	
	

}
