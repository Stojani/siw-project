package it.uniroma3.facade;

import it.uniroma3.model.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.TypedQuery;


@Stateless(name="orderFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName="unit-siwProject")
	private EntityManager em;
	
	public Order startOrder(Customer customer) {
		Order order = new Order (customer);
		return order;
		
	}
	
	public Order confirmOrder(Order order) {
		em.persist(order);
		return order;
		
	}
	
	public Order getOrder(Long id) {
		Order order = this.em.find(Order.class, id);
		order.getOrderLines();				
		return order;
	}
	
	public List<OrderLine> getAllOrderLines(Order order){
		TypedQuery<OrderLine> q= em.createQuery("SELECT ol from OrderLine ol WHERE ol.order = :order", OrderLine.class);
		List<OrderLine> orderLines= q.getResultList();
		return orderLines;
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

	//public List<Order> getCustomerOrders(Long customerId) {
	//	Customer customer = this.em.find(Customer.class, customerId);
//		return customer.getOrders();
//	}
	
	public Customer getCustomerFromOrderId(Long id) throws Exception {
		Order order = this.em.find(Order.class, id);
		if(order == null)
			throw new Exception();
		Customer customer = order.getCustomer();
		return customer;
	}
	
}
