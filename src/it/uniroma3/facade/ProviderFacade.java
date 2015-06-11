package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="providerFacade")
public class ProviderFacade {

	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Provider createProvider(String name, String phoneNumber, String email, String vatin, Address address) {
		Provider provider = new Provider(name, phoneNumber, email, vatin, address);
		this.em.persist(provider);
		return provider; 
	}
	
	public Provider getProvider(Long id) {
		Provider provider = this.em.find(Provider.class, id);
		return provider;
	}
	
	public List<Provider> getAllProviders()  {
		CriteriaQuery<Provider> cq = em.getCriteriaBuilder().createQuery(Provider.class);
		cq.select(cq.from(Provider.class));
		List<Provider> providers = em.createQuery(cq).getResultList();
		return providers;
	}
	
	public void updateProvider(Provider provider) {
        em.merge(provider);
	}
	
	public void deleteProvider(Provider provider) {
		this.em.remove(provider);
	}
	
	public void deleteProvider(Long id) {
		Provider provider = this.em.find(Provider.class, id);
		this.em.remove(provider);
	}
	
	
	
}
