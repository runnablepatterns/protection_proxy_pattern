package com.runnablepatterns.protectionproxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to deny specific element activation 
 */
public class DenyActivateHandler implements InvocationHandler {

	/**
	 * Variable used to store entity to activate or deactivate
	 */
	IActivatable entity;
	
	/**
	 * Overloaded constructor used to receive the entity to work with
	 * @param _entity The entity to set the status
	 */
	public DenyActivateHandler(IActivatable _entity) {
		this.entity = _entity;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		// check that we are trying to access the set status
		if(method.getName().startsWith("set")) {
			// deny the action
			throw new IllegalAccessException();
		}
		return null;
	}

}
