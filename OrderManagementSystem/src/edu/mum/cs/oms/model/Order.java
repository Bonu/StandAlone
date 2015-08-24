package edu.mum.cs.oms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ORDER_TABLE")
public class Order {
	
	@Id
	@Column(name="OrderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId=0;
	
	@Column(name="TotalAmount")
	private double totalAmount;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	// TODO move the cal logic to helper service class
	public void addOrderedProduct(OrderedProduct op){
		orderedProducts.add(op);
		if(op.getItemCount() > 0){
			totalAmount = totalAmount + op.getProduct().getSellinPrice() * op.getItemCount();
		}else{
			totalAmount = totalAmount + op.getProduct().getSellinPrice() * op.getWeightInKG();
		}
	}
}
