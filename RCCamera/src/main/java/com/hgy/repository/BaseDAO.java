package com.hgy.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public interface BaseDAO<T> {
	public List queryBySQL(String sql);
	public int executeBySQL(String sql);
    void delete(T t);
	T find(Class<T> clazz, int id);
	void create(T t);
	void save(T t);
	void saveNew(T t);
	public Session getSession();
	public <T> List<T> queryByCriteria(Class<T> theClass, List<Criterion> criterions);

}
