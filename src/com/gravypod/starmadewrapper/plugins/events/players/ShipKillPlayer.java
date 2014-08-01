package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class ShipKillPlayer extends Event {
	
	private final String shipName, username;
	
	public ShipKillPlayer(String shipName, String username) {
	
		this.shipName = shipName;
		this.username = username;
	}
	
	public String getShipName() {
	
		return shipName;
	}
	
	public String getUsername() {
	
		return username;
	}
	
}
