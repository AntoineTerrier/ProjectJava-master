package model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DBAccessTest {
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
	}
		
	@Test
	public void testMap() 
	{
		dbAccess.loadDataInMap(map);
		assertEquals(map.Content[0][0].getClass(),Wall.class);
		assertEquals(map.Content[1][1].getClass(),Dirt.class);
		assertEquals(map.Content[4][3].getClass(),Rock.class);
	}
}
