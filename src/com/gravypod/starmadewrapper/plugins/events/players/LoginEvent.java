package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

/**
 * Fired whenever a user logs into the server. Canceling this will kick the user from the server
 * @author gravypod
 *
 */
public class LoginEvent extends Event {
	
	private final String username;
	
	public LoginEvent(String username) {
	
		this.username = username;
	}
	
	/**
	 * Get the username of the player who has logged in.
	 * @return
	 */
	public String getUsername() {
	
		return username;
	}
}
