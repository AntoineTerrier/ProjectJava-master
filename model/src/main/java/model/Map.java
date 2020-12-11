package model;

import java.util.Observable;

import contract.IMap;

public final class Map extends Observable implements IMap
{
	/** The starting position of the level */
	private Coordonate in;
	/** The exit position of the level */
	private Coordonate out;
	/** The amount of diamond required to show the exit */
	private int diamondCount;
	/** The level data (dirt, rock, diamonds...) */
	public CollidingObject[][] Content;
	/** Reference to the player */
	private Player player;
	
	/**
	 * Transform a string table into objects and store it into the content of the map
	 * Only deal with walls, dirt and diamonds
	 * 
	 * @param table
	 * 		The table to convert
	 */
	public void transformStringTable(String[][] table)
	{
		Content = new CollidingObject[25][25];
		for (int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 25; j++)
			{
				switch (table[i][j])
				{
				case "V":
					Content[i][j] = new Air();
					Content[i][j].position = new Coordonate(j, i);
					break;
				case "X":
					Content[i][j] = new Wall();
					Content[i][j].position = new Coordonate(j, i);
					break;
				case "D":
					Content[i][j] = new Dirt();
					Content[i][j].position = new Coordonate(j, i);
					break;
				case "I":
					Content[i][j] = new Diamond();
					Content[i][j].position = new Coordonate(j, i);
					break;
				case "R":
					Content[i][j] = new Rock();
					Content[i][j].position = new Coordonate(j, i);
					 break;
				case "P":
					Content[i][j] = new Player();
					player = (Player)Content[i][j];
					player.position = new Coordonate(j, i);
					break;
				}
			}
		}
	}
	
	/** Get the diamond count of the player */
	public int getDiamondCountFromPlayer()
	{
		return player.getNbDiamondPickedUp();
	}
	
	/** Stop the game by filling the map with dirt */
	public void stopGame()
	{
		for (int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 25; j++)
			{
				Content[i][j] = new Wall();
			}
		}
	}
	
	/**
	 * Gets the sprite code of an object
	 * 
	 * @return
	 * 		The sprite code of the object
	 */
	public String getSpriteOnCoordinates(int x, int y)
	{
		return this.Content[y][x].getSprite();
	}
	
	/**
	 * Move the player
	 * 
	 * @param x
	 * 		X amplitude of the player movement
	 * @param y
	 * 		Y amplitude of the player movement
	 */
	public void movePlayer(int x, int y)
	{
		player.move(new Coordonate(x, y), this);
	}
	
	/** Make the map show the exit tile */
	public void showExit()
	{
		Content[out.y][out.x] = new Exit();
	}
	
	/** Initialize a new in position */
	public void initIn()
	{
		in = new Coordonate(0, 0);
	}
	/** Initialize a new out position */
	public void initOut()
	{
		out = new Coordonate(0, 0);
	}
	
	
	public Coordonate getIn()
	{
		return in;
	}
	public void setIn(Coordonate in)
	{
		this.in = in;
	}
	public int getInX()
	{
		return in.getX();
	}
	public int getInY()
	{
		return in.getY();
	}
	public void setInX(int x)
	{
		this.in.setX(x);
	}
	public void setInY(int y)
	{
		this.in.setY(y);
	}
	
	
	public Coordonate getOut()
	{
		return out;
	}
	public void setOut(Coordonate out)
	{
		this.out = out;
	}
	public int getOutX()
	{
		return out.getX();
	}
	public int getOutY()
	{
		return out.getY();
	}
	public void setOutX(int x)
	{
		this.out.setX(x);
	}
	public void setOutY(int y)
	{
		this.out.setY(y);
	}

	public int getDiamondCount() {
		return diamondCount;
	}
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}
	
	public CollidingObject[][] getContent() {
		return Content;
	}
	public void setContent(CollidingObject[][] content) {
		Content = content;
	}
}
