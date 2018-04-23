package com.almundo.callcenter.model;

/**
 * The Class CallModel.
 */
public class CallModel {
	
	/** The id. */
	private Integer id;
	
	/** The seconds time life. */
//	private long secondsTimeLife;
	
	/** The employee manager. */
	private EmployeeModel employeeManager;
	
	/** The reference. */
	private String reference;

	/**
	 * Instantiates a new call model.
	 *
	 * @param id the id
	 * @param secondsTimeLife the seconds time life
	 * @param reference the reference
	 */
	public CallModel(Integer id, String reference) {
		super();
		this.id = id;
		//this.secondsTimeLife = secondsTimeLife;
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
//	 * Gets the seconds time life.
//	 *
//	 * @return the seconds time life
//	 */
//	public long getSecondsTimeLife() {
//		return secondsTimeLife;
//	}
//
//	/**
//	 * Sets the seconds time life.
//	 *
//	 * @param secondsTimeLife the new seconds time life
//	 */
//	public void setSecondsTimeLife(long secondsTimeLife) {
//		this.secondsTimeLife = secondsTimeLife;
//	}

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
