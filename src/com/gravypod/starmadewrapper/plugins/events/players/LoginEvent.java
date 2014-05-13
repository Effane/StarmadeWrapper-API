package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class LoginEvent extends Event {
	
	private final String username;
	
	public LoginEvent(String username) {
	
		this.username = username;
	}
	
	public String getUsername() {
	
		return username;
	}
}
