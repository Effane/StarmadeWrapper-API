package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class ChatEvent extends Event {
	
	private final String username, message;
	
	public ChatEvent(String username, String message) {
	
		this.username = username;
		this.message = message;
	}
	
	public String getMessage() {
	
		return message;
	}
	
	public String getUsername() {
	
		return username;
	}
}
