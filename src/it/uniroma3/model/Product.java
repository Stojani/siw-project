package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Column;


	@Entity
	@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
	public class Product {
        
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Float price;
	
	@Column(length = 2000)
	private String description;

	@Column(nullable = false)
	private String code;
	
	@Column(nullable = true)
	private int stockQuantity;
	
	@ManyToMany(mappedBy="products", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Provider> providers;
	
	public Product() {
    }

	public Product(String name, Float price, String description, String code) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.code = code;
        
}

    /* GETTERS & SETTERS */     
    
   public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
		this.id = id;
	}
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public boolean equals(Object obj) {
        Product product = (Product)obj;
        return this.getCode().equals(product.getCode());
    }

    public int hashCode() {
         return this.code.hashCode();
    }

	
	
}