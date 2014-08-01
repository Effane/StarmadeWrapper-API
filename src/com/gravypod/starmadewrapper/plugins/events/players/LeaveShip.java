package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class LeaveShip extends Event {
	
	private final String username;
	
	public LeaveShip(String username) {
	
		this.username = username;
	}
	
	public String getUsername() {
	
		return username;
	}
}
