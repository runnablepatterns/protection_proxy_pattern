package com.runnablepatterns.protectionproxypattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface used to define objects as Active. 
 */
public interface IActivatable {
	
	/**
	 * Method to get current Role
	 * @return Actual user Role
	 */
	public Role getRole();
	
	/**
	 * Method to set user status
	 * @param _active The status to set
	 */
	public void setActive(boolean _active);

}