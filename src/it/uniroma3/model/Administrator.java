package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	
	public Administrator() {}
	
	public Administrator(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public boolean checkPassword(String password) {
		if (this.password.equals(password))
		    return true;
	    else 
	    	return false;
	}
	
	/* GETTERS & SETTERS */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
/*	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-siwProject");
		EntityManager em = emf.createEntityManager();

		Administrator administrator = new Administrator();
		administrator.setFirstName("Marjo");
		administrator.setLastName("Stojani");
		administrator.setEmail("email@email.it");
		administrator.setPassword("pwdbo");

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(administrator);
		tx.commit();

		em.close();
		emf.close();
	}  */

}
