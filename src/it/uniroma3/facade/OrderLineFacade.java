package it.uniroma3.facade;

import it.uniroma3.model.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="orderLineFacade")
public class OrderLineFacade {

	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public OrderLine getOrderLine(Long id) {
		OrderLine orderLine = this.em.find(OrderLine.class, id);
		return orderLine;
	}
	
	public List<OrderLine> getAllOrderLines(Long id) {
		List<OrderLine> orderLines = 
				this.em.find(Order.class, id).getOrderLines();
		return orderLines;
	}

	public void updateOrderLineQuantity(Long id, Integer quantity) {
		OrderLine orderLine = this.em.find(OrderLine.class, id);
		orderLine.setQuantity(quantity);
		this.em.merge(orderLine);
	}
	
	public void deleteOrderLine(Long orderId, Long orderLineId) {
		OrderLine orderLine = this.em.find(OrderLine.class, orderLineId);
		Order order = this.em.find(Order.class, orderId);
		this.em.remove(orderLine);
		order.removeOrderLine(orderLine);
		this.em.merge(order);
	}
	
	public OrderLine createOrderLine(Long id, Product product, Integer quantity) {
		OrderLine orderLine = new OrderLine(product, quantity);
		Order order = this.em.find(Order.class, id);
		order.addOrderLine(orderLine);
		this.em.persist(orderLine);
		this.em.merge(order);
		return orderLine;
	}
	
	
}
