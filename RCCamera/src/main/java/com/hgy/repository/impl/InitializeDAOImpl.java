package com.hgy.repository.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.repository.BaseDAO;
import com.hgy.repository.InitializeDAO;

@Service
public class InitializeDAOImpl<T> implements InitializeDAO {
	
	@Autowired
	private BaseDAO baseDAO;
	
	
	@Override
	public void truncateAll() {
		String sql1 = "truncate table `rollCallPhoto`;";
		String sql2 = "truncate table `CClazz`;";
		String sql3 = "truncate table `Course`;";
		String sql4 = "truncate table `PersonalPhoto`;";
		String sql5 = "truncate table `photoResult`;";
		String sql6 = "truncate table `RollCall`;";
		String sql7 = "truncate table `Status`;";
		String sql8 = "truncate table `student`;";
		String sql9 = "truncate table `teacher`;";
		String sql10 = "truncate table `studentinclass`;";
		baseDAO.executeBySQL(sql1);
		baseDAO.executeBySQL(sql2);
		baseDAO.executeBySQL(sql3);
		baseDAO.executeBySQL(sql4);
		baseDAO.executeBySQL(sql5);
		baseDAO.executeBySQL(sql6);
		baseDAO.executeBySQL(sql7);
		baseDAO.executeBySQL(sql8);
		baseDAO.executeBySQL(sql9);
		baseDAO.executeBySQL(sql10);
	}

}
