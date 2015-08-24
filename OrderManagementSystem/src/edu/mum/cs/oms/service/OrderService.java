package edu.mum.cs.oms.service;

import edu.mum.cs.oms.model.Order;

public interface OrderService {
	
	public void createOrder(Order order);
	public void deleteOrder(Order orderId);
	public Order findOrderById(long orderId);
}
