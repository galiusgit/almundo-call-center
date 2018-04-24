package com.almundo.callcenter.model;

/**
 * The Class CallModel.
 * 
 * @version 0.0.1
 */
public class CallModel {
	
	/** The id. */
	private Integer id;
	
	/** The employee manager. */
	private EmployeeModel employeeManager;
	
	/** The reference. */
	private String reference;

	/**
	 * Instantiates a new call model.
	 *
	 * @param id the id
	 * @param reference the reference
	 */
	public CallModel(Integer id, String reference) {
		super();
		this.id = id;
		this.reference = reference;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the employee manager.
	 *
	 * @return the employee manager
	 */
	public EmployeeModel getEmployeeManager() {
		return employeeManager;
	}

	/**
	 * Sets the employee manager.
	 *
	 * @param employeeManager the new employee manager
	 */
	public void setEmployeeManager(EmployeeModel employeeManager) {
		this.employeeManager = employeeManager;
	}

	/**
	 * Gets the reference.
	 *
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Sets the reference.
	 *
	 * @param reference the new reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	

}
