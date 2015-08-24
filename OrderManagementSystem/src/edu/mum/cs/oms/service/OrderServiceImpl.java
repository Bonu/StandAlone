package edu.mum.cs.oms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.oms.model.Order;
import edu.mum.cs.oms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Transactional
	@Override
	public void createOrder(Order order) {
		orderRepository.createOrde(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderRepository.deleteOrder(order);
	}

	@Override
	public Order findOrderById(long orderId) {
		return orderRepository.findOrderById(orderId);
	}

	
}
