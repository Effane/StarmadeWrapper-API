package com.gravypod.starmadewrapper.starnet;

import java.io.IOException;
import java.net.UnknownHostException;

import com.gravypod.starmadewrapper.Server;
import com.gravypod.starmadewrapper.config.ServerConfig;

public class StarNetWrapper {

	StarMadeNetUtil util = new StarMadeNetUtil();
	private final String ip, password;
	private final int port;

	
	/**
	 * Assumes host is local host, and port is 4242
	 * Gets password from config
	 * @param server
	 */
	public StarNetWrapper(Server server) {
		this("localhost", 4242, server.getServerConfig().get(ServerConfig.SUPER_ADMIN_PASSWORD));
	}
	
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
