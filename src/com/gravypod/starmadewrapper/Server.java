package com.gravypod.starmadewrapper;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

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
     * Ban the user with a given name
     * @param user
     */
    public void ban(String user);
	
	/**
	 * Get the {@link CommandManager} object
	 * @return
	 */
	public CommandManager getCommandManager();
	
	/**
	 * Get the items within the "admins.txt" file.
	 * @return
	 */
	public boolean isAdmin(String username);
	
	/**
	 * Get the items within the "donors.txt" file.
	 * @return
	 */
	public boolean isDonor(String username);

    /**
     * Get the maximum amount of clients that can connect to the server.
     * @return
     */
    public int getMaxClients();

    /**
     * Get the ship thrust speed limit.
     * @return
     */
    public int getThrustSpeedLimit();

    /**
     * Get the amount of money a user starts with.
     * @return
     */
    public int getStartingCredits();

    /**
     * Get the duration of each day for the universe in milliseconds.
     * @return
     */
    public long getUniverseDay();

    /**
     * Does the server have a whitelist.
     * @return
     */
    public boolean hasWhitelist();

    /**
     * Does the server have enemy spawning enabled.
     * @return
     */
    public boolean hasEnemySpawning();

    /**
     * Does the server use StarMade auth for players
     * @return true if the server has it enabled
     */
    public boolean useStarMadeAuth();

    /**
     * Sets the whitelist on or off
     * @param whitelist - true if whitelist is on, otherwise false
     */
    public void setWhitelist(boolean whitelist);

    /**
     * Add a player to the server's whitelist
     * @param username of the player to whitelist
     */
    public void whitelist(String username);
	
	/**
	 * Stop the server and wrapper.
	 */
	public void stopServer();

	/**
	 * Restart the server
	 * @param time - Time to append to the <code>/shutdown</code> command
	 */
	public void restart(int time);
	
	/**
	 * Attempt to start the server, does nothing if it is already running.
	 */
	public void startServer();
	
	/**
	 * Check if the server is running
	 * @return - True if SM is started
	 */
	public boolean isRunning();
	
	/**
	 * Get the logger instance for the server.
	 * @return
	 */
	public Logger getLogger();
	
	/**
	 * Get a shared {@link ExecutorService} that can be used for any task. 
	 * Everything in the pool is stopped when the starmade server stops.
	 * This is a safe way to make sure you are not leaving behind threads.
	 * @return
	 */
	public ExecutorService getThreadPool();
	
	/**
	 * Get a shared {@link ScheduledExecutorService} that can be used for any task. 
	 * Everything in the pool is stopped when the starmade server stops.
	 * This is a safe way to make sure you are not leaving behind threads.
	 * @return
	 */
	public ScheduledExecutorService getSchedulerPool();

	/**
	 * Get the directory starmade is in
	 * @return
	 */
	public File getStarmadeDirectory();
	
}
