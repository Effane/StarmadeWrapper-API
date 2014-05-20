package com.gravypod.starmadewrapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;


public class Configuration {
	
	/**
	 * Attempt to load a config file. Returns false if the file did not exist or could not be read/parsed by YamlBeans
	 * @param f - File to check
	 * @param defaults - Default object to load to
	 * @return - True if loaded correctly, false as specified above
	 */
	public static <T extends ConfigurationFile<T>> boolean load(File f, ConfigurationFile<T> defaults) {
		
		if (!f.exists()) {
			defaults.setDefault();
			return false;
		}
		YamlReader reader;
		try {
			reader = new YamlReader(new FileReader(f));
			reader.getConfig().setClassTag(defaults.getClass().getSimpleName(), defaults.getClass());
			@SuppressWarnings("unchecked")
			T t = (T) reader.read();
			reader.close();
			defaults.set(t);
		} catch (Exception e) {
			e.printStackTrace();
			defaults.setDefault();
			return false;
		}
		
		return true;
		
		
	}
	
	public static <T extends ConfigurationFile<T>> void save(File f, T t) throws IOException {
		
		if (!f.exists()) {
			f.getParentFile().mkdirs(); // TODO: check if it works
			f.createNewFile();
		}
		
		YamlWriter writer = new YamlWriter(new FileWriter(f));

		writer.getConfig().setClassTag(t.getClass().getSimpleName(), t.getClass());
		writer.write(t);
		
		writer.close();
		
	}
	
	
}
