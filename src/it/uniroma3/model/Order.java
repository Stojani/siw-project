package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date creationTime;

	@ManyToOne
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name= "orders_id")
	private List<OrderLine> orderLines;
	
	public Order(){
	}
	
	public Order(Customer customer) {
        this.customer = customer;
        this.creationTime = new Date();
        this.orderLines = new ArrayList<OrderLine>();
	}
	
	public OrderLine createOrderLine(Product product, Integer quantity) {
		OrderLine orderLine = new OrderLine(product, quantity);
		this.orderLines.add(orderLine);
		return orderLine;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}

	public void removeOrderLine(OrderLine orderLine) {
		this.orderLines.remove(orderLine);
	}
	
	
	/*  GETTER & SETTERS */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", creationTime=" + creationTime + "]";
	}
   
	
}

