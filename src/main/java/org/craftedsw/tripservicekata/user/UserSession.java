package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSession implements IUserSession {

	private static final IUserSession userSession = new UserSession();

	private UserSession() {
	}

	public static synchronized IUserSession getInstance() {
		return userSession;
	}

	@Override
	public User getLoggedUser() {
		throw new CollaboratorCallException("UserSession.getLoggedUser() should not be called in an unit test");
	}
}
