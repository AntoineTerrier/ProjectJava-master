package model;

public class StaticObject extends CollidingObject
{
	/**
	 * Just an inherited constructor
	 * 
	 * @param sprite
	 * 		String code of the sprite
	 * @param breakable
	 * 		Boolean that define if the object can be broken by the movement of another one
	 */
	public StaticObject(String sprite, Boolean breakable)
	{
		super(sprite, breakable);
	}
}
