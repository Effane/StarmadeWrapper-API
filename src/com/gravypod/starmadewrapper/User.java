package com.gravypod.starmadewrapper;

import java.util.List;

/**
 * A player that has connected to the server. Online or offline.
 * @author gravypod
 *
 */
public interface User {
	/**
	 * Get the username of this player
	 * @return
	 */
	public String getUsername();
	
	/**
	 * Get the sector this player is in.
	 * @return
	 */
	public Sector getSector();
	
	/**
	 * The factions this user is in.
	 * @return
	 */
	public List<String> getFactions();
	
	/**
	 * Get the faction owned by this user.
	 * @return
	 */
	public String getFactionOwned();
	
	
}
