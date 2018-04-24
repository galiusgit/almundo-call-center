package com.almundo.callcenter.model;

/**
 * The Class EmployeeModel.
 * 
 * @version 0.0.1
 */
public class EmployeeModel {
	
	/** The id. */
	private Integer id;
	
	/** The type. */
	private EmployeeType type;
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new employee model.
	 *
	 * @param id the id
	 * @param type the type
	 * @param name the name
	 */
	public EmployeeModel(Integer id, EmployeeType type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public EmployeeType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(EmployeeType type) {
		this.type = type;
	}

}
