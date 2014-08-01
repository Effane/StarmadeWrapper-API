package com.gravypod.starmadewrapper.plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

import com.gravypod.starmadewrapper.Server;
import com.gravypod.starmadewrapper.plugins.commands.CommandManager;
import com.gravypod.starmadewrapper.plugins.events.EventManager;
import com.gravypod.starmadewrapper.plugins.events.Events;

/**
 * Manages everyday {@link Plugin} functionality. EX Loading, And disabling a
 * plugin
 * 
 * @author gravypod
 * 
 */
public class PluginManager {
	
	/** {@link MinecraftServer} instance */
	private final Server server;
	
	private final CommandManager commandManager;
	
	/** {@link Logger} instance */
	private final Logger log;
	
	/** Loaded {@link Plugin} {@link HashMap}. */
	private final HashMap<String, Plugin> loadedPlugins = new HashMap<String, Plugin>();
	private final HashMap<File, Properties> pluginPropCach = new HashMap<File, Properties>();
	
	/** Main {@link EventManager} */
	private final EventManager eventManager = new EventManager();
	
	/** {@link PluginAssistant} manager */
	private final PluginAssistant assistant;
	
	private final File pluginFolder;
	private final GravyModClassLoader classLoader = new GravyModClassLoader(new URL[0], getClass().getClassLoader());
	
	/**
	 * Create a new {@link PluginManager}
	 * 
	 * @param logger
	 *            - {@link Logger} instance from the server
	 */
	public PluginManager(Logger logger, Server server, CommandManager commandManager) {
	
		log = logger;
		
		log.info("Started plugin handler");
		pluginFolder = new File("./plugins/");
		this.server = server;
		this.commandManager = commandManager;
		Events.init(eventManager);
		assistant = new PluginAssistant(eventManager, this, log);
		
	}
	
	/**
	 * Load all of the .jar files in ./plugins/ into {@link Plugin} objects
	 * This also runs onEnabled() and init()
	 */
	public void loadPlugins() {
	
		if (!pluginFolder.exists()) {
			pluginFolder.mkdir();
			return;
		}
		
		File[] pluginFiles = pluginFolder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
			
				return arg1.endsWith(".jar");
				
			}
			
		});
		
		Arrays.sort(pluginFiles, new Comparator<File>() {
			
			@Override
			public int compare(File plugin1, File plugin2) {
				Properties p1, p2;
				try {
					p1 = getPluginProp(plugin1);
					p2 = getPluginProp(plugin2);
				} catch (IOException e) {
					e.printStackTrace();
					return 0;
				}
				
				if (p1.containsKey("depends")) {
					return p1.getProperty("depends").contains(p2.getProperty("name")) ? 1 : -1;
				} else if (p2.containsKey("depends")) {
					return p2.getProperty("depends").contains(p1.getProperty("name")) ? 1 : -1;
				} else {
					return p1.getProperty("name").compareTo(p2.getProperty("name"));
				}
			}
		});
		
		for (File f : pluginFiles) {
			loadPluginFile(f);
		}
		
	}
	
	/**
	 * Load a jar {@link File} into a {@link Plugin}
	 * 
	 * @param jar
	 *            - {@link File} to load into a {@link Plugin}. Must contain a
	 *            plugin.prop with name and main
	 */
	public void loadPluginFile(File jar) {
	
		try {
			
			Properties prop = getPluginProp(jar);
			
			URL url = jar.toURI().toURL();
			
			String main = prop.getProperty("main");
			
			String name = prop.getProperty("name");
			
			if (main.isEmpty() || name.isEmpty()) {
				throw new Exception("Your plugin did not contain a name or a main in plugin.prop");
			}
			
			classLoader.addURL(url);
			Class<?> jarClass = Class.forName(main, true, classLoader);
			
			Class<? extends Plugin> plugin = jarClass.asSubclass(Plugin.class);
			
			Constructor<? extends Plugin> constructor = plugin.getConstructor();
			
			Plugin result = constructor.newInstance();
			
			result.init(assistant, main, name);
			
			result.onEnable(server);
			
			loadedPlugins.put(name, result);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getStackTrace().toString());
		}
	}
	
	private Properties getPluginProp(File f) throws IOException {
	
		Properties prop = pluginPropCach.get(f);
		
		if (prop != null) {
			return prop;
		}
		
		JarFile jarFile = new JarFile(f);
		
		JarEntry jarEntry = jarFile.getJarEntry("plugin.prop");
		
		InputStream is = jarFile.getInputStream(jarEntry);
		
		prop = new Properties();
		
		prop.load(is);
		
		jarFile.close();
		
		pluginPropCach.put(f, prop);
		
		return prop;
	}
	
	/**
	 * Disable all {@link Plugin}s
	 */
	public void disablePlugins() {
	
		for (Plugin plugin : loadedPlugins.values()) {
			
			plugin.onDisable(server);
			
		}
		
	}
	
	/**
	 * Disable a plugin by its name
	 * 
	 * @param name
	 *            - {@link String} of the plugins name
	 */
	public void disablePlugin(String name) {
	
		Plugin plugin = getPlugin(name);
		
		if (plugin == null) {
			throw new IllegalArgumentException("That plugin is not enabled");
		}
		
		plugin.onDisable(server);
		
	}
	
	/**
	 * Get a {@link Plugin} by its name
	 * 
	 * @param name
	 *            - {@link String} of the {@link Plugin}s name
	 * @return - {@link Plugin} instance of it is loaded, <code>null</code>
	 *         otherwise
	 */
	public Plugin getPlugin(String name) {
	
		if (!loadedPlugins.containsKey(name)) {
			return null;
		}
		
		return loadedPlugins.get(name);
		
	}
	
	/**
	 * {@link EventManager} instance
	 * 
	 * @return - {@link EventManager} instance
	 */
	public EventManager getEventManager() {
	
		return eventManager;
	}
	
	/**
	 * Get a {@link Collection} of enabled {@link Plugin}s
	 * 
	 * @return - {@link Collection} of {@link Plugin}s
	 */
	public Collection<Plugin> getEnabledPlugins() {
	
		return loadedPlugins.values();
	}
	
	/**
	 * Get a {@link Collection} of enabled {@link Plugin}'s Names
	 * 
	 * @return - {@link Collection} of {@link String}s
	 */
	public Set<String> getEnabledPluginsNames() {
	
		return loadedPlugins.keySet();
	}
	
	/**
	 * Get the command manager to register commands to.
	 * 
	 * @return
	 */
	public CommandManager getCommandManager() {
	
		return commandManager;
	}
	
	public File getDirectory() {
	
		return pluginFolder;
	}
	
	public void reloadPlugins() {
	
		for (Plugin plugin : loadedPlugins.values()) {
			
			plugin.onDisable(server);
			plugin.onEnable(server);
		}
	}
}
