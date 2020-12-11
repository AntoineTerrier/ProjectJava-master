package model;

public class CollidingObject
{
	/** The string code of the char of the object */
	protected String sprite;
	/** The attribute that define if the object can be broken */
	protected Boolean breakable;
	/** The position of the object */
	protected Coordonate position;

	/**
	 * Instantiates a new colliding object
	 * 
	 * @param sprite
	 * 		New sprite attribute
	 * @param breakable
	 * 		New breakable attribute
	 */
	public CollidingObject(String sprite, Boolean breakable)
	{
		this.sprite = sprite;
		this.breakable = breakable;
	}

	/** Make the object fall */
	public void fall(Map map) {}

	public String getSprite()
	{
		return sprite;
	}
	public void setSprite(String sprite)
	{
		this.sprite = sprite;
	}
	
	public boolean isBreakable()
	{
		return breakable;
	}
	public void setBreakable(boolean breakable)
	{
		this.breakable = breakable;
	}
	
	public Coordonate getPosition()
	{
		return position;
	}
	public void setPosition(Coordonate position)
	{
		this.position = position;
	}
}
