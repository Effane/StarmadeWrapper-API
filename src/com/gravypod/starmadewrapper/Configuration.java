package com.gravypod.starmadewrapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;


public class Configuration {
	
	public static <T extends ConfigurationFile<T>> boolean load(File f, ConfigurationFile<T> defaults) throws IOException {
		
		if (!f.exists()) {
			defaults.setDefault();
			return false;
		}
		YamlReader reader = new YamlReader(new FileReader(f));
		reader.getConfig().setClassTag(defaults.getClass().getSimpleName(), defaults.getClass());
		T t = (T) reader.read();
		reader.close();
		defaults.set(t);
		
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
