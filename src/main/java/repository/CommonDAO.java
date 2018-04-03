package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Course;

public class CommonDAO {
	public static void saveObject(Object object) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(object);
		tx.commit();
		session.close();
	}
	public static void saveCourse(Course course) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(course);
		tx.commit();
		session.close();
	}

}
