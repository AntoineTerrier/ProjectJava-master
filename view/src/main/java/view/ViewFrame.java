package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IMap;


class ViewFrame extends JFrame implements KeyListener {

	/** The map */
	private IMap model;
	/** The ViewPanel */
	private ViewPanel viewPanel;
	/** The controller. */
	private IController controller;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the map
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IMap model) throws HeadlessException
	{
		this.model = model;
		viewPanel = new ViewPanel(this, this.model);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame
	 *
	 * @param model
	 *          the map
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IMap model, final GraphicsConfiguration gc)
	{
		super(gc);
		this.model = model;
		viewPanel = new ViewPanel(this, this.model);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame
	 *
	 * @param model
	 *          the map
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IMap model, final String title) throws HeadlessException
	{
		super(title);
		this.model = model;
		viewPanel = new ViewPanel(this, this.model);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IMap model, final String title, final GraphicsConfiguration gc)
	{
		super(title, gc);
		this.model = model;
		viewPanel = new ViewPanel(this, this.model);
		this.buildViewFrame(model);
	}


	private IController getController()
	{
		return this.controller;
	}

	
	protected void setController(final IController controller)
	{
		this.controller = controller;
	}

	
	protected IMap getModel()
	{
		return this.model;
	}


	private void setModel(final IMap model)
	{
		this.model = model;
	}

	/**
	 * Builds the view frame
	 *
	 * @param model
	 *          the map
	 */
	private void buildViewFrame(final IMap model)
	{
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(this.viewPanel);
		this.setSize(25*32, 26*32);
		this.setLocationRelativeTo(null);
	}
	
	public ViewPanel getViewPanel()
	{
		return this.viewPanel;
	}

	/**
	 * Warns the method keyCodeToControllerOrder when a key is typed
	 * 
	 * @param e
	 */
	public void keyTyped(final KeyEvent e) {}

	/**
	 * Warns the method keyCodeToControllerOrder when a key is pressed
	 * 
	 * @param e
	 */
	public void keyPressed(final KeyEvent e) {}

	/**
	 * Warns the method keyCodeToControllerOrder when a key is released
	 * 
	 * @param e
	 */
	public void keyReleased(final KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		}
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		}
		if (e.getKeyCode() == KeyEvent.VK_Z)
		{
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		}	
	}
}
