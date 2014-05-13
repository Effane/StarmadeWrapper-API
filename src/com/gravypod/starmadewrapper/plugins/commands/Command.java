package com.gravypod.starmadewrapper.plugins.commands;

import com.gravypod.starmadewrapper.Sector;
import com.gravypod.starmadewrapper.Server;
import com.gravypod.starmadewrapper.User;

public abstract class Command {
	
	private Server server;
	
	public abstract void run(String username, User user, String... args);
	
	public boolean canUseCommand(final String user) {
	
		return true;
	}
	
	protected void setServer(final Server server) {
	
		this.server = server;
	}
	
	public Server getServer() {
	
		return server;
	}
	
	protected void pm(final User user, final String... message) {
	
		pm(user.getUsername(), message);
	}
	
	protected void pm(final User user, final String message) {
	
		pm(user.getUsername(), message);
	}
	
	
	protected void tp(final User user, final int x, final int y, final int z) {
	
		tp(user.getUsername(), x, y, z);
	}
	
	protected void tp(final User user, final String x, final String y, final String z) {
	
		tp(user.getUsername(), x, y, z);
	}
	
	protected void tp(final User user, Sector sector) {
		tp(user.getUsername(), sector.getX(), sector.getY(), sector.getZ());
	}
	
	protected void pm(final String username, final String... message) {
		
		getServer().pm(username, message);
	}
	
	protected void pm(final String username, final String message) {
	
		getServer().pm(username, message);
	}
	
	protected void exec(final String command) {
	
		getServer().exec(command);
	}
	
	protected void tp(final String username, final int x, final int y, final int z) {
	
		getServer().tp(username, x, y, z);
	}
	
	protected void tp(final String username, final String x, final String y, final String z) {
	
		getServer().tp(username, x, y, z);
	}
	
	protected void tp(final String username, Sector sector) {
		tp(username, sector.getX(), sector.getY(), sector.getZ());
	}
	
	protected boolean isAdmin(String username) {
		
		return getServer().getAdmins().contains(username);
		
	}
	
	protected boolean isAdmin(User user) {
		return isAdmin(user.getUsername());
	}
	
	protected boolean isDonor(String username) {
		return getServer().getDonors().contains(username);
	}
	
	protected boolean isDonor(User user) {
		return isDonor(user.getUsername());
	}
	
	public String getHelp() {
	
		return null;
	}
	
	public void init() {
	
	}
}
