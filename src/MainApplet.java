import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;

@SuppressWarnings("serial")
public class MainApplet extends PApplet
{
	private final static int width = 960, height = 540;
	private PImage middleroom, rightroom, leftroom, start, start2, passwordBackground;
	private int curRoom;
	private ControlP5 cp5;
	private int catMove = 0, question = 0, backbutton = 0, startmenu = 1;
	private  AudioClip cat;
	private JTextField password = new JTextField();
	private LeftRoom leftRoom = new LeftRoom(this);
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		
		leftroom = loadImage("background/left.png");
		middleroom = loadImage("background/middle.png");
		rightroom = loadImage("background/right.png");
		start = loadImage("background/start.jpg");
		start2 = loadImage("background/start2.jpg");
		passwordBackground = loadImage("background/password.png");
		cat = getAudioClip(getCodeBase(), "sound/cat.mp3");
		curRoom = 2;
		
		cp5 =  new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("voice").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
		cp5.addButton("startbutton").setLabel("Start").setPosition(380, 450).setSize(200, 50);
		cp5.addButton("questionnaire").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
		
		// password
		password.setBounds(0,430,300,30);
		
		cat.play();
		
	}
	
	public void draw()				// override the processing that paint the main components
	{
		background(0);
		
		if(this.curRoom == 0)
		{
			if(question == 1)
				image(passwordBackground, 0, 0, 960, 540);
			else
				image(middleroom, 0, 0, 840, 540);
			
			if(this.startmenu == 1)
			{
				cp5.remove("voice");
				cp5.remove("startbutton");
				cp5.remove("questionnaire");
				this.startmenu = 0;
			}
		}
		else if(this.curRoom == 1)
		{
			image(rightroom, 0, 0, 840, 540);
		}
		else if(this.curRoom == -1)
		{
			image(leftroom, 0, 0, 840, 540);
			leftRoom.drawknif();
		}
		else if(this.curRoom == 2)
		{
			if(this.startmenu == 0)
			{
				cp5.addButton("voice").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
				cp5.addButton("startbutton").setLabel("Start").setPosition(380, 450).setSize(200, 50);
				cp5.addButton("questionnaire").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
				this.startmenu = 1;
			}
			if(this.catMove < 10 )
				image(start, 0, 0, 960, 540);
			else
				image(start2, 0, 0, 960, 540);
		}
		
		if(this.catMove < 19)
			this.catMove ++;
		else
			this.catMove = 0;
		
		if( (this.curRoom == 0 || this.curRoom == 1 || this.curRoom == -1) && backbutton == 0)     // waiting for modifying
		{
			cp5.addButton("buttonBack").setLabel("Back").setPosition(860, 480).setSize(50,50);
			this.backbutton = 1;
		}
		else if(this.curRoom == 2 && backbutton == 1)
		{
			cp5.remove("buttonBack");
			this.backbutton = 0;
		}
	}
	
	public void keyPressed(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && curRoom < 1)
		{
			this.curRoom += 1;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_LEFT && curRoom > -1 && curRoom != 2)
		{
			this.curRoom -= 1;
		}
	}
	
	public void voice()
	{
		
	}
	
	public void startbutton()
	{
		this.curRoom = 0;
	}
	
	public void questionnaire()
	{
		this.curRoom = 0;
		this.question = 1;
	//	this.add(password);
	}
	
	public void buttonBack()
	{
		this.curRoom = 2;
	}
	
	
}