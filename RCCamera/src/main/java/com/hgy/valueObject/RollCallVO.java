package com.hgy.valueObject;

import com.hgy.model.RollCall;

public class RollCallVO extends RollCall{
	private String cClazzName;
	public RollCallVO(RollCall rollCall) {
		this.setClazzID(rollCall.getClazzID());
		this.setDate(rollCall.getDate());
		this.setId(rollCall.getId());
		this.setOnRollCall(rollCall.isOnRollCall());
		this.setStatuses(rollCall.getStatuses());
	}
	public String getCClazzName() {
		return cClazzName;
	}
	public void setCClazzName(String clazzName) {
		this.cClazzName = clazzName;
	}

}
