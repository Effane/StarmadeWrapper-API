package com.gravypod.starmadewrapper.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import com.gravypod.starmadewrapper.Server;

public class ServerConfig {

	public static final String WORLD = "WORLD";
	public static final String PROTECT_STARTING_SECTOR = "PROTECT_STARTING_SECTOR";
	public static final String ENABLE_SIMULATION = "ENABLE_SIMULATION";
	public static final String CONCURRENT_SIMULATION = "CONCURRENT_SIMULATION";
	public static final String ENEMY_SPAWNING = "ENEMY_SPAWNING";
	public static final String SECTOR_SIZE = "SECTOR_SIZE";
	public static final String BLUEPRINT_DEFAULT_PRIVATE = "BLUEPRINT_DEFAULT_PRIVATE";
	public static final String FLOATING_ITEM_LIFETIME_SECS = "FLOATING_ITEM_LIFETIME_SECS";
	public static final String SIMULATION_SPAWN_DELAY = "SIMULATION_SPAWN_DELAY";
	public static final String SIMULATION_TRADING_FILLS_SHOPS = "SIMULATION_TRADING_FILLS_SHOPS";
	public static final String SECTOR_INACTIVE_TIMEOUT = "SECTOR_INACTIVE_TIMEOUT";
	public static final String SECTOR_INACTIVE_CLEANUP_TIMEOUT = "SECTOR_INACTIVE_CLEANUP_TIMEOUT";
	public static final String USE_STARMADE_AUTHENTICATION = "USE_STARMADE_AUTHENTICATION";
	public static final String REQUIRE_STARMADE_AUTHENTICATION = "REQUIRE_STARMADE_AUTHENTICATION";
	public static final String PROTECTED_NAMES_BY_ACCOUNT = "PROTECTED_NAMES_BY_ACCOUNT";
	public static final String STARTING_CREDITS = "STARTING_CREDITS";
	public static final String DEFAULT_BLUEPRINT_ENEMY_USE = "DEFAULT_BLUEPRINT_ENEMY_USE";
	public static final String LOCK_FACTION_SHIPS = "LOCK_FACTION_SHIPS";
	public static final String DEBUG_FSM_STATE = "DEBUG_FSM_STATE";
	public static final String PHYSICS_SHAPE_CASTING_TUNNELING_PREVENTION = "PHYSICS_SHAPE_CASTING_TUNNELING_PREVENTION";
	public static final String CATALOG_SLOTS_PER_PLAYER = "CATALOG_SLOTS_PER_PLAYER";
	public static final String UNIVERSE_DAY_IN_MS = "UNIVERSE_DAY_IN_MS";
	public static final String FORCE_DISK_WRITE_COMPLETION = "FORCE_DISK_WRITE_COMPLETION";
	public static final String ASTEROIDS_ENABLE_DYNAMIC_PHYSICS = "ASTEROIDS_ENABLE_DYNAMIC_PHYSICS";
	public static final String ENABLE_BREAK_OFF = "ENABLE_BREAK_OFF";
	public static final String COLLISION_DAMAGE = "COLLISION_DAMAGE";
	public static final String COLLISION_DAMAGE_THRESHOLD = "COLLISION_DAMAGE_THRESHOLD";
	public static final String SKIN_ALLOW_UPLOAD = "SKIN_ALLOW_UPLOAD";
	public static final String CATALOG_NAME_COLLISION_HANDLING = "CATALOG_NAME_COLLISION_HANDLING";
	public static final String SECTOR_AUTOSAVE_SEC = "SECTOR_AUTOSAVE_SEC";
	public static final String PHYSICS_SLOWDOWN_THRESHOLD = "PHYSICS_SLOWDOWN_THRESHOLD";
	public static final String THRUST_SPEED_LIMIT = "THRUST_SPEED_LIMIT";
	public static final String MAX_CLIENTS = "MAX_CLIENTS";
	public static final String SUPER_ADMIN_PASSWORD_USE = "SUPER_ADMIN_PASSWORD_USE";
	public static final String SUPER_ADMIN_PASSWORD = "SUPER_ADMIN_PASSWORD";
	public static final String SERVER_LISTEN_IP = "SERVER_LISTEN_IP";
	public static final String SOCKET_BUFFER_SIZE = "SOCKET_BUFFER_SIZE";
	public static final String PHYSICS_LINEAR_DAMPING = "PHYSICS_LINEAR_DAMPING";
	public static final String PHYSICS_ROTATIONAL_DAMPING = "PHYSICS_ROTATIONAL_DAMPING";
	public static final String AI_DESTRUCTION_LOOT_COUNT_MULTIPLIER = "AI_DESTRUCTION_LOOT_COUNT_MULTIPLIER";
	public static final String AI_DESTRUCTION_LOOT_STACK_MULTIPLIER = "AI_DESTRUCTION_LOOT_STACK_MULTIPLIER";
	public static final String CHEST_LOOT_COUNT_MULTIPLIER = "CHEST_LOOT_COUNT_MULTIPLIER";
	public static final String CHEST_LOOT_STACK_MULTIPLIER = "CHEST_LOOT_STACK_MULTIPLIER";
	public static final String USE_WHITELIST = "USE_WHITELIST";
	public static final String FILTER_CONNECTION_MESSAGES = "FILTER_CONNECTION_MESSAGES";
	public static final String USE_UDP = "USE_UDP";
	public static final String AUTO_KICK_MODIFIED_BLUEPRINT_USE = "AUTO_KICK_MODIFIED_BLUEPRINT_USE";
	public static final String AUTO_BAN_ID_MODIFIED_BLUEPRINT_USE = "AUTO_BAN_ID_MODIFIED_BLUEPRINT_USE";
	public static final String AUTO_BAN_IP_MODIFIED_BLUEPRINT_USE = "AUTO_BAN_IP_MODIFIED_BLUEPRINT_USE";
	public static final String REMOVE_MODIFIED_BLUEPRINTS = "REMOVE_MODIFIED_BLUEPRINTS";
	public static final String DEBUG_SEGMENT_WRITING = "DEBUG_SEGMENT_WRITING";
	public static final String TCP_NODELAY = "TCP_NODELAY";
	public static final String PING_FLUSH = "PING_FLUSH";
	public static final String RECIPE_BLOCK_COST = "RECIPE_BLOCK_COST";
	public static final String SHOP_SPAWNING_PROBABILITY = "SHOP_SPAWNING_PROBABILITY";
	public static final String RECIPE_REFUND_MULT = "RECIPE_REFUND_MULT";
	public static final String RECIPE_LEVEL_AMOUNT = "RECIPE_LEVEL_AMOUNT";
	public static final String DEFAULT_SPAWN_SECTOR_X = "DEFAULT_SPAWN_SECTOR_X";
	public static final String DEFAULT_SPAWN_SECTOR_Y = "DEFAULT_SPAWN_SECTOR_Y";
	public static final String DEFAULT_SPAWN_SECTOR_Z = "DEFAULT_SPAWN_SECTOR_Z";
	public static final String MODIFIED_BLUEPRINT_TOLERANCE = "MODIFIED_BLUEPRINT_TOLERANCE";
	public static final String TURNING_DIMENSION_SCALE = "TURNING_DIMENSION_SCALE";
	public static final String DEFAULT_SPAWN_LOCALPOINT_X_1 = "DEFAULT_SPAWN_LOCALPOINT_X_1";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Y_1 = "DEFAULT_SPAWN_LOCALPOINT_Y_1";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Z_1 = "DEFAULT_SPAWN_LOCALPOINT_Z_1";
	public static final String DEFAULT_SPAWN_LOCALPOINT_X_2 = "DEFAULT_SPAWN_LOCALPOINT_X_2";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Y_2 = "DEFAULT_SPAWN_LOCALPOINT_Y_2";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Z_2 = "DEFAULT_SPAWN_LOCALPOINT_Z_2";
	public static final String DEFAULT_SPAWN_LOCALPOINT_X_3 = "DEFAULT_SPAWN_LOCALPOINT_X_3";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Y_3 = "DEFAULT_SPAWN_LOCALPOINT_Y_3";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Z_3 = "DEFAULT_SPAWN_LOCALPOINT_Z_3";
	public static final String DEFAULT_SPAWN_LOCALPOINT_X_4 = "DEFAULT_SPAWN_LOCALPOINT_X_4";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Y_4 = "DEFAULT_SPAWN_LOCALPOINT_Y_4";
	public static final String DEFAULT_SPAWN_LOCALPOINT_Z_4 = "DEFAULT_SPAWN_LOCALPOINT_Z_4";
	public static final String PLAYER_DEATH_CREDIT_PUNISHMENT = "PLAYER_DEATH_CREDIT_PUNISHMENT";
	public static final String PLAYER_DEATH_CREDIT_DROP = "PLAYER_DEATH_CREDIT_DROP";
	public static final String PLAYER_DEATH_BLOCK_PUNISHMENT = "PLAYER_DEATH_BLOCK_PUNISHMENT";
	public static final String PLAYER_DEATH_PUNISHMENT_TIME = "PLAYER_DEATH_PUNISHMENT_TIME";
	public static final String PLAYER_DEATH_INVULNERABILITY_TIME = "PLAYER_DEATH_INVULNERABILITY_TIME";
	public static final String PLAYER_HISTORY_BACKLOG = "PLAYER_HISTORY_BACKLOG";
	public static final String PROJECTILES_ADDITIVE_VELOCITY = "PROJECTILES_ADDITIVE_VELOCITY";
	public static final String PROJECTILES_VELOCITY_MULTIPLIER = "PROJECTILES_VELOCITY_MULTIPLIER";
	public static final String IGNORE_DOCKING_AREA = "IGNORE_DOCKING_AREA";
	public static final String ALLOW_UPLOAD_FROM_LOCAL_BLUEPRINTS = "ALLOW_UPLOAD_FROM_LOCAL_BLUEPRINTS";
	public static final String SHOP_NPC_STARTING_CREDITS = "SHOP_NPC_STARTING_CREDITS";
	public static final String SHOP_NPC_RECHARGE_CREDITS = "SHOP_NPC_RECHARGE_CREDITS";
	public static final String AI_WEAPON_AIMING_ACCURACY = "AI_WEAPON_AIMING_ACCURACY";
	public static final String BROADCAST_SHIELD_PERCENTAGE = "BROADCAST_SHIELD_PERCENTAGE";
	public static final String BROADCAST_POWER_PERCENTAGE = "BROADCAST_POWER_PERCENTAGE";
	public static final String ADMINS_CIRCUMVENT_STRUCTURE_CONTROL = "ADMINS_CIRCUMVENT_STRUCTURE_CONTROL";
	public static final String STAR_DAMAGE = "STAR_DAMAGE";
	public static final String SQL_NIO_FILE_SIZE = "SQL_NIO_FILE_SIZE";
	public static final String PLANET_SIZE_MEAN = "PLANET_SIZE_MEAN";
	public static final String PLANET_SIZE_DEVIATION = "PLANET_SIZE_DEVIATION";
	public static final String PLAYER_MAX_BUILD_AREA = "PLAYER_MAX_BUILD_AREA";
	public static final String NT_SPAM_PROTECT_TIME_MS = "NT_SPAM_PROTECT_TIME_MS";
	public static final String NT_SPAM_PROTECT_MAX_ATTEMPTS = "NT_SPAM_PROTECT_MAX_ATTEMPTS";
	public static final String NT_SPAM_PROTECT_EXCEPTIONS = "NT_SPAM_PROTECT_EXCEPTIONS";
	public static final String NT_SPAM_PROTECT_ACTIVE = "NT_SPAM_PROTECT_ACTIVE";
	public static final String USE_PERSONAL_SECTORS = "USE_PERSONAL_SECTORS";
	public static final String BATTLE_MODE = "BATTLE_MODE";
	public static final String BATTLE_MODE_CONFIG = "BATTLE_MODE_CONFIG";
	public static final String BATTLE_MODE_FACTIONS = "BATTLE_MODE_FACTIONS";
	public static final String LEADERBOARD_BACKLOG = "LEADERBOARD_BACKLOG";
	public static final String ANNOUNCE_SERVER_TO_SERVERLIST = "ANNOUNCE_SERVER_TO_SERVERLIST";
	public static final String HOST_NAME_TO_ANNOUNCE_TO_SERVER_LIST = "HOST_NAME_TO_ANNOUNCE_TO_SERVER_LIST";
	public static final String SERVER_LIST_NAME = "SERVER_LIST_NAME";
	public static final String SERVER_LIST_DESCRIPTION = "SERVER_LIST_DESCRIPTION";
	public static final String MISSILE_DEFENSE_FRIENDLY_FIRE = "MISSILE_DEFENSE_FRIENDLY_FIRE";
	public static final String USE_DYNAMIC_RECIPE_PRICES = "USE_DYNAMIC_RECIPE_PRICES";
	public static final String MAKE_HOMBASE_ATTACKABLE_ON_FP_DEFICIT = "MAKE_HOMBASE_ATTACKABLE_ON_FP_DEFICIT";
	public static final String PLANET_SPECIAL_REGION_PROPABILITY = "PLANET_SPECIAL_REGION_PROPABILITY";
	public static final String NT_BLOCKUPDATE_QUEUE_SIZE = "NT_BLOCKUPDATE_QUEUE_SIZE";
	public static final String CHUNK_REQUEST_THREAD_POOL_SIZE_TOTAL = "CHUNK_REQUEST_THREAD_POOL_SIZE_TOTAL";
	public static final String CHUNK_REQUEST_THREAD_POOL_SIZE_CPU = "CHUNK_REQUEST_THREAD_POOL_SIZE_CPU";
	public static final String BUY_BLUEPRINTS_WITH_CREDITS = "BUY_BLUEPRINTS_WITH_CREDITS";
	public static final String MINING_BONUS = "MINING_BONUS";
	public static final String MAX_COORDINATE_BOOKMARKS = "MAX_COORDINATE_BOOKMARKS";
	public static final String ALLOWED_STATIONS_PER_SECTOR = "ALLOWED_STATIONS_PER_SECTOR";
	public static final String STATION_CREDIT_COST = "STATION_CREDIT_COST";

	private final File configFile;
	private final HashMap<String, String> values = new HashMap<String, String>();

	public ServerConfig(final Server server) {

		this.configFile = new File(server.getStarmadeDirectory(), "server.cfg");
		reloadConfig();
	}

	public void reloadConfig() {

		if (configFile.exists() && configFile.canRead() && configFile.canWrite()) {
			try {
				final Scanner sc = new Scanner(configFile);
				while (sc.hasNextLine()) {

					String line = sc.nextLine();

					final String[] itemValue = line.split(" = ");

					if (itemValue.length != 2) {
						continue;
					}

					values.put(itemValue[0], itemValue[1].substring(0, itemValue[1].indexOf(" //")));

				}
				sc.close();
			} catch (final FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public String get(String key) {

		return values.get(key);
	}

	public boolean getBoolean(String key) {

		return Boolean.parseBoolean(get(key));
	}

	public int getInt(String key) {

		return Integer.parseInt(key, 10);
	}

	public long getLong(String key) {

		return Long.parseLong(key, 10);
	}

}
