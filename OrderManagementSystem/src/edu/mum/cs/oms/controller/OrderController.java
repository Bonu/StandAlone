package edu.mum.cs.oms.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.oms.model.StockProduct;
import edu.mum.cs.oms.service.OrderService;
import edu.mum.cs.oms.service.OrderServiceImpl;
import edu.mum.cs.oms.service.StockService;

@ManagedBean
@Controller
//@RequestMapping(value = "/order")
public class OrderController {
	
//	@Autowired
//	OrderService orderService = new OrderServiceImpl();
	
	@Autowired
	OrderService orderService;
	
	
	@Autowired
	StockService stockService;
	
//	@RequestMapping(value = { "/neworder" }, method = RequestMethod.GET)
	
	public String newOrder(){
		return "neworder";
	}
	
	public List<StockProduct> getStockProducts(){
		return stockService.getStockProducts();
	}
	
	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public void createOrder(){
		
	}
	
	@RequestMapping(value = { "/delete" }, method = RequestMethod.POST)
	public void deleteOrder(){
		
	}
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public void findOrder(){
		
	}
	
}
