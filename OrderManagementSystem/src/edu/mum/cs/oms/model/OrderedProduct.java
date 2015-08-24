package edu.mum.cs.oms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ORDERED_PRODUCT")
public class OrderedProduct {
	
	@Id
	@Column(name="orderedProductId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderedProductId;
	
	@OneToOne
//	@Cascade(CascadeType.ALL)
	private Product product;
	
	private int itemCount;
	
	private float weightInKG;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public float getWeightInKG() {
		return weightInKG;
	}
	public void setWeightInKG(float weightInKG) {
		this.weightInKG = weightInKG;
	}
	
}
