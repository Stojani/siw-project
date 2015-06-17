package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.facade.OrderFacade;
import it.uniroma3.facade.ProductFacade;
import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

@ManagedBean
public class OrderController {
	
	@EJB
	private OrderFacade orderFacade;
	@EJB
	private ProductFacade productFacade;
	@EJB
	private CustomerFacade customerFacade;
	
	private Order order;
	private List<Order> orders;
	private Customer customer;
	
	public String createOrder() {
		Order order = orderFacade.createOrder(this.customer.getId());
		this.order = order;
		productFacade.getAllProducts();
		return "add products to order";
	}

	public String endOrder() {
		Order order = orderFacade.getOrder(this.order.getId());
		this.order=order;
		return "confirm Order";
	}
	
	//public String confirmOrder() {
	//	List<Order> orders = orderFacade.getCustomerOrders(this.customer.getId());
		//this.orders=orders;
	//	return "customerArea";
	//}
	
	public String cancelOrder() {
		orderFacade.deleteOrder(order);
		return "customerArea";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
