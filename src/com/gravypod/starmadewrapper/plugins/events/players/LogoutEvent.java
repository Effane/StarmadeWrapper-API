package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class LogoutEvent extends Event {
	
	private final String username;
	
	public LogoutEvent(String username) {
	
		this.username = username;
	}
	
	public String getUsername() {
	
		return username;
	}
}
