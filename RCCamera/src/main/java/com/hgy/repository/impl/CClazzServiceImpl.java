package com.hgy.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.model.CClazz;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.CClazzService;

@Service
public class CClazzServiceImpl implements CClazzService {
	
	@Autowired
	private BaseDAO baseDAO;
	
	@Override
	public List<CClazz> findClazzByTeacherId(int id) {
		Criterion criterion = Restrictions.eq("teacherID",id);
		ArrayList<Criterion> criterions = new ArrayList<>();
		criterions.add(criterion);
		List<CClazz> cClazzs= baseDAO.queryByCriteria(CClazz.class, criterions);
		return cClazzs;
	}

	@Override
	public CClazz findClazzById(int id) {
		CClazz cClazz = (CClazz) baseDAO.find(CClazz.class, id);
		return cClazz;
	}

}
