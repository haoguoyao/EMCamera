package com.hgy.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.model.CClazz;
import com.hgy.model.Course;
import com.hgy.model.RollCall;
import com.hgy.model.Status;
import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.CClazzService;
import com.hgy.repository.CourseService;
import com.hgy.repository.RollCallService;
import com.hgy.valueObject.RollCallVO;

@Service
public class RollCallServiceImpl implements RollCallService {
	
	@Autowired  
    private SessionFactory sessionFactory; 
	@Autowired
	private CClazzService cClazzService;
	@Autowired
	private BaseDAO baseDAO;
	@Autowired
	private CourseService courseService;
	public int UpdateRollCall(RollCall rollCall) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(rollCall); 
		tx.commit();
		session.close();
		return rollCall.getId();
	}
	
	public int createRollCall(RollCall rollCall) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(rollCall); 
		tx.commit();
		session.close();
		return rollCall.getId();
	}
	@Override
	public int updateRollCall(RollCall rollCall) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(rollCall); 
		tx.commit();
		session.close();
		return rollCall.getId();
	}

	/**
	 * 在创建rollcall的时候同时创建一组status
	 * 
	 * 
	 * */
	@Override
	public int createRollCallByClazzId(Integer cClazzId) {
		System.out.println(cClazzId);
		CClazz cClazz = cClazzService.findClazzById(cClazzId);
		RollCall rollCall = new RollCall(cClazz);
		baseDAO.save(rollCall);
		int id = rollCall.getId();
		Set<Student> students = cClazz.getStudents();
		for(Student student:students) {
			Status status = new Status();
			status.setRollCallID(id);
			status.setIsArrive(2);
			status.setStudentID(student.getId());
			baseDAO.save(status);
		}
		return id;
		
	}

	@Override
	public RollCall findLatestRollCallByClazzId(Integer clazzId) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("clazzID", clazzId);
		criterions.add(criterion1);
		ArrayList<RollCall> rollCalls = (ArrayList<RollCall>) baseDAO.queryByCriteria(RollCall.class, criterions);
		if(rollCalls.isEmpty())
			return null;
		else {
			RollCall rollCall = rollCalls.get(0);
			for(RollCall temp:rollCalls) {
				if(temp.getId()>rollCall.getId()) {
					rollCall = temp;
				}
			}
			return rollCall;
		}
	}
	@Override
	public List<RollCall> findRollCallByClazzId(Integer clazzId) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("clazzID", clazzId);
		criterions.add(criterion1);
		ArrayList<RollCall> rollCalls = (ArrayList<RollCall>) baseDAO.queryByCriteria(RollCall.class, criterions);
		if(rollCalls.isEmpty())
			return null;
		else {
			return rollCalls;
		}
	}
	@Override
	public List<RollCallVO> findRollCallVOByTeacherId(Integer teacherId) {
		List<RollCallVO> rollCallVOs = new ArrayList<>();
		List<CClazz> cClazzs = cClazzService.findClazzByTeacherId(teacherId);
		for(CClazz cClazz:cClazzs) {
			Course course = courseService.findCourseById(cClazz.getCourseID());
			List<RollCall> rollCalls = findRollCallByClazzId(cClazz.getId());
			if(rollCalls!=null) {
				for(RollCall rollCall:rollCalls) {
					RollCallVO rollCallVO = new RollCallVO(rollCall);
					rollCallVO.setCClazzName(course.getName());
					rollCallVOs.add(rollCallVO);
				}
			}
		}
		return rollCallVOs;
	}
	
	
	

}
