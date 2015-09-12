package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Provider {


	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@Column(nullable = false)
		private String name;
		
		@Column(nullable = false)
		private String phoneNumber;
		
		@Column(nullable = false)
		private String email;
		
		@Column(nullable = false)
		private String vatin;
		
		@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	    private Address address;
		
		@ManyToMany(fetch=FetchType.LAZY)
		private List<Product> products;
		
		
		public Provider(){
		}
		
		public Provider(String name, String phoneNumber, String email,
				        String vatin, Address address) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.email = email;
	        this.vatin = vatin;
	        this.address = address;
		}
		
		public void addProduct(Product product) {
			this.products.add(product);
		}
		
		/* GETTERS & SETTERS */

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getVatin() {
			return vatin;
		}

		public void setVatin(String vatin) {
			this.vatin = vatin;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Provider other = (Provider) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Provider [id=" + id + ", name=" + name + ", phoneNumber="
					+ phoneNumber + ", email=" + email + ", vatin=" + vatin
					+ "]";
		}
		
		
		
}


