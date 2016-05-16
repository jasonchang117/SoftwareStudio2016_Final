import java.awt.event.KeyEvent;
import java.util.ArrayList;
import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class MainApplet extends PApplet
{
	private final static int width = 960, height = 540;
	private PImage middleroom, rightroom, leftroom, start;
	private int curRoom;
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		leftroom = loadImage("background/left.png");
		middleroom = loadImage("background/middle.png");
		rightroom = loadImage("background/right.png");
		curRoom = 0;
		
		size(width, height);
	}
	
	public void draw()				// override the processing that paint the main components
	{
		background(0);
		if(this.curRoom == 0)
			image(middleroom, 0, 0, 840, 540);
		else if(this.curRoom == 1)
			image(rightroom, 0, 0, 840, 540);
		else if(this.curRoom == -1)
			image(leftroom, 0, 0, 840, 540);
	}
	
	public void keyPressed(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && curRoom < 1)
		{
			this.curRoom += 1;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_LEFT && curRoom > -1)
		{
			this.curRoom -= 1;
		}
	}
}