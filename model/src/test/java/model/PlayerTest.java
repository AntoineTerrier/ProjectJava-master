	package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

	private static Map map;
	private static DBAccess dbAccess;
	private static String[][] testTable;
	
	@BeforeClass
	public static void SetUp()
	{

		map = new Map();
		dbAccess = new DBAccess();
		map.initIn();
		map.setInX(2);
		map.setInY(2);	
		map.initOut();
		map.setOutX(2);
		map.setOutY(5);
		map.setDiamondCount(10);
	}
	
	@Test
	public void testMove() {
		dbAccess.loadDataInMap(map);
		CollidingObject player = map.Content[2][2];
		Air testAir = new Air();
		map.movePlayer(0, 1);
		assertEquals(player, map.Content[3][2]);		
		assertEquals(testAir.getClass(), map.Content[2][2].getClass());
	}
	
	@Test
	public void testBreakable() {
		dbAccess.loadDataInMap(map);
		CollidingObject player = map.Content[2][2];
		CollidingObject target = map.Content[2][0];
		map.movePlayer(0, -2);
		assertEquals(player, map.Content[2][2]);
		assertEquals(target, map.Content[2][0]);
	}
	
	@Test
	public void testDiamondPick() {
		dbAccess.loadDataInMap(map);
		int nbDiamondCountExpected = 1;
		map.movePlayer(3, 0);
		assertEquals(nbDiamondCountExpected,map.getDiamondCountFromPlayer());	
	}
	
	@Test
	public void testOut() {
		dbAccess.loadDataInMap(map);
		map.movePlayer(3, 0); 
		map.movePlayer(0, 3);
		map.movePlayer(4, -1);
		map.movePlayer(3, 0);
		map.movePlayer(-1, 3);
		map.movePlayer(2, 0);
		map.movePlayer(1, -6);
		map.movePlayer(1, 2);
		map.movePlayer(2, 0);
		map.movePlayer(3, -2);
		assertEquals(Exit.class, map.Content[5][2].getClass());
	}
	
	// Note : we really wanted to make this test, but the form of the test don't look pertinent to us
	@Test
	public void testGetSet()
	{
		dbAccess.loadDataInMap(map);
		map.setOutX(17);
		assertEquals(17, map.getOutX());
	}
}
