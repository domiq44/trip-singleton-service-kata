package org.craftedsw.tripservicekata.trip;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.IUserSession;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripServiceTest {

	private static final User GUEST = null;
	private static final User UNUSED_USER = null;
	private User loggedInUser;

	@Test(expected = UserNotLoggedInException.class)
	public void should_throw_an_exception_when_user_is_not_logged_in() throws Exception {
		// Given
		TripService tripService = spy(TripService.getInstance());
		loggedInUser = GUEST;
		IUserSession userSession = () -> loggedInUser;
		doReturn(userSession).when(tripService).getUserSessionInstance();

		// When
		tripService.getTripsByUser(UNUSED_USER);
	}
}
