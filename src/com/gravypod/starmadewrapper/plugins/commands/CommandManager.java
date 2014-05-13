package com.gravypod.starmadewrapper.plugins.commands;

import java.util.Collection;
import java.util.HashMap;

import com.gravypod.starmadewrapper.Server;

public class CommandManager {
	
	private final HashMap<String, Command> commands = new HashMap<String, Command>();
	private final Server server;
	
	public CommandManager(Server server) {
	
		this.server = server;
	}
	
	public void execute(String user, String command, String[] args) {
	
		commands.get(command).run(user, server.getUser(user), args);
	}
	
	public void registerCommand(String cmd, Command command) {
		command.setServer(server);
		commands.put(cmd, command);
	}
	
	public Command unregisterCommand(String cmd) {
		Command c = commands.remove(cmd);
		return c;
	}

	public boolean isRegistered(String cmd) {
		return commands.containsKey(cmd);
	}

	public Collection<Command> getCommands() {
		return commands.values();
	}
}
