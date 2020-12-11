package contract;

public interface IMap
{
	public String getSpriteOnCoordinates(int x, int y);
	public void transformStringTable(String[][] table);
	public int getInX();
	public int getInY();
	public void setInX(int x);
	public void setInY(int y);
	public void initIn();
	public int getOutX();
	public int getOutY();
	public void setOutX(int x);
	public void setOutY(int y);
	public void initOut();
	public void movePlayer(int x, int y);
	public void setDiamondCount(int diamondCount);
	public int getDiamondCountFromPlayer();
	public void stopGame();
}
