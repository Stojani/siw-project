package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.facade.OrderFacade;
import it.uniroma3.facade.OrderLineFacade;
import it.uniroma3.facade.ProductFacade;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Product;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;


@ManagedBean
@SessionScoped
public class OrderLineController {
	
	@EJB
	private OrderLineFacade orderLineFacade;
	@EJB
	private OrderFacade orderFacade;
	@EJB
	private ProductFacade productFacade;
	
	@ManagedProperty(value="#{param.orderLineId}")
	private Long orderLineId;
	
	private Float unitPrice;
	private Integer quantity;
	private OrderLine orderLine;
	private List<OrderLine> orderLines;
	private Order order;
	private Product product;
	
	public String createOrderLine() {
		orderLineFacade.createOrderLine(this.order.getId(),this.product, quantity);
		productFacade.getAllProducts();
		return "chooseProducts";
	}
	
	public String updateOrderLineQuantity() {
		orderLineFacade.updateOrderLineQuantity(this.orderLine.getId(), 
				quantity);
		this.order=orderFacade.getOrder(this.order.getId());
		return "confirmOrder";	
	}
	
	public String cancelOrderLine() {
		orderLineFacade.deleteOrderLine(this.order.getId(),
				orderLineId);
		Order order = orderFacade.getOrder(this.order.getId());
		this.order=order;
		return "confirmOrder";
	}

	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	


}
