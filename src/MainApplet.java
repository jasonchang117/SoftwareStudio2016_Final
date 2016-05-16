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
	private PImage middleroom;
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		middleroom = loadImage("background/right.png");
		
		size(width, height);
	}
	
	public void draw()				// override the processing that paint the main components
	{
		background(0);
		image(middleroom, 0, 0, 840, 540);
	}
}