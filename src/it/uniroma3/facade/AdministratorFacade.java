package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;



@Stateless(name="administratorFacade")
public class AdministratorFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Administrator createAdministrator(String firstName, String lastName, String email, String password) {
		Administrator administrator = new Administrator(firstName, lastName, email, password);
		this.em.persist(administrator);
		return administrator;
	}
	
	public Administrator findAdministrator(Long id) {
		Administrator administrator = this.em.find(Administrator.class, id);
		return administrator;
	}
	
	public Administrator getAdministrator(String email, String password)
			throws Exception {
		TypedQuery<Administrator> query = em.createQuery(
				"SELECT a FROM Admin a where a.email =:email", Administrator.class);
		query.setParameter("email", email);
		Administrator administrator = query.getSingleResult();
		if (administrator == null) {
			throw new Exception();
		}
		administrator.checkPassword(password);
		return administrator;	
	}
	
	public List<Administrator> getAllAdministrators() {
		CriteriaQuery<Administrator> cq = em.getCriteriaBuilder().createQuery(Administrator.class);
		cq.select(cq.from(Administrator.class));
		List<Administrator> administratorList = em.createQuery(cq).getResultList();
		return administratorList;
	}
	
	public void updateAdministrator(Administrator administrator) {
        em.merge(administrator);
	}
	
	public void deleteAdministrator(Administrator administrator) {
		this.em.remove(administrator);
	}
	
	public void deleteAdministrator(Long id) {
		Administrator administrator = this.em.find(Administrator.class, id);
		this.em.remove(administrator);
	}
	
}
