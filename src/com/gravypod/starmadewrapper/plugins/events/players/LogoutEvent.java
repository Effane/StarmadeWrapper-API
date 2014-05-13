package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

/**
 * Fired whenever a user logs out of the server. Canceling the event does nothing.
 * @author gravypod
 *
 */
public class LogoutEvent extends Event {
	
	private final String username;
	
	public LogoutEvent(String username) {
	
		this.username = username;
	}
	
	/**
	 * Get the username of the player who has logged out
	 * @return
	 */
	public String getUsername() {
	
		return username;
	}
}
