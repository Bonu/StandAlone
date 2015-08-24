package edu.mum.cs.oms.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs.oms.model.StockProduct;

@Repository
public class StockRepositoryImpl implements StockRepository{

	@Autowired
	private SessionFactory sessionFactory;
	 
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//	
//	// TODO change to init level autowired
//	@Inject
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@Override
	public List<StockProduct> getStockProducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(StockProduct.class);
		List<StockProduct> stockProducts = (List<StockProduct>) criteria.list();
		session.getTransaction().commit();
		return stockProducts;
	}

}
