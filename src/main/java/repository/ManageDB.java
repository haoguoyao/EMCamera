package repository;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageDB {
	
	public static void initialize() {
		String sql = "truncate table photoresult;";
//				+ "truncate table status;"
//				+ "truncate table teacher;"
//				+ "truncate table rollcall;"
//				+ "truncate table rollcallphoto;"
//				+ "truncate table cclazz;"
//				+ "truncate table course;"
//				+ "truncate table personalphoto;"
//				+ "truncate table studentinclass;"
//				+ "truncate table student;";
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createNativeQuery(sql);
		query.executeUpdate();
		tx.commit();
	}

}
