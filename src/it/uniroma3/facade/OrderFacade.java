package it.uniroma3.facade;

import it.uniroma3.model.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless(name="orderFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Order createOrder(Long id) {
		Customer customer = this.em.find(Customer.class, id);
		Order order = new Order(customer);
		customer.addOrder(order);
		this.em.persist(order);
		this.em.merge(customer);
		return order;
	}
	
	public Order getOrder(Long id) {
		Order order = this.em.find(Order.class, id);
		order.getOrderLines();				
		return order;
	}
	
	public List<Order> getAllOrders() {
		CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
		cq.select(cq.from(Order.class));
		List<Order> orders = em.createQuery(cq).getResultList();
		return orders;
	}
	
	public void updateOrder(Order order) {
        em.merge(order);
	}
	
	public void deleteOrder(Order order) {
		this.em.remove(order);
	}
	
	public void deleteOrder(Long id) {
		Order order = this.em.find(Order.class, id);
		this.em.remove(order);
	}

	public List<Order> getCustomerOrders(Long customerId) {
		Customer customer = this.em.find(Customer.class, customerId);
		return customer.getOrders();
	}
	
	public Customer getCustomerFromOrderId(Long id) throws Exception {
		Order order = this.em.find(Order.class, id);
		if(order == null)
			throw new Exception();
		Customer customer = order.getCustomer();
		return customer;
	}
	
}
