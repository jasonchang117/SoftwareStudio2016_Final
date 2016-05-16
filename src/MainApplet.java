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
	private PImage middleroom, rightroom, leftroom, start, start2;
	private int curRoom;
	private ControlP5 cp5;
	private int catMove = 0;
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		leftroom = loadImage("background/left.png");
		middleroom = loadImage("background/middle.png");
		rightroom = loadImage("background/right.png");
		start = loadImage("background/start.jpg");
		start2 = loadImage("background/start2.jpg");
		curRoom = 2;
		
		
		cp5 =  new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("buttonA").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
		cp5.addButton("buttonB").setLabel("Start").setPosition(380, 450).setSize(200, 50);
		cp5.addButton("buttonC").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
		
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
		else if(this.curRoom == 2){
			if(this.catMove < 10 )
				image(start, 0, 0, 960, 540);
			else
				image(start2, 0, 0, 960, 540);
		}
		if(this.catMove < 19)
			this.catMove ++;
		else
			this.catMove = 0;
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