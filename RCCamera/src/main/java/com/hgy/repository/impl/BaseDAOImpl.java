package com.hgy.repository.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;


@Service
public class BaseDAOImpl<T> implements BaseDAO<T> {
	
	@Autowired  
    private SessionFactory sessionFactory;    
    
	@Override
    public Session getSession() {    
        return sessionFactory.getCurrentSession();    
    }   
	@Transactional
	public List queryBySQL(String sql) {
		List<Object[]> list = this.getSession().createNativeQuery(sql).getResultList();    
        return list;   
	}
	
	@Transactional
	public int executeBySQL(String sql) {
		int result ;    
        NativeQuery query = this.getSession().createNativeQuery(sql);    
        result = query.executeUpdate();    
        return result; 
	}
	@Transactional
	@Override
    public T find(Class<T> clazz, int id) {
        return (T) getSession().get(clazz, id);
    }
	
	@Transactional
    @Override
    public void create(T t) {
        getSession().persist(t);
    }
	@Transactional
    @Override
    public void save(T t) {
        getSession().saveOrUpdate(t);

    }
	@Transactional
    @Override
    public void delete(T t) {
        getSession().delete(t);
    }
	@Transactional
    @Override
    public void saveNew(T t) {
        // TODO Auto-generated method stub
        getSession().save(t);

    }
    
    @Transactional
    @Override
    public <T> List<T> queryByCriteria(Class<T> theClass, List<Criterion> criterions) {
		Criteria criteria = this.getSession().createCriteria(theClass);
		for(Criterion criterion:criterions)
			criteria.add(criterion);
		List<T> list = criteria.list();
		return list;
	}
    

}

