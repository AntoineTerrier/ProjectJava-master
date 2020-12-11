package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IMap;
import contract.IView;

/**
 * The Class View.
 */
public final class View implements IView, Runnable
{
	/**
	 * The Frame
	 */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          The model
	 */
	public View(final IMap model)
	{
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order: associates the key entered with its direction
	 *
	 * @param keyCode
	 *          the key entered
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode)
	{
		switch (keyCode) 
		{
			case KeyEvent.VK_Q:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_D:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_S:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_Z:
				return ControllerOrder.UP;
			default:
				return ControllerOrder.STILL;
		}
	}

	/**
	 * Run the graphic interface
	 */
	public void run()
	{
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller)
	{
		this.viewFrame.setController(controller);
	}
	
	/**
	 * Redraw the map to refresh it
	 */
	public void redraw()
	{
		this.viewFrame.getViewPanel().redraw();
	}
}
