package edu.mum.cs.oms.repository;

import edu.mum.cs.oms.model.Order;

public interface OrderRepository {
	public void createOrde(Order order);

	public void deleteOrder(Order order);

	public Order findOrderById(long orderId);
}
