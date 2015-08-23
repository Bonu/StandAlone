

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Class that demonstratest the Hibernate's configuration capabilities
 *
 */
public class JPAStandaloneTest {

	private SessionFactory sf;
	
	/**
	 * Tests for simple configuration which looks for either
	 * hibernate.properties or hibernate.cfg.xml in classpath.
	 */
	public void testVanillaConfiguration() {
		Configuration configuration = new Configuration().configure();
		configuration.configure();
		System.out.println("Configuration: "+ configuration.configure().toString());
	}

	public void testProgrammaticConfiguration() {

		Configuration configuration = new Configuration()
				.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/test")
				.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
				.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "password")
				.setProperty("hibernate.hbm2ddl.auto", "update")
				.setProperty("hibernate.current_session_context_class", "thread")
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.connection.pool_size", "0");
//		System.out.println("Programmatic Configuration: " + configuration.configure().toString());

		configuration.addAnnotatedClass(TeluguMovie.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sf = configuration.buildSessionFactory(reg);

		Session session = sf.getCurrentSession();
		session.beginTransaction();
		TeluguMovie movie = new TeluguMovie("Bahubali", "The Beginning", "Rajamouli");
		session.save(movie);
		session.getTransaction().commit();
		
		System.out.println("Session: " + session.toString());
	}

	public static void main(String[] args) {
		JPAStandaloneTest test = new JPAStandaloneTest();
		test.testProgrammaticConfiguration();
	}
}
