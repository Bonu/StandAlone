package edu.mum.cs.oms.repository;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.mum.cs.oms.model.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	// TODO change to init level autowired
	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createOrde(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
	}

	@Override
	public void deleteOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();
	}

	@Override
	public Order findOrderById(long orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Order order = (Order)session.load(Order.class, orderId);
		return order;
	}

}
