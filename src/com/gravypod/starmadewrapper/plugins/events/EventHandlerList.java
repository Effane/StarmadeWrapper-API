package com.gravypod.starmadewrapper.plugins.events;

import java.util.ArrayList;
import java.util.Iterator;

import com.gravypod.starmadewrapper.plugins.Plugin;

/**
 * Tracker of all EventExecutors for each event
 * 
 * Notes:
 * - All events are fired in this order: HIGH, MEDIUM, LOW, MONITOR
 * - MEDIUM is the default {@link EventPriority} - Cancelled on MONITOR will not
 * be saved, NEVER CHANGE ON MONITOR! It is for getting the final state of the
 * event
 * 
 * @author gravypod
 * 
 */
public class EventHandlerList {
	
	public final ArrayList<EventExecutor> LOW = new ArrayList<EventExecutor>(); // Run
																				// on
																				// different
																				// priorities
	public final ArrayList<EventExecutor> MEDIUM = new ArrayList<EventExecutor>();
	public final ArrayList<EventExecutor> HIGH = new ArrayList<EventExecutor>();
	public final ArrayList<EventExecutor> MONITOR = new ArrayList<EventExecutor>();
	
	/**
	 * Add a listener into the {@link EventHandlerList}
	 * 
	 * @param p
	 *            - {@link Plugin} that owns this even
	 * @param ee
	 *            - {@link EventExecutor} for this event
	 * @param ep
	 *            - {@link EventPriority} to listen on
	 */
	public void addListener(Plugin p, EventExecutor ee, EventPriority ep) {
	
		ee.setPlugin(p);
		
		switch (ep) {
		
			case LOW:
				LOW.add(ee);
				break;
			case MEDIUM:
				MEDIUM.add(ee);
				break;
			case HIGH:
				HIGH.add(ee);
				break;
			case MONITOR:
				MONITOR.add(ee);
				break;
			default:
				throw new IllegalArgumentException("That was not a real event priority!");
				
		}
		
	}
	
	/**
	 * Fire an {@link Event} to all {@link EventExecutor} that this
	 * {@link EventHandlerList} knows about
	 * 
	 * @param event
	 *            - {@link Event} instance fo pass
	 */
	public void fireEvent(Event event) {
	
		for (EventExecutor ee : HIGH) {
			ee.execute(event);
		}
		for (EventExecutor ee : MEDIUM) {
			ee.execute(event);
		}
		
		for (EventExecutor ee : LOW) {
			ee.execute(event);
		}
		boolean cancelledState = event.isCancelled(); // TODO: Upgrade this for
														// more protection
		
		for (EventExecutor ee : MONITOR) {
			ee.execute(event);
		}
		event.setCancelled(cancelledState);
		
	}
	
	/**
	 * Check to see if a {@link Plugin} has an {@link EventExecutor} registered
	 * with this {@link EventHandlerList}
	 * 
	 * @param p
	 *            - {@link Plugin} to register with
	 * @return - {@link Boolean} <code>true</code> if we contain a listener for
	 *         it. <code>false</code> otherwise
	 */
	public boolean isRgistered(Plugin p) {
	
		for (EventExecutor ee : HIGH) {
			if (p.equals(ee.getPlugin())) {
				return true;
			}
		}
		for (EventExecutor ee : MEDIUM) {
			if (p.equals(ee.getPlugin())) {
				return true;
			}
		}
		
		for (EventExecutor ee : LOW) {
			
			if (p.equals(ee.getPlugin())) {
				return true;
			}
		}
		for (EventExecutor ee : MONITOR) {
			if (p.equals(ee.getPlugin())) {
				return true;
			}
		}
		return false;
	}
	
	public void unregisterEvents(Plugin p) {
	
		for (Iterator<EventExecutor> iterator = LOW.iterator(); iterator.hasNext();) {
			EventExecutor ee = iterator.next();
			if (ee.getPlugin().equals(p)) {
				iterator.remove();
			}
		}
		for (Iterator<EventExecutor> iterator = MEDIUM.iterator(); iterator.hasNext();) {
			EventExecutor ee = iterator.next();
			if (ee.getPlugin().equals(p)) {
				iterator.remove();
			}
		}
		for (Iterator<EventExecutor> iterator = HIGH.iterator(); iterator.hasNext();) {
			EventExecutor ee = iterator.next();
			if (ee.getPlugin().equals(p)) {
				iterator.remove();
			}
		}
		for (Iterator<EventExecutor> iterator = MONITOR.iterator(); iterator.hasNext();) {
			EventExecutor ee = iterator.next();
			if (ee.getPlugin().equals(p)) {
				iterator.remove();
			}
		}
	}
	
}
