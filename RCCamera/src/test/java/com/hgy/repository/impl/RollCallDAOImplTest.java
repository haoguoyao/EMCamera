package com.hgy.repository.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.hgy.model.RollCall;
import com.hgy.model.Status;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.RollCallService;
import com.hgy.repository.impl.RollCallServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"}) 
public class RollCallDAOImplTest extends RollCallServiceImpl {
	@Autowired
	private RollCallService rollCallService;
	@Autowired
	private BaseDAO baseDAO;
	@Test
	public void testUpdateRollCall() throws InterruptedException {
		//RollCall rollCall = rollCallService.findLatestRollCallByClazzId(1);
		for(int i = 1;i<5000;i++) {
			int b = i*i;
			System.out.println(b);
		}
		return;
	}
	@Test
	public void testCreateRollCall() {
		//rollCallService.createRollCallByClazzId(1);
		for(int i = 1;i<6000;i++) {
			int b = i*i;
			System.out.println(b);
		}
		return;
	}
	@Test
	public void testGetRollCall(){
//		RollCall rollCall = rollCallService.findLatestRollCallByClazzId(1);
//		Set<Status> statuses = rollCall.getStatuses();
//		System.out.println(statuses.size());
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(rollCall));
		for(int i = 1;i<3200;i++) {
			int b = i*i;
			System.out.println(b);
		}
		return;
	}
	@Test
	public void testGetRollCall2(){
//		RollCall rollCall = (RollCall)baseDAO.find(RollCall.class,17);
//		Set<Status> statuses = rollCall.getStatuses();
//		System.out.println(statuses.size());
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(rollCall));
		return;
	}



}
