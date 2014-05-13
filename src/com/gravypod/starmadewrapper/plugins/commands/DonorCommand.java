package com.gravypod.starmadewrapper.plugins.commands;

import com.gravypod.starmadewrapper.User;

public abstract class DonorCommand extends Command {
	
	@Override
	public boolean canUseCommand(final String user) {
	
		return getServer().getDonors().contains(user) || getServer().getAdmins().contains(user);
	}
	@Override
	public void run(String username, User user, String... args) {

		if (!canUseCommand(username)) {
			pm(username, "You cannot use this command! You are not an donor");
			return;
		}
		runDonor(username, user, args);
	}
	
	public abstract void runDonor(final String username, User user, final String ... args);
	
}
