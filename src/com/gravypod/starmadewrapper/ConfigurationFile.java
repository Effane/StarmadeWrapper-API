package com.gravypod.starmadewrapper;

public interface ConfigurationFile<T> {
	
	/**
	 * Set the default values for this config
	 */
	public void setDefault();
	
	/**
	 * Set the values to that of this object
	 * 
	 * @param t
	 */
	public void set(T t);
	
}
