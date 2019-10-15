package com.runnablepatterns.protectionproxypattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to store Role details 
 */
public class Role {

	/**
	 * Role variables
	 */
	private int id;
	private String name;
	private RoleEnum enumValue;
	
	/**
	 * Overloaded constructor used to create Role
	 * @param _id The id to set
	 * @param _name The Role name
	 */
	public Role(int _id, String _name, RoleEnum _enumValue) {
		setId(_id);
		setName(_name);
		setEnumValue(_enumValue);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enumValue
	 */
	public RoleEnum getEnumValue() {
		return enumValue;
	}

	/**
	 * @param enumValue the enumValue to set
	 */
	public void setEnumValue(RoleEnum enumValue) {
		this.enumValue = enumValue;
	}
}
