package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.facade.OrderFacade;
import it.uniroma3.facade.ProductFacade;
import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Product;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class OrderController {
	
	@EJB
	private OrderFacade orderFacade;
	@EJB
	private ProductFacade productFacade;
	@EJB
	private CustomerFacade customerFacade;
	
	private Order order;
	private List<Order> orders;
	private List<OrderLine> orderLines;
	private Customer customer;
	
	public String startOrder() {
		Order order = orderFacade.startOrder(this.customer.getId());
		this.order = order;
		return "products.xhtml";
	}
	
	public String startOrder(Customer customer) {
		Order order = orderFacade.startOrder(this.customer);
		this.order= order;
		return "producst.xhtml";
	}

	public String confirmOrder() {
		Order order = orderFacade.confirmOrder(this.order);
		this.order=order;
		this.customer.addOrder(order);
		return "customerHome.xhtml";
	}
	
public List<OrderLine> listOrderLines() {
		this.orderLines = orderFacade.getAllOrderLines(this.order);
		return orderLines; 
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
