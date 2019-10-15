package com.runnablepatterns.protectionproxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to allow specific element Activation 
 */
public class AllowActivateHandler implements InvocationHandler {

	/**
	 * Variable used to store entity to activate or deactivate
	 */
	IActivatable entity;
	
	/**
	 * Overloaded constructor used to receive the entity to work with
	 * @param _entity The entity to set the status
	 */
	public AllowActivateHandler(IActivatable _entity) {
		this.entity = _entity;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		//
		try {
			// check that we are trying to access the set status
			if(method.getName().startsWith("set") || method.getName().startsWith("get")) {
				// allow the action
				return method.invoke(entity, args);
			}
		}
		catch(InvocationTargetException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
