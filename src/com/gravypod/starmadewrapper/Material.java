package com.gravypod.starmadewrapper;

import com.gravypod.starmadewrapper.plugins.material.MaterialData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Material {
	
	private static Material[] byId;
	
	private final static Map<String, Material> BY_NAME = new HashMap<String, Material>();
	
	/**
	 * Load a block file into {@link Material} info. You should never call this,
	 * this is managed by the wrapper
	 * 
	 * @param blockConfig
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void load(File blockConfig) throws FileNotFoundException, IOException {
	
		Properties props = new Properties();
		props.load(new FileInputStream(blockConfig));
		
		byId = new Material[props.values().size()];
		
		for (Entry<Object, Object> binding : props.entrySet()) {
			try {
				
				String name = (String) binding.getKey();
				int id = Integer.parseInt((String) binding.getValue());
				
				Material mat = new Material(name, id);
				
				if (byId.length <= id) {
					byId = Arrays.copyOf(byId, id + 1); // Startup time for
														// functionality? Meh,
														// its k
				}
				
				byId[id] = mat;
				BY_NAME.put(mat.getName(), mat);
				
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
	}
	
	public static Material[] values() {
	
		return byId;
	}
	
	/**
	 * Attempts to get the Material with the given name
	 * 
	 * @param name
	 *            Name of the material to get
	 * @return Material if found, else null
	 */
	public static Material getMaterial(final String name) {
	
		return BY_NAME.get(name);
	}
	
	/**
	 * Attempts to get the Material with the given ID
	 * 
	 * @param id
	 *            ID of the material to get
	 * @return Material if found, else null
	 */
	public static Material getMaterial(final int id) {
	
		if (byId.length > id && id >= 0) {
			return byId[id];
		} else {
			return null;
		}
	}
	
	private final int id;
	private final String name;
	private final Constructor<? extends MaterialData> ctor;
	
	private Material(String name, final int id) {
	
		this(name, id, MaterialData.class);
	}
	
	private Material(String name, final int id, final Class<? extends MaterialData> data) {
	
		this.id = id;
		this.name = name;
		try {
			this.ctor = data.getConstructor(int.class);
		} catch (NoSuchMethodException e) {
			throw new AssertionError();
		} catch (SecurityException e) {
			throw new AssertionError();
		}
	}
	
	@Override
	public String toString() {
	
		return "Material: " + id + " " + name;
	}
	
	/**
	 * Gets the item or block ID of this material
	 * 
	 * @return ID of material
	 */
	public int getId() {
	
		return id;
	}
	
	/**
	 * Gets the MaterialData class associated with this Material
	 * 
	 * @return MaterialData associated with this Material
	 */
	public Class<? extends MaterialData> getData() {
	
		return ctor.getDeclaringClass();
	}
	
	public String getName() {
	
		return name;
	}
	
	public String name() {
	
		return name;
	}
	
}
