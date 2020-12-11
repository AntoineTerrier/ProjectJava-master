package model;

public class Player extends MobileObject
{
	/**
	 * Constructor of the player
	 * Auto-assign the sprite and make it breakable
	 */
	public Player()
	{
		super("P", true);
	}
	
	/**
	 * The number of diamonds that the player collects
	 */
	private int nbDiamondPickedUp;
	
	/**
	 * Move function of the player
	 * 
	 * @param vector
	 * 		Movement vector
	 * @param map
	 * 		The map
	 */
	public void move (Coordonate vector, Map map)
	{
		CollidingObject[][] tempMap = map.getContent();
		if (tempMap[this.position.y + vector.y][this.position.x + vector.x].isBreakable())
		{
			if (tempMap[this.position.y + vector.y][this.position.x + vector.x].getClass() == Diamond.class)
			{
				this.nbDiamondPickedUp++;
				if (this.nbDiamondPickedUp >= map.getDiamondCount())
				{
					map.showExit();
					tempMap = map.getContent();
				}
			}
			if (tempMap[this.position.y + vector.y][this.position.x + vector.x].getClass() == Exit.class)
			{
				map.stopGame();
			}
			
			tempMap[this.position.y + vector.y][this.position.x + vector.x] = this;
			tempMap[this.position.y][this.position.x] = new Air();
			if (!(vector.y < 0))
			{
				tempMap[this.position.y - 1][this.position.x].fall(map);
			}
			this.position = new Coordonate(this.position.x + vector.x, this.position.y + vector.y);
			map.setContent(tempMap);
		}
	}
	
	public int getNbDiamondPickedUp()
	{
		return nbDiamondPickedUp;
	}
	public void setNbDiamondPickedUp(int nbDiamondPickedUp)
	{
		this.nbDiamondPickedUp = nbDiamondPickedUp;
	}
	
}
