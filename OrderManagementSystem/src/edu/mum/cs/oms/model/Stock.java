package edu.mum.cs.oms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STOCK")
public class Stock {
	
	@Id
	@Column(name="StockId")
	private int stockId;
	
	@OneToMany
	private List<StockProduct> stockProducts = new ArrayList<StockProduct>();
	private int productCount;
	private float weight;
	
	public int getStockId() {
		return stockId;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	public List<StockProduct> getStockProducts() {
		return stockProducts;
	}
	
	public void setStockProducts(List<StockProduct> stockProducts) {
		this.stockProducts = stockProducts;
	}
	
	public int getProductCount() {
		return productCount;
	}
	
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public void addStockProduct(StockProduct stockProduct){
		stockProducts.add(stockProduct);
	}
	
	
}
