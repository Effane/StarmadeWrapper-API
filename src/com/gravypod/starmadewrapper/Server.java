package com.gravypod.starmadewrapper;

import java.util.List;

import com.gravypod.starmadewrapper.plugins.commands.CommandManager;

public interface Server {
	
	public User getUser(String username);
	
	public void exec(String command);
	
	public void tp(String username, int x, int y, int z);
	
	public void tp(String username, String x, String y, String z);
	
	public void pm(String user, String... message);
	
	public void give(final String user, final int item, final int amount);
	
	public void pm(String username, String message);
	
	public CommandManager getCommandManager();
	
	public List<String> getAdmins();
	
	public List<String> getDonors();
	
}
