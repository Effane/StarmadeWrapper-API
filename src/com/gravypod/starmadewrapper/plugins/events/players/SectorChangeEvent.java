package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.Sector;
import com.gravypod.starmadewrapper.plugins.events.Event;

/**
 * Fired when a user changes sectors. Cancelling the event teleports the user back to the previous sector.
 * @author Sean Callahan
 *
 */
public class SectorChangeEvent extends Event {

    private final String username;
    private final Sector from, to;

    public SectorChangeEvent(String username, Sector from, Sector to) {
        this.username = username;
        this.from = from;
        this.to = to;
    }

    /**
     * Gets the username of the user involved in the event
     *
     * @return username of user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the sector that the user exited
     *
     * @return sector exited
     */
    public Sector getFrom() {
        return from;
    }

    /**
     * Gets the sector that the user entered
     *
     * @return sector entered
     */
    public Sector getTo() {
        return to;
    }
}
