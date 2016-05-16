import java.awt.event.KeyEvent;
import java.util.ArrayList;
import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class MainApplet extends PApplet
{
	private final static int width = 700, height = 480;
	
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		
		size(width, height);
	}
	
	public void draw()				// override the processing that paint the main components
	{
		background(255);
		
	}
}