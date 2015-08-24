package edu.mum.cs.oms.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersistenceTest {

	private SessionFactory sessionFactory;

	public PersistenceTest() {
		_init();
	}

	public void _init() {
		Configuration configuration = new Configuration()
				.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/test")
				.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
				.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "password")
//				.setProperty("hibernate.hbm2ddl.auto", "create-drop")
				.setProperty("hibernate.hbm2ddl.auto", "update")
				.setProperty("hibernate.current_session_context_class",
						"thread").setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.connection.pool_size", "0");
		// System.out.println("Programmatic Configuration: " +
		// configuration.configure().toString());

		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(OrderedProduct.class);
		configuration.addAnnotatedClass(Product.class);
//		configuration.addAnnotatedClass(Stock.class);
		configuration.addAnnotatedClass(StockProduct.class);
		
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}
	
	public void persistOrder(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Product prd1 = new Product("Product1","count","PRD100001","CAT1",23.25);
		OrderedProduct op1 = new OrderedProduct();
		op1.setProduct(prd1);
		op1.setItemCount(2);
		Order order1 = new Order();
		order1.addOrderedProduct(op1);
 		session.save(order1);
		session.getTransaction().commit();
	}

	public static void main(String[] args) {
		PersistenceTest pt = new PersistenceTest();
		pt.createStock();
//		pt.persistOrder();
		pt.testStockProduct();
	}

	
	public void createStock(){
		
		Product prd1 = new Product("Product1","count","PRD100001","CAT1",23.25);
		Product prd2 = new Product("Product2","count","PRD100002","CAT1",23.25);
		Product prd3 = new Product("Product3","count","PRD100003","CAT1",33.25);
		Product prd4 = new Product("Product4","count","PRD100004","CAT1",43.25);
		Product prd5 = new Product("Product5","count","PRD100005","CAT2",53.25);
		Product prd6 = new Product("Product6","count","PRD100006","CAT2",63.25);
		Product prd7 = new Product("Product7","count","PRD100007","CAT3",73.25);
		Product prd8 = new Product("Product8","count","PRD100008","CAT3",83.25);
		Product prd9 = new Product("Product9","count","PRD100009","CAT3",93.25);
		Product prd10 = new Product("Product10","count","PRD1000010","CAT4",13.25);
		
		StockProduct sp1 = new StockProduct(prd1,50,1,15.00,"INV001",true);
		StockProduct sp2 = new StockProduct(prd2,50,1,15.00,"INV002",true);
		StockProduct sp3 = new StockProduct(prd3,50,1,15.00,"INV003",true);
		StockProduct sp4 = new StockProduct(prd4,50,1,15.00,"INV004",true);
		StockProduct sp5 = new StockProduct(prd5,50,1,15.00,"INV005",true);
		StockProduct sp6 = new StockProduct(prd6,50,1,15.00,"INV006",true);
		StockProduct sp7 = new StockProduct(prd7,50,1,15.00,"INV007",true);
		StockProduct sp8 = new StockProduct(prd8,50,1,15.00,"INV008",true);
		StockProduct sp9 = new StockProduct(prd9,50,1,15.00,"INV009",true);
		StockProduct sp10 = new StockProduct(prd10,50,1,15.00,"INV010",true);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(sp1);
		session.save(sp2);
		session.save(sp3);
		session.save(sp4);
		session.save(sp5);
		session.save(sp6);
		session.save(sp7);
		session.save(sp8);
		session.save(sp9);
		session.save(sp10);
		session.getTransaction().commit();
		
	}
	
	
	public void testStockProduct(){
		
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(StockProduct.class);
			List<StockProduct> stockProducts = (List<StockProduct>) criteria.list();
			session.getTransaction().commit();
			
			for (StockProduct stockProduct : stockProducts) {
				System.out.println(stockProduct);
			}
	}
	
}
