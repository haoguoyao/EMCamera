package dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import repository.HibernateSessionFactory;

public class SessionFactoryTest {

	@Test
	public void test() {
		SessionFactory sessionFactory = HibernateSessionFactory.getInstance();
		Session session = sessionFactory.openSession();
	}

}
