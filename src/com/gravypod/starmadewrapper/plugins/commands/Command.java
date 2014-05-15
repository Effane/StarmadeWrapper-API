package com.gravypod.starmadewrapper.plugins.commands;

import com.gravypod.starmadewrapper.Sector;
import com.gravypod.starmadewrapper.Server;
import com.gravypod.starmadewrapper.User;

public abstract class Command {
	
	private Server server;
	
	/**
	 * Execute the functionality of this command
	 * @param username - Username of the player who ran this command
	 * @param user - {@link User} object representing the sender of this command
	 * @param args - Arguments from this command
	 */
	public abstract void run(String username, User user, String... args);
	
	/**
	 * Can a given user run this command?
	 * @param user
	 * @return
	 */
	public boolean canUseCommand(final String user) {
	
		return true;
	}
	
	/**
	 * Set the server this command is for
	 * @param server
	 */
	protected void setServer(final Server server) {
	
		this.server = server;
	}
	
	/**
	 * Get the server this command is for
	 * @return
	 */
	public Server getServer() {
	
		return server;
	}
	
	/**
	 * Give a user credits
	 * @param user - User to get the credits
	 * @param ammount - Amount of the credits
	 */
	protected void giveCredits(User user, int ammount) {
		giveCredits(user.getUsername(), ammount);
	}
	
	/**
	 * Give a user credits
	 * @param username - User to get the credits
	 * @param ammount - Amount of the credits
	 */
	protected void giveCredits(String username, int ammount) {
		exec("/give_credits " + username + " " + ammount);
	}
	
	
	/**
	 * Give a user items
	 * @param user - User to get the items
	 * @param id - ID of the item
	 * @param ammount - Amount of the items
	 */
	protected void give(User user, int id, int ammount) {
		give(user.getUsername(), id, ammount);
	}
	
	/**
	 * Give a user items
	 * @param username - User to get the items
	 * @param id - ID of the item
	 * @param ammount - Amount of the items
	 */
	protected void give(String username, int id, int ammount) {
		exec("/giveid " + username + " " + id + " " + ammount);
	}
	
	/**
	 * Send a user a set of pms
	 * @param user 
	 * @param message
	 */
	protected void pm(final User user, final String... message) {
	
		pm(user.getUsername(), message);
	}
	
	/**
	 * Send a user a pm
	 * @param user
	 * @param message
	 */
	protected void pm(final User user, final String message) {
	
		pm(user.getUsername(), message);
	}
	
	/**
	 * Tp a user to the coords
	 * @param user
	 * @param x
	 * @param y
	 * @param z
	 */
	protected void tp(final User user, final int x, final int y, final int z) {
	
		tp(user.getUsername(), x, y, z);
	}
	
	/**
	 * Tp a user to the coords
	 * @param user
	 * @param x
	 * @param y
	 * @param z
	 */
	protected void tp(final User user, final String x, final String y, final String z) {
	
		tp(user.getUsername(), x, y, z);
	}
	
	/**
	 * Tp a user to the {@link Sector}
	 * @param user
	 * @param sector
	 */
	protected void tp(final User user, Sector sector) {
		tp(user.getUsername(), sector.getX(), sector.getY(), sector.getZ());
	}
	
	/**
	 * Send a user a set of pms
	 * @param username
	 * @param message
	 */
	protected void pm(final String username, final String... message) {
		
		getServer().pm(username, message);
	}
	
	/**
	 * Send a user a pm
	 * @param username
	 * @param message
	 */
	protected void pm(final String username, final String message) {
	
		getServer().pm(username, message);
	}
	
	/**
	 * Execute a command on the server
	 * @param command
	 */
	protected void exec(final String command) {
	
		getServer().exec(command);
	}
	
	/**
	 * Tp a user to the coords
	 * @param username
	 * @param x
	 * @param y
	 * @param z
	 */
	protected void tp(final String username, final int x, final int y, final int z) {
	
		getServer().tp(username, x, y, z);
	}
	
	/**
	 * Tp a user to the coords
	 * @param username
	 * @param x
	 * @param y
	 * @param z
	 */
	protected void tp(final String username, final String x, final String y, final String z) {
	
		getServer().tp(username, x, y, z);
	}
	
	/**
	 * Tp a user a sector
	 * @param username
	 * @param sector 
	 */
	protected void tp(final String username, Sector sector) {
		tp(username, sector.getX(), sector.getY(), sector.getZ());
	}

    /**
     * Ban a user from the server
     * @param user - username of player
     */
    protected void ban(final String user) {

        ban(user);
    }

	/**
	 * Check to see if the user is inside the admin.txt
	 * @param username
	 * @return
	 */
	protected boolean isAdmin(String username) {
		
		return getServer().getAdmins().contains(username);
		
	}
	
	/**
	 * Check to see if the user is inside the admin.txt
	 * @param user
	 * @return
	 */
	protected boolean isAdmin(User user) {
		return isAdmin(user.getUsername());
	}
	
	/**
	 * Check to see if the user is inside the donor.txt
	 * @param username
	 * @return
	 */
	protected boolean isDonor(String username) {
		return getServer().getDonors().contains(username);
	}

	/**
	 * Check to see if the user is inside the donor.txt
	 * @param user
	 * @return
	 */
	protected boolean isDonor(User user) {
		return isDonor(user.getUsername());
	}
	
	/**
	 * Get help info on how to use this command.
	 * @return
	 */
	public String getHelp() {
	
		return null;
	}
	
	/**
	 * Called in initialization after the server has been set
	 */
	public void init() {
	
	}
}
