package com.hgy.repository;

import java.util.List;

import com.hgy.model.RollCall;
import com.hgy.valueObject.RollCallVO;


public interface RollCallService {	
	public int updateRollCall(RollCall rollCall);
	public int createRollCallByClazzId(Integer CClazzId);
	public RollCall findLatestRollCallByClazzId(Integer clazzId);
	public List<RollCall> findRollCallByClazzId(Integer clazzId);
	public List<RollCallVO> findRollCallVOByTeacherId(Integer teacherId);
}
