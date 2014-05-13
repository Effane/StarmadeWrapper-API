package com.gravypod.starmadewrapper;

import java.util.List;

import com.gravypod.starmadewrapper.plugins.commands.CommandManager;

/**
 * Object to manipulate the server
 * @author gravypod
 *
 */
public interface Server {
	
	/**
	 * Get a user object by name
	 * @param username
	 * @return the {@link User} object or null if none can be found
	 */
	public User getUser(String username);
	
	/**
	 * Run a console command.
	 * @param command
	 */
	public void exec(String command);
	
	/**
	 * Tp a user
	 * @param username - Username to TP with the command
	 * @param x
	 * @param y
	 * @param z
	 */
	public void tp(String username, int x, int y, int z);
	
	/**
	 * Tp a user 
	 * @param username - Username to TP with the command
	 * @param x
	 * @param y
	 * @param z
	 */
	public void tp(String username, String x, String y, String z);
	
	/**
	 * Mass pm a user
	 * @param username - user to recive the pms
	 * @param message
	 */
	public void pm(String username, String... message);
	
	/**
	 * Give a user an item
	 * @param user
	 * @param item
	 * @param amount
	 */
	public void give(final String user, final int item, final int amount);
	
	/**
	 * Send a user a single pm
	 * @param username
	 * @param message
	 */
	public void pm(String username, String message);
	
	/**
	 * Get the {@link CommandManager} object
	 * @return
	 */
	public CommandManager getCommandManager();
	
	
	/**
	 * Get the items within the "admins.txt" file.
	 * @return
	 */
	public List<String> getAdmins();
	
	/**
	 * Get the items within the "donors.txt" file.
	 * @return
	 */
	public List<String> getDonors();
	
}
