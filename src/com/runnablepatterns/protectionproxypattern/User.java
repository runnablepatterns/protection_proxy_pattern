package com.runnablepatterns.protectionproxypattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to store User details 
 */
public class User implements IActivatable {

	/**
	 * Variables to store user details
	 */
	private String name;
	private Role role;
	private boolean isActive;
	
	/**
	 * Overloaded constructor used to create a user with a specific Role
	 * @param _role The role to set to the user
	 * @param _name The User name
	 */
	public User(Role _role, String _name) {
		this.role = _role;
		setName(_name);
	}
	
	@Override
	public Role getRole() {
		// TODO Auto-generated method stub
		return this.role;
	}

	@Override
	public void setActive(boolean _active) {
		// set current status
		this.isActive = _active;
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
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
}
