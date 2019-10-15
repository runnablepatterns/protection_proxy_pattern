package com.runnablepatterns.protectionproxydemo;

import java.lang.reflect.Proxy;

import com.runnablepatterns.protectionproxypattern.AllowActivateHandler;
import com.runnablepatterns.protectionproxypattern.DenyActivateHandler;
import com.runnablepatterns.protectionproxypattern.IActivatable;
import com.runnablepatterns.protectionproxypattern.Role;
import com.runnablepatterns.protectionproxypattern.RoleEnum;
import com.runnablepatterns.protectionproxypattern.User;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to demonstrate Protection Proxy Pattern
 */
public class ProtectionProxyDemo {

	public static void main(String[] args) {

		// create 2 roles
		Role adminRole = new Role(0, "Admin", RoleEnum.ADMIN);
		Role clientRole = new Role(1, "Client", RoleEnum.CLIENT);
		
		// create 2 users
		IActivatable userAdmin = new User(adminRole, "Carlos M");
		IActivatable clientUser = new User(clientRole, "Paul W");
		
		// create proxy to client user using an admin role
		IActivatable adminProxy = getProxy(clientUser, userAdmin.getRole().getEnumValue());
		// create proxy to client user using a client role
		IActivatable clientProxy = getProxy(clientUser, clientUser.getRole().getEnumValue());
		
		// display current status
		System.out.println(String.format("User: %s - status: %s", ((User)clientUser).getName(),
				((User)clientUser).isActive()));
		System.out.println();
				
		// display message
		System.out.println(String.format("User: %s, with Role: %s - is trying to change status of %s to: true", 
				((User)userAdmin).getName(), ((User)userAdmin).getRole().getName(),
				((User)clientUser).getName()));
		
		// change status to true
		adminProxy.setActive(true);
		
		System.out.println("User updated!");
		System.out.println(String.format("User: %s - status: %s", ((User)clientUser).getName(),
				((User)clientUser).isActive()));
		System.out.println();
		
		System.out.println(String.format("User: %s, with Role: %s - is trying to change status of %s to: false", 
				((User)clientUser).getName(), ((User)clientUser).getRole().getName(),
				((User)clientUser).getName()));
		
		try {
			// change status to true
			clientProxy.setActive(false);
		}
		catch(Exception ex) {
			System.out.println(String.format("The user: %s, can't change the status. Permission denied", 
					((User)clientUser).getName()));
			System.out.println();
		}
		
		System.out.println(String.format("User: %s - status: %s", ((User)clientUser).getName(),
				((User)clientUser).isActive()));
	}
	
	/**
	 * Method used to create the proxy instance
	 * @param _entity The entity to use to generate the proxy
	 * @return The proxy to use
	 */
	public static IActivatable getProxy(IActivatable _entity, RoleEnum _role) {
		
		// check specific enum value
		switch (_role) {
		case ADMIN:
			// when it is admin role then select the Allow handler
			return (IActivatable)Proxy.newProxyInstance(_entity.getClass().getClassLoader(), 
					_entity.getClass().getInterfaces(), new AllowActivateHandler(_entity));
		case CLIENT:
			// when it is client role, then select the Deny handler
			return (IActivatable)Proxy.newProxyInstance(_entity.getClass().getClassLoader(), 
					_entity.getClass().getInterfaces(), new DenyActivateHandler(_entity));
		}
		
		return null;
	}

}
