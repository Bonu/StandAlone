package edu.mum.cs.oms.repository;

import java.util.List;

import edu.mum.cs.oms.model.StockProduct;

public interface StockRepository {
	public List<StockProduct> getStockProducts();
}
