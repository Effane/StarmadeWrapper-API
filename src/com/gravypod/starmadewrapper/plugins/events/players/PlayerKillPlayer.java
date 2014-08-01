package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class PlayerKillPlayer extends Event {
	
	private final String username, killer;
	
	public PlayerKillPlayer(String username, String killer) {
	
		this.username = username;
		this.killer = killer;
		
	}
	
	public String getKiller() {
	
		return killer;
	}
	
	public String getUsername() {
	
		return username;
	}
	
}
