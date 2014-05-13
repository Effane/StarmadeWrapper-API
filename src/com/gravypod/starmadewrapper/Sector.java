package com.gravypod.starmadewrapper;

/**
 * Represents a sector with its x, y, and z coords
 * 
 * @author gravypod
 * 
 */
public class Sector {
	
	private final int x, y, z;
	
	/**
	 * Generate a sector based on strings that represent numbers. All numbers are extracted by the <code>{@link Integer}.parseInt()</code> method
	 * @param x
	 * @param y
	 * @param z
	 * @throws Exception - NumberFormatException if the integers cannot be formated. It is casted down to force the end user to catch the exception.
	 */
	public Sector(String x, String y, String z) throws Exception {
		int xPos, yPos, zPos;
		try {
			xPos = Integer.parseInt(x);
			yPos = Integer.parseInt(y);
			zPos = Integer.parseInt(z);
		} catch (NumberFormatException e) {
			throw e;
		}
		this.x = xPos;
		this.y = yPos;
		this.z = zPos;
	}
	
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
