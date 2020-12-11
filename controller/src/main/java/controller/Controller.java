package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IDBAccess;
import contract.IMap;
import contract.IView;

public final class Controller implements IController
{
	/** The view */
	private IView view;
	
	/** The map */
	private IMap map;
	
	/** The database access */
	private IDBAccess dbaccess;

	/**
	 * Instantiates a new controller
	 *
	 * @param view
	 *          The view
	 * @param map
	 *          The map
	 * @param dbaccess
	 * 			The DataBase Access
	 */
	public Controller(final IView view, final IMap map, final IDBAccess dbaccess)
	{
		this.setView(view);
		this.setMap(map);
		this.setDbaccess(dbaccess);
	}

	/**
	 * The main function of the game
	 */
	public void control()
	{
		map.initIn();
		map.setInX(2);
		map.setInY(2);
		map.initOut();
		map.setOutX(2);
		map.setOutY(5);
		map.setDiamondCount(10);
		this.dbaccess.loadDataInMap(map);
		System.out.println(map);
		this.view.redraw();
	}

	/**
     * Order perform
     *
     * @param controllerOrder
     *            The order the controller will receive
     */
	public void orderPerform(final ControllerOrder controllerOrder)
	{
		switch(controllerOrder)
		{
			case UP:
				map.movePlayer(0, -1);
				view.redraw();
				break;
			case DOWN:
				map.movePlayer(0, 1);
				view.redraw();
				break;
			case LEFT:
				map.movePlayer(-1, 0);
				view.redraw();
				break;
			case RIGHT:
				map.movePlayer(1, 0);
				view.redraw();
				break;
			case STILL:
		}
	}
	
	
	/**
     * Sets the view
     *
     * @param pview
     *            The new view
     */
	private void setView(final IView pview)
	{
		this.view = pview;
	}
	
	/**
	 * Gets the map 
	 * 
	 * @return the map
	 */
	public IMap getMap()
	{
		return map;
	}
	/**
	 * Sets the map
	 * 
	 * @param map
	 * 		The new map
	 */
	public void setMap(IMap map)
	{
		this.map = map;
	}

	/** 
	 * Gets the DataBase Access
	 * 
	 * @return the DataBate Access
	 */
	public IDBAccess getDbaccess()
	{
		return dbaccess;
	}
	/**
	 * Sets the DataBase Access
	 * 
	 * @param dbaccess
	 * 		The new DataBase Access
	 */
	public void setDbaccess(IDBAccess dbaccess)
	{
		this.dbaccess = dbaccess;
	}

}
