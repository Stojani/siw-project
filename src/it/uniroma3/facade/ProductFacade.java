package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="productFacade")
public class ProductFacade {
	
	@PersistenceContext(unitName = "unit-project")
    private EntityManager em;
    
	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name, price, description, code);
		em.persist(product);
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = em.find(Product.class, id);
		return product;
	}
	
	public Product getProduct(String name) {
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name =:name", Product.class);
		return query.setParameter("name", name).getSingleResult();
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}
	
	public List<Product> getProviderProducts(Long providerId) {
		Provider provider = this.em.find(Provider.class, providerId);
		return provider.getProducts();
	}
	
	public List<Provider> getProvidersFromProductId(Long id) throws Exception {
		Product product = this.em.find(Product.class, id);
		if(product == null)
			throw new Exception();
		List<Provider> providers = product.getProviders();
		return providers;
	}
	
	public void addProductToProvider(Long productId, Long providerId) {
		Product product = this.em.find(Product.class, productId);
		Provider provider = this.em.find(Provider.class, providerId);
		provider.addProduct(product);
	}
	
	
	public void updateProduct(Product product) {
        em.merge(product);
	}
	
	private void deleteProduct(Product product) {
        em.remove(product);
    }

	public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        deleteProduct(product);
	}

	
	
}
