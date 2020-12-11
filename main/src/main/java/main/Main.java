package main;

import controller.Controller;
import model.DBAccess;
import model.Map;
import view.View;

public abstract class Main
{
    /**
     * The main method
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args)
    {
    	final DBAccess dbaccess = new DBAccess();
        final Map model = new Map();
        final View view = new View(model);
        final Controller controller = new Controller(view, model, dbaccess);
        view.setController(controller);

        controller.control();
    }
}
