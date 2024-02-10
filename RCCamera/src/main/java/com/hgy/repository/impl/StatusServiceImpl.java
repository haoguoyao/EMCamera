package com.hgy.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgy.model.Status;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StatusService;
import com.hgy.valueObject.StatusVO;
@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private BaseDAO baseDAO;
	@Override
	public void updateStatusByStatusVO(StatusVO statusVO) {
		Status status = statusVO.getStatus();
		baseDAO.save(status);

	}
	@Override
	public List<Status> getStatusByStudentId(int studentId) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("studentId", studentId);
		criterions.add(criterion1);
		ArrayList<Status> statuses = (ArrayList<Status>) baseDAO.queryByCriteria(Status.class, criterions);
		if(statuses.isEmpty())
			return null;
		else {
			return statuses;
		}
	}
	@Override
	public Status getStatusByStudentIdAndRollCallID(int studentId, int rollCallID) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("studentId", studentId);
		Criterion criterion2 = Restrictions.eq("rollCallID", rollCallID);
		criterions.add(criterion1);
		criterions.add(criterion2);
		ArrayList<Status> statuses = (ArrayList<Status>) baseDAO.queryByCriteria(Status.class, criterions);
		if(statuses.isEmpty())
			return null;
		else {
			return statuses.get(0);
		}
	}
	@Override
	public List<Status> getStatusByRollCallId(int rollCallID) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("rollCallID", rollCallID);
		criterions.add(criterion1);
		ArrayList<Status> statuses = (ArrayList<Status>) baseDAO.queryByCriteria(Status.class, criterions);
		if(statuses.isEmpty())
			return null;
		else {
			return statuses;
		}
	}

}
