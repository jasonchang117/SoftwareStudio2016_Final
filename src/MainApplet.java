import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextField;
import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

@SuppressWarnings("serial")
public class MainApplet extends PApplet
{
	private final static int width = 960, height = 540;
	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private int curRoom;
	private ControlP5 cp5;
	private int catMove = 0, backbutton = 0, startmenu = 1;
	private AudioClip cat;
	private LeftRoom leftRoom = new LeftRoom(this);
	private Question q = new Question(this);
	private String password = "520053";
	private String[] file = {
		"background/middle.png",
		"background/right.png",
		"background/left.png",
		"background/start.jpg",
		"background/start2.jpg",
		"background/password.png",
		"component/beknif_pusheen.png",
		"component/hammer.png",
		"component/hose.png",
		"component/knif.png",
		"component/normal_bottle.png",
		"component/normal_bottle_full.png",
		"component/pusheen_bottle.png",
		"component/pusheen_bottle_full.png",
		"component/pusheen_cut.png",
		"component/pusheen_hammer.png",
		"component/pushingBack.png",
		"component/pushingLeft.png",
		"component/securitybox.png",
		"component/tape.png",
		"component/pushingFront.png",
	};
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		
		String []temp = new String[10];
		String []temp2 = new String[10];
		for(int i=0;i<file.length;i++)
		{
			
			PImage image = loadImage(this.file[i]);
			temp = this.file[i].split("/");
			images.put(temp[1], image);
		}
		
		cat = getAudioClip(getCodeBase(), "sound/cat.mp3");
		curRoom = 2;
		cp5 =  new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("voice").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
		cp5.addButton("startbutton").setLabel("Start").setPosition(380, 450).setSize(200, 50);
		cp5.addButton("questionnaire").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
		
		cat.play();
	}
	
	public void draw()				// override the processing that paint the main components
	{
		background(0);
		
		if(this.curRoom == 0) //middle room
		{
			image(images.get("middle.png"), 0, 0, 840, 540);
			
			if(this.startmenu == 1)
			{
				cp5.remove("voice");
				cp5.remove("startbutton");
				cp5.remove("questionnaire");
				this.startmenu = 0;
			}
		}
		else if(this.curRoom == 1) //right room
		{
			image(images.get("right.png"), 0, 0, 840, 540);
		}
		else if(this.curRoom == -1) //left room
		{
			image(images.get("left.png"),0,0,840,540);
		}
		else if(this.curRoom == 2) //start room
		{
			if(this.startmenu == 0)
			{
				cp5.addButton("voice").setLabel("Voice On").setPosition(60, 450).setSize(200, 50);
				cp5.addButton("startbutton").setLabel("Start").setPosition(380, 450).setSize(200, 50);
				cp5.addButton("questionnaire").setLabel("questionnaire").setPosition(700, 450).setSize(200,50);
				this.startmenu = 1;
			}
			if(this.catMove < 10 )
				image(images.get("start.jpg"), 0, 0, 960, 540);
			else
				image(images.get("start2.jpg"), 0, 0, 960, 540);
		}
		else if(this.curRoom == 3) //question room
		{
			image(images.get("passward.png"), 0, 0, 960, 540);
			
			if(this.startmenu == 1)
			{
				cp5.remove("voice");
				cp5.remove("startbutton");
				cp5.remove("questionnaire");
				this.startmenu = 0;
			}
			
		}
		
		if(this.catMove < 19)
			this.catMove ++;
		else
			this.catMove = 0;
		
		if( (this.curRoom == 0 || this.curRoom == 1 || this.curRoom == -1 || this.curRoom == 3) && backbutton == 0)     // waiting for modifying
		{
			cp5.addButton("buttonBack").setLabel("Back").setPosition(860, 480).setSize(50,50);
			this.backbutton = 1;
		}
		else if(this.curRoom == 2 && backbutton == 1)
		{
			cp5.remove("buttonBack");
			this.backbutton = 0;
		}
		
		q.display();
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
		this.curRoom = 3;
	}
	
	public void buttonBack()
	{
		this.curRoom = 2;
	}
	
	public int getCurRoom()
	{
		return this.curRoom;
	}
	public String questionPassword(){
		return this.password;
	}
	
	public float getMouseX()
	{
		return mouseX;
	}
	
	public float getMouseY()
	{
		return mouseY;
	}
}