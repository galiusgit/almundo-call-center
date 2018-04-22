package com.almundo.callcenter.model;

public class EmployeeModel {
	
	private Integer id;
	
	private EmployeeType type;
	
	private boolean isAvailable;

	private CallModel currentCall;
	
	public EmployeeModel() {
		this.isAvailable = true;
	}

	public EmployeeModel(Integer id, EmployeeType type, boolean isAvailable, CallModel currentCall) {
		super();
		this.id = id;
		this.type = type;
		this.isAvailable = isAvailable;
		this.currentCall = currentCall;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public CallModel getCurrentCall() {
		return currentCall;
	}

	public void setCurrentCall(CallModel currentCall) {
		this.currentCall = currentCall;
	}

}
