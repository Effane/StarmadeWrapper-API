package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

/**
 * Fired whenever a chat message is made. Canceling this will prevent it being executed as a command.
 * @author gravypod
 *
 */
public class ChatEvent extends Event {
	
	private final String username, message;
	
	public ChatEvent(String username, String message) {
	
		this.username = username;
		this.message = message;
	}
	
	/**
	 * Get message contents
	 * @return
	 */
	public String getMessage() {
	
		return message;
	}
	
	/**
	 * Get sender's username
	 * @return
	 */
	public String getUsername() {
	
		return username;
	}
}
