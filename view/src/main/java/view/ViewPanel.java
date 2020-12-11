package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import contract.IMap;

/**
 * The Class ViewPanel.
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;
	
	/** Map reference */
	private IMap map;
	
	/** The wall sprite */
	private Image wallSprite;
	/** The dirt sprite */
	private Image dirtSprite;
	/** The air sprite */
	private Image airSprite;
	/** The diamond sprite */
	private Image diamondSprite;
	/** The rock sprite */
	private Image rockSprite;
	/** The player sprite */
	private Image playerSprite;
	/** The exit sprite */
	private Image exitSprite;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame, IMap map)
	{
		super();
		this.setViewFrame(viewFrame);
		this.setMap(map);
		
		ImageIcon tempIcon;
		
		tempIcon = new ImageIcon( getClass().getResource("/wall.png") );
		wallSprite = tempIcon.getImage();
		
		tempIcon = new ImageIcon( getClass().getResource("/dirt.png") );
		dirtSprite = tempIcon.getImage();
		
		tempIcon = new ImageIcon( getClass().getResource("/air.png") );
		airSprite = tempIcon.getImage();
		
		tempIcon = new ImageIcon( getClass().getResource("/diamond.png") );
		diamondSprite = tempIcon.getImage();
		
		tempIcon = new ImageIcon( getClass().getResource("/rock.png") );
		rockSprite = tempIcon.getImage();
		
		tempIcon = new ImageIcon( getClass().getResource("/player.png") );
		playerSprite = tempIcon.getImage();
		
		tempIcon = new ImageIcon( getClass().getResource("/exit.png") );
		exitSprite = tempIcon.getImage();
		
		//viewFrame.getModel().getObservable().addObserver(this); TODO
	}

	private ViewFrame getViewFrame()
	{
		return this.viewFrame;
	}

	
	private void setViewFrame(final ViewFrame viewFrame)
	{
		this.viewFrame = viewFrame;
	}

	/**
	 * Update the JPanel with an observable
	 */
	public void update(final Observable arg0, final Object arg1)
	{
		this.repaint();
	}
	
	/**
	 * Update the JPanel
	 */
	public void redraw()
	{
		this.repaint();
	}
	
	public void setMap(IMap map) {
		this.map = map;
	}
	
	/**
	 * Draws the map
	 * 
	 * @param g2
	 *       2D graphic element
	 */
	private void drawMap(Graphics g2)
	{
		for (int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 25; j++)
			{
				switch (map.getSpriteOnCoordinates(i, j))
				{
				case "X":
					g2.drawImage(this.wallSprite, i*32, j*32, null);
					break;
				case "D":
					g2.drawImage(this.dirtSprite, i*32, j*32, null);
					break;
				case "I":
					g2.drawImage(this.diamondSprite, i*32, j*32, null);
					break;
				case "V":
					g2.drawImage(this.airSprite, i*32, j*32, null);
					break;
				case "R":
					g2.drawImage(this.rockSprite, i*32, j*32, null);
					break;
				case "P":
					g2.drawImage(this.playerSprite, i*32, j*32, null);
					this.viewFrame.setTitle(String.valueOf(map.getDiamondCountFromPlayer()));
					break;
				case "E":
					g2.drawImage(this.exitSprite, i*32, j*32, null);
					break;
				}
			}
		}
	}
	
	/**
	 * Draw all elements on the panel
	 * 
	 * @param graphics
	 */
	protected void paintComponent(final Graphics graphics) 
	{
		super.paintComponent(graphics);
		Graphics g2 = (Graphics2D)graphics;
		drawMap(g2);
	}
}
