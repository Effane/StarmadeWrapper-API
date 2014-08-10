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
	private static final String PLAYER_STRING = "Sector: %s " + NEW_LINE + "Username: %s (%s) " + NEW_LINE + "Upgraded: %b " + NEW_LINE + "Credits: %d";

	public StarNetPlayerInfo(List<String> response) {

		for (String s : response) {
			
			if (!s.startsWith("[PL]")) {
				continue;
			}
			
			String type = s.substring(s.indexOf(' ') + 1, s.indexOf(':'));
			String payload = s.substring(s.indexOf(':') + 1).trim();
			
			switch (type) { // TODO: Login messages
				case "FACTION":
					if (payload.equals("null")) {
						faction = null;
					}
					break;
				case "SECTOR":
					sector = LocationUtils.sectorFromString(s);
					break;
				case "CREDITS":
					credits = Integer.parseInt(payload);
					break;
				case "IP":
					ip = payload;
					break;
				case "Name":
					username = payload;
					break;
				case "SM-NAME":
					smName = payload;
					break;
				case "UPGRADED":
					upgraded = Boolean.valueOf(payload);
					break;
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

	public boolean isUpgraded() {
		return upgraded;
	}

	@Override
	public String toString() {
		return String.format(PLAYER_STRING, getSector().toString(), getUsername(), getSmName(), isUpgraded(), getCredits());
	}

}
