package edu.mum.cs.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.oms.model.StockProduct;
import edu.mum.cs.oms.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository stockRepository;
	
	
	@Override
	public List<StockProduct> getStockProducts() {
		return stockRepository.getStockProducts();
	}

}
