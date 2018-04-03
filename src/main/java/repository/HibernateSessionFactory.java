package repository;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static HibernateSessionFactory hibernateSessionFactory;
	private static SessionFactory sessionFactory;
	
	private HibernateSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure(new File("src/resources/hibernate.cfg.xml")) // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println("There is a error");
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	public static synchronized SessionFactory getInstance() {
		if(sessionFactory==null)
			hibernateSessionFactory = new HibernateSessionFactory();
		return HibernateSessionFactory.sessionFactory;
		
	}
	public static synchronized Session getSession() {
		if(sessionFactory==null)
			hibernateSessionFactory = new HibernateSessionFactory();
		return HibernateSessionFactory.sessionFactory.openSession();
		
	}
	
	public void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
}
