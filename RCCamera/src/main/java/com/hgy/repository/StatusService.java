package com.hgy.repository;

import java.util.List;

import com.hgy.model.Status;
import com.hgy.valueObject.StatusVO;

public interface StatusService {
	public void updateStatusByStatusVO(StatusVO statusVO);
	public List<Status> getStatusByStudentId(int studentId);
	public List<Status> getStatusByRollCallId(int rollCallID);
	public Status getStatusByStudentIdAndRollCallID(int studentId,int rollCallID);
}
