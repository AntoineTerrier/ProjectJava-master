package model;

public class MobileObject extends CollidingObject
{
	/**
	 * Inherited constructor
	 * 
	 * @param sprite
	 * 		String code of the sprite
	 * @param breakable
	 * 		Boolean that define if the object can be broken by the movement of another one
	 */
	public MobileObject(String sprite, Boolean breakable)
	{
		super(sprite, breakable);
	}
	
	/**
	 * The function that move an object
	 *
	 * @param vector
	 * 		Vector that define the movement of the object
	 * @param map
	 * 		Map object that will be affected by the changes
	 */
	public void move(Coordonate vector, Map map)
	{
		CollidingObject[][] tempMap = map.getContent();
		if (tempMap[this.position.y + vector.y][this.position.x + vector.x].getClass() == Air.class)
		{
			tempMap[this.position.y + vector.y][this.position.x + vector.x] = this;
			tempMap[this.position.y][this.position.x] = new Air();
			tempMap[this.position.y - 1][this.position.x].fall(map);
			this.position = new Coordonate(this.position.x + vector.x, this.position.y + vector.y);
			map.setContent(tempMap);
			this.fall(map);
		}
		if (tempMap[this.position.y + vector.y][this.position.x + vector.x].getClass() == Player.class)
		{
			map.stopGame();
		}
	}
	
	/** Make the object fall */
	public void fall(Map map)
	{
		this.move(new Coordonate(0, 1), map);
	}
}
