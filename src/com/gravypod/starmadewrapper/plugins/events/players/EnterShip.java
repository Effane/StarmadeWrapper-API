package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class EnterShip extends Event {
	
	private final String username, ship;
	
	public EnterShip(String username, String ship) {
	
		this.username = username;
		this.ship = ship;
	}
	
	public String getShip() {
	
		return ship;
	}
	
	public String getUsername() {
	
		return username;
	}
	
}
