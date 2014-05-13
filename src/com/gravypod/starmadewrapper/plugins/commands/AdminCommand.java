package com.gravypod.starmadewrapper.plugins.commands;

import com.gravypod.starmadewrapper.User;

public abstract class AdminCommand extends Command {
	
	@Override
	public boolean canUseCommand(final String user) {
	
		return getServer().getAdmins().contains(user);
	}
	@Override
	public void run(String username, User user, String... args) {

		if (!canUseCommand(username)) {
			pm(username, "You cannot use this command! You are not an admin");
			return;
		}
		runAdmin(username, user, args);
	}
	
	public abstract void runAdmin(final String username, User user, final String ... args);
	
}
