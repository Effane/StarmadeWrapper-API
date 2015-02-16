package com.gravypod.starmadewrapper.plugins.events;

/**
 * Event access
 * @author gravypod
 *
 */
public class Events {
	
	/** {@link EventManager} passed on <code>init()</code> */
	private static EventManager em;
	
	/** Lock so only one event can be fired at a time */
	private static Object lock = new Object();
	
	
	/**
	 * Called by event code to fire/broadcast an event to everyone
	 * @param event - {@link Event} that will be sent out
	 * @return - {@link Event} that was sent to {@link EventExecutor}s
	 */
	public static Event fireEvent(Event event) {
	
		synchronized(lock) {
			
			em.fireEvent(event);
			
			return event;
			
		}
		
	}

	public static void init(EventManager eventManager) {
		em = eventManager;
	}
	
}
