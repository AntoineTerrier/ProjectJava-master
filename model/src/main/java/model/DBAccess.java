package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import contract.IDBAccess;
import contract.IMap;

import java.sql.Connection;

public class DBAccess implements IDBAccess {
	
	/**
	 * Load map data from the database and store it into a map object
	 * 
	 * @param mapObject
	 * 		The map object which will store the data
	 */
	public void loadDataInMap(IMap mapObject)
	{
		String[][] mapContent = new String[25][25];
		
		String url = "jdbc:mysql://localhost/jpublankproject";
		String username = "projetJava";
		String password = "JAVA";
		
		String request = "SELECT * FROM `map_1`";
		
		Connection connection;
		
		try
		{
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException e)
		{
			throw new IllegalStateException(e);
		}
		
		try
		{
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(request);
			
			int i = 0;
			while (resultset.next())
			{
				String ActualLine = resultset.getString(1);
				for (int y = 0; y < ActualLine.length(); y++)
				{
					mapContent[i][y] = String.valueOf(ActualLine.charAt(y));
				}
				i++;
			}
			
			mapContent[mapObject.getInY()][mapObject.getInY()] = "P";
			mapObject.transformStringTable(mapContent);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
