package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.plugins.events.Event;

public class WisperEvent extends Event {

	final String from, to, message;

	public WisperEvent(String from, String to, String message) {
		this.to = to;
		this.from = from;
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public String getMessage() {
		return message;
	}

	public String getTo() {
		return to;
	}

}
