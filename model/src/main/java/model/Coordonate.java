package model;

import contract.ICoordonate;

public class Coordonate implements ICoordonate
{
	/** X component */
	public int x;
	/** Y component */
	public int y;

	/**
	 * Constructor of the coordinates couple
	 * 
	 * @param x
	 * @param y
	 */
	public Coordonate(int x,int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
}
