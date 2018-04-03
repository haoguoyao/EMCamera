package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import model.RollCallPhoto;
import model.Status;
import model.CClazz;
import model.PhotoResult;
import model.RollCall;
import model.Student; 

public class RollCallDAO {
	public static void createRollCallPhoto(int rollCallID,String photoURL) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		RollCallPhoto photo = new RollCallPhoto(rollCallID, photoURL);
		session.save(photo);
		tx.commit();
		session.close();
	}
	public static RollCall retrieveRollCall(int rollCallID) {
		Session session = HibernateSessionFactory.getSession();
		RollCall rollCall = session.get(RollCall.class,rollCallID);
		return rollCall;
		
	}
	public static void createPhotoResult(PhotoResult photoResult) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(photoResult);
		tx.commit();
		session.close();
		
	}
	
	public List<Status> retrieveStatusByStudent(int studentID){
		Session session = HibernateSessionFactory.getSession();
		List<Status> statuses = session.createCriteria(Status.class)
			    .add( Restrictions.eq("studentID",studentID) )
			    .list();
		session.close();
		return statuses;
	}
	public static List<String> retrievePhotoResultByStudent(String studentID){
		return retrievePhotoResultByStudent(Integer.valueOf(studentID));
	}
	public static List<String> retrievePhotoResultByStudent(int studentID){
		Session session = HibernateSessionFactory.getSession();
		List<PhotoResult> photoResults = session.createCriteria(PhotoResult.class)
			    .add( Restrictions.eq("studentID",studentID) )
			    .list();
		session.close();
		List<String> photoURL = new ArrayList<>();
		for(PhotoResult photoResult:photoResults)
		{
			photoURL.add(photoResult.getPhotoURL());
		}
		return photoURL;
	}
	public static int createOrUpdateRollCall(RollCall rollCall) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(rollCall); 
		tx.commit();
		session.close();
		return rollCall.getId();
	}
		
}
