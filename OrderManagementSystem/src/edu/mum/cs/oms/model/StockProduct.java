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
@Table(name="StockProduct")
public class StockProduct {
	

	@Id
	@Column(name="stockProductId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stockProductId;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Product product;
	public long getStockProductId() {
		return stockProductId;
	}

	public void setStockProductId(long stockProductId) {
		this.stockProductId = stockProductId;
	}

	private int itemCount;
	private float weightInKG;
	private double buyingPrice;
	private String inventroyId;
	private boolean isCount;
	
	public StockProduct(){
		
	}
	
	public StockProduct(Product product, int itemCount, float weightInKG,
			double buyingPrice, String inventroyId, boolean isCount) {
		super();
		this.product = product;
		this.itemCount = itemCount;
		this.weightInKG = weightInKG;
		this.buyingPrice = buyingPrice;
		this.inventroyId = inventroyId;
		this.isCount = isCount;
	}
	
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
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public String getInventroyId() {
		return inventroyId;
	}
	public void setInventroyId(String inventroyId) {
		this.inventroyId = inventroyId;
	}

	public boolean isCount() {
		return isCount;
	}
	
	public void setCount(boolean isCount) {
		this.isCount = isCount;
	}
	
	@Override
	public String toString() {
		return "StockProduct [stockProductId=" + stockProductId + ", product="
				+ product + ", itemCount=" + itemCount + ", weightInKG="
				+ weightInKG + ", buyingPrice=" + buyingPrice
				+ ", inventroyId=" + inventroyId + ", isCount=" + isCount + "]";
	}

}
