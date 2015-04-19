package com.gravypod.starmadewrapper.starnet;

import java.util.Date;

public class ServerInfo {
	
	private final byte infoVersion;
	private final float version;
	private final String name;
	private final String desc;
	private final long startTime;
	private final int playerCount;
	private final int maxPlayers;
	private final long ping;
	private final String host;
	private final int port;
	
	
	public ServerInfo(String host, int port, Object[] returnValues, long roundTripTime) {
	
		this.host = host;
		this.port = port;
		this.infoVersion = ((byte) returnValues[0]);
		this.version = ((float) returnValues[1]);
		this.name = ((String) returnValues[2]);
		this.desc = ((String) returnValues[3]);
		this.startTime = ((long) returnValues[4]);
		this.playerCount = ((int) returnValues[5]);
		this.maxPlayers = ((int) returnValues[6]);
		this.ping = roundTripTime;
	}
	
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		sb.append("SERVER INFO FOR " + getHost() + ":" + getPort() + "(INFO VERSION: " + getInfoVersion() + ")\n");
		sb.append("Version: " + getVersion() + "\n");
		sb.append("Name: " + getName() + "\n");
		sb.append("Description: " + getDesc() + "\n");
		sb.append("Started: " + new Date(getStartTime()) + "\n");
		sb.append("Players: " + getPlayerCount() + "/" + getMaxPlayers() + "\n");
		sb.append("Ping: " + getPing() + "\n");
		
		return sb.toString();
	}
	
	public Byte getInfoVersion() {
	
		return this.infoVersion;
	}
	
	public Float getVersion() {
	
		return this.version;
	}
	
	public String getName() {
	
		return this.name;
	}
	
	public String getDesc() {
	
		return this.desc;
	}
	
	public Long getStartTime() {
	
		return this.startTime;
	}
	
	public Integer getPlayerCount() {
	
		return this.playerCount;
	}
	
	public Integer getMaxPlayers() {
	
		return this.maxPlayers;
	}
	
	public long getPing() {
	
		return this.ping;
	}
	
	public String getHost() {
	
		return this.host;
	}
	
	public int getPort() {
	
		return this.port;
	}
}