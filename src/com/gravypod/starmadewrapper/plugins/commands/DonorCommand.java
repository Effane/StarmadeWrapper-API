package com.gravypod.starmadewrapper.plugins.commands;

import com.gravypod.starmadewrapper.User;

public abstract class DonorCommand extends Command {
	
	@Override
	public boolean canUseCommand(final String user) {
	
		return getServer().isDonor(user) || getServer().isAdmin(user);
	}
	@Override
	public void run(String username, User user, String... args) {

		if (!canUseCommand(username)) {
			pm(username, "You cannot use this command! You are not an donor");
			return;
		}
		runDonor(username, user, args);
	}
	/**
	 * A command that can only be executed by donors (As listed within the donors.txt file)
	 * @param username - Username of the player
	 * @param user - {@link User} object representing the player
	 * @param args - Arguments from the command
	 */
	public abstract void runDonor(final String username, User user, final String ... args);
	
}
