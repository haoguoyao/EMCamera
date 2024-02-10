package com.hgy.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.hgy.model.CClazz;
import com.hgy.model.RollCall;
import com.hgy.model.Status;
import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.CClazzService;
import com.hgy.repository.RollCallService;
import com.hgy.repository.StatusService;
import com.hgy.valueObject.RollCallVO;
import com.hgy.valueObject.StatusVO;

@Controller
public class RollCallHandler {
	@Autowired
	private BaseDAO baseDAO;
	@Autowired
	private RollCallService rollCallService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private CClazzService cClazzService;
	
	@RequestMapping(value="/teacher/RollCallHandler_getStatusByRollCallID")
	@ResponseBody
	public Set<StatusVO> getStatus(Integer rollCallId){
		System.out.println("/teacher/RollCallHandler_getStatusByRollCallID "+rollCallId);
		Set<StatusVO> statusVOs = new HashSet<>();
		RollCall rollCall = (RollCall) baseDAO.find(RollCall.class, rollCallId);
		Gson gson = new Gson();
		if(rollCall!=null) {
			for(Status status:rollCall.getStatuses()) {
				Student student = (Student)baseDAO.find(Student.class, status.getStudentID());
				StatusVO statusVO= new StatusVO(status);
				statusVO.setName(student.getName());
				statusVOs.add(statusVO);
			}
			return statusVOs;
		}else {
			return null;
		}
		
	}
	@RequestMapping(value="/teacher/RollCallHandler_getCurrentRollCall")
	@ResponseBody
	public RollCall getLatestRollCall(Integer clazzId){
		System.out.println("/teacher/RollCallHandler_getCurrentRollCall "+clazzId);
		RollCall rollCall = rollCallService.findLatestRollCallByClazzId(clazzId);
		Gson gson = new Gson();
		System.out.println(gson.toJson(rollCall));
		return rollCall;
	}
	@RequestMapping(value="/teacher/RollCallHandler_createRollCall")
	@ResponseBody
	public int createRollCall(Integer clazzId){	
		int newRollCallId = rollCallService.createRollCallByClazzId(clazzId);
		return newRollCallId;
	}
	@RequestMapping(value="/teacher/RollCallHandler_setStatusByRollCallID")
	@ResponseBody
	public int setStatus(Integer rollCallId,String statusVOString){
		System.out.println("RollCall handler setStatusByRollCallID");
		System.out.println(statusVOString);
		Gson gson = new Gson();
		List<StatusVO> statusVOs = gson.fromJson(statusVOString, new TypeToken<List<StatusVO>>(){}.getType());
		if(statusVOs!=null) {
			for(StatusVO statusVO:statusVOs) {
				statusService.updateStatusByStatusVO(statusVO);
			}
		}
		return 1;
	}
	@RequestMapping(value="/teacher/RollCallHandler_endClass")
	@ResponseBody
	public String endClass(Integer rollCallId){
		System.out.println("RollCall "+rollCallId+" endClass");
		RollCall rollCall = (RollCall) baseDAO.find(RollCall.class, rollCallId);
		rollCall.setOnRollCall(false);
		rollCallService.updateRollCall(rollCall);
		return "ok";
	}
	@RequestMapping(value="/teacher/RollCallHandler_findRollCallVOByTeacherId")
	@ResponseBody
	public List<RollCallVO> findRollCallVOByTeacherId(Integer teacherId){
		System.out.println("Get rollcall by teacher id "+ teacherId);
		List<RollCallVO> rollCallVOs = rollCallService.findRollCallVOByTeacherId(teacherId);
		Gson gson = new Gson();
		System.out.println(gson.toJson(rollCallVOs));
		return rollCallVOs;	
	}
	

}
