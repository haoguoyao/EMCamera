package com.hgy.repository.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hgy.model.RollCall;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.impl.BaseDAOImpl;
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"}) 
public class BaseDAOImplTest extends BaseDAOImpl {
	@Autowired
	private BaseDAO baseDAO;
	@Test
	public void test() {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("clazzID", 1);
		criterions.add(criterion1);
		ArrayList<RollCall> rollCalls = (ArrayList<RollCall>) baseDAO.queryByCriteria(RollCall.class, criterions);
	}

}
