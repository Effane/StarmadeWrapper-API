package com.gravypod.starmadewrapper;

/**
 * Represents a sector with its x, y, and z coords
 * 
 * @author gravypod
 * 
 */
public class Sector {
	
	private final int x, y, z;
	
	public Sector(int x, int y, int z) {
	
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Get sector X
	 * 
	 * @return
	 */
	public int getX() {
	
		return x;
	}
	
	/**
	 * Get sector Y
	 * 
	 * @return
	 */
	public int getY() {
	
		return y;
	}
	
	/**
	 * Get sector Z
	 * 
	 * @return
	 */
	public int getZ() {
	
		return z;
	}
	
	@Override
	public String toString() {
	
		return x + "," + y + "," + z;
	}
	
	@Override
	public boolean equals(Object arg0) {
		
		if (!(arg0 instanceof Sector))
			return super.equals(arg0);
		Sector s = (Sector) arg0;
		return s.x == x && s.y == y && s.z == z;
	}
	
}
