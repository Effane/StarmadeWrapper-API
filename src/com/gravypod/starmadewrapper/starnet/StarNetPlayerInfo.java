package com.gravypod.starmadewrapper.starnet;

import java.util.List;

import com.gravypod.starmadewrapper.LocationUtils;
import com.gravypod.starmadewrapper.Sector;

public class StarNetPlayerInfo {

	private Sector sector;
	private String username, smName, ip, faction;
	private boolean upgraded;
	private int credits;

	private static final char NEW_LINE = '\n';
	private static final String PLAYER_STRING = "Sector: %s " + NEW_LINE
			+ "Username: %s (%s) " + NEW_LINE + "Upgraded: %b " + NEW_LINE
			+ "Credits: %d";

	public StarNetPlayerInfo(List<String> response) {

		for (String s : response) {
			
			if (s.startsWith("[PL] FACTION: ")) {
				faction = s.substring(s.indexOf(':') + 1).trim();
				if (faction.equals("null")) {
					faction = null;
				}
			}
			if (s.startsWith("[PL] SECTOR: ")) {
				sector = LocationUtils.sectorFromString(s);
			}
			if (s.startsWith("[PL] CREDITS: ")) {
				credits = Integer.parseInt(s.substring(s.indexOf(':') + 1).trim());
			}
			if (s.startsWith("[PL] Name: ")) {
				username = s.substring(s.indexOf(':') + 1).trim();
			}

			if (s.startsWith("[PL] IP: ")) {
				ip = s.substring(s.indexOf(':') + 1).trim();
			}
			if (s.startsWith("[PL] SM-NAME: ")) {
				smName = s.substring(s.indexOf(':') + 1).trim();
			}
			if (s.startsWith("[PL] UPGRADED: ")) {
				upgraded = Boolean.valueOf(s.substring(s.indexOf(':') + 1).trim());
			}
		}

	}

	public int getCredits() {
		return credits;
	}

	public String getFaction() {
		return faction;
	}

	public String getIp() {
		return ip;
	}

	public Sector getSector() {
		return sector;
	}

	public String getSmName() {
		return smName;
	}

	public String getUsername() {
		return username;
	}

	public static char getNewLine() {
		return NEW_LINE;
	}

	public boolean isUpgraded() {
		return upgraded;
	}

	@Override
	public String toString() {
		return String.format(PLAYER_STRING, getSector().toString(),
				getUsername(), getSmName(), isUpgraded(), getCredits());
	}

}
