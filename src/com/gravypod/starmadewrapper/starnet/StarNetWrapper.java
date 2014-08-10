package com.gravypod.starmadewrapper.starnet;

import java.io.IOException;
import java.net.UnknownHostException;

public class StarNetWrapper {

	StarMadeNetUtil util = new StarMadeNetUtil();
	private final String ip, password;
	private final int port;

	public StarNetWrapper(String ip, int port, String password) {
		this.ip = ip;
		this.port = port;
		this.password = password;
	}

	public StarNetPlayerInfo getPlayerInfo(String username) throws UnknownHostException, IOException {
		return new StarNetPlayerInfo(util.executeAdminCommand(getIp(), getPort(), getPassword(), "/player_info " + username.trim()));
	}

	public String getIp() {
		return ip;
	}

	public String getPassword() {
		return password;
	}

	public int getPort() {
		return port;
	}
}
