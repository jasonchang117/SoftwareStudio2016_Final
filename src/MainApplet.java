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
	private int questionButton = 0;
	private int inputQuestion = 0;
	private int pusheenNum = 0;
	private AudioClip cat;
	private LeftRoom leftRoom = new LeftRoom();
	private RightRoom rightRoom = new RightRoom();
	private MiddleRoom middleRoom = new MiddleRoom();
	private Question q = new Question(this);
	private questionSet qs = new questionSet(this);
	private String password = "520053";
	private int lighter = 1;
	private int lighterx = 860, lightery = 10, lighterwidth = 50, lighterheight = 100;
	private int xOffset, yOffset;
	private boolean locked = false, overobject;
	private String[] file = {
		"background/middle.png",
		"background/right.png",
		"background/left.png",
		"background/start.jpg",
		"background/start2.jpg",
		"background/password.png",
		"background/setquestion.png",
		"background/questionInput.png",
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
		"component/pusheenBack.png",
		"component/pusheenLeft.png",
		"component/securitybox.png",
		"component/tape.png",
		"component/pusheenFront.png",
		"component/lighter.png",
		"component/lighterfire.png",
		"component/pusheeenBottle+hose.png",
		"component/pusheen.png",
	};
	
	public void setup()				// override the processing that initial the applet
	{	
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		
		String []temp = new String[10];
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
			
			if(middleRoom.pusheenBottle() == 1){
				image(images.get("pusheen_bottle.png"), 405, 295, 80, 60);
			}
			if(middleRoom.securitybox() == 1){
				image(images.get("securitybox.png"), 346, 160, 100, 100);
			}
			if(middleRoom.knif() == 1){
				image(images.get("knif.png"), 385, 180, 40, 60);
			}
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
			
			if(rightRoom.tape() == 1){
				image(images.get("tape.png"), 400, 470, 60, 60);
			}
		}
		else if(this.curRoom == -1) //left room
		{
			image(images.get("left.png"),0,0,840,540);
			
			if(leftRoom.pusheenFront()==1)
			{
				if(pusheenNum%90 < 30){
					image(images.get("pusheenFront.png"), 350, 250, 150,150);
				}
				else if(pusheenNum%90 < 60){
					image(images.get("pusheenLeft.png"), 350, 250, 150, 150);
				}
				else {
					image(images.get("pusheenBack.png"), 350, 250, 150, 150);
				}
				pusheenNum++;
			}
			if(leftRoom.normalBottle()==1){
				image(images.get("normal_bottle.png"), 50, 350,75,75);
			}
			if(leftRoom.hose()==1){
				image(images.get("hose.png"), 0,0);
			}
			if(leftRoom.securitybox()==1){
				image(images.get("securitybox.png"), 0, 0,840,540);
			}
			if(leftRoom.pusheenCut()==1){
				image(images.get("pusheen_cut.png"), 0, 0, 840, 540);
			}
			if(leftRoom.pusheenWithoutHammer()==1){
				image(images.get("pusheen_hammer.png"), 0, 0, 840, 540);
			}
			if(leftRoom.hammer()==1){
				image(images.get("hammer.png"), 397, 230,90,90);
			}
			if(leftRoom.pusheenBeKnif()==1){
				image(images.get("beknif_pusheen.png"), 0, 0, 840, 540);
			}
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
			if(q.getQuestionSet() == false){
				image(images.get("password.png"), 0, 0, 960, 540);
			}
			
			if(q.getQuestionSet()== true ){
				image(images.get("setquestion.png"), 0, 0, 960, 540);
				
				if(questionButton == 0){
					 q.removeText();	
					 cp5.addButton("questionOne").setLabel("Question 1").setPosition(70, 100).setSize(200, 70);
					 cp5.addButton("questionTwo").setLabel("Question 2").setPosition(680, 100).setSize(200, 70);
					 cp5.addButton("questionThree").setLabel("Question 3").setPosition(70, 200).setSize(200, 70);
					 cp5.addButton("questionFour").setLabel("Question 4").setPosition(680, 200).setSize(200, 70);
					 cp5.addButton("questionFive").setLabel("Question 5").setPosition(70, 300).setSize(200, 70);
					 cp5.addButton("questionSix").setLabel("Question 6").setPosition(680, 300).setSize(200, 70);
					 questionButton = 1;
				}
			}
			
			if(inputQuestion == 1)
			{	 		
				 cp5.remove("questionOne");
				 cp5.remove("questionTwo");
				 cp5.remove("questionThree");
				 cp5.remove("questionFour");
				 cp5.remove("questionFive");
				 cp5.remove("questionSix");
				 image(images.get("questionInput.png"), 0, 0, 960, 540);
			}
			
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
		
		//for object drag but it can only drag lighter now	
		image(images.get("lighter.png"), middleRoom.getComX("lighter"), middleRoom.getComY("lighter"), 120, 100);
		
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
		if(this.curRoom == 3 && this.inputQuestion == 1)
		{
			this.curRoom = 3;
			this.inputQuestion = 0;	
			this.questionButton = 0;
			qs.removeText();
		}
		else{
				 cp5.remove("questionOne");
				 cp5.remove("questionTwo");
				 cp5.remove("questionThree");
				 cp5.remove("questionFour");
				 cp5.remove("questionFive");
				 cp5.remove("questionSix");
				 questionButton = 0;
				 q.setQuestionSet(false);
				 this.curRoom = 2;
		}
	}
	
	public int getCurRoom()
	{
		return this.curRoom;
	}
	
	//Question Set Button
	 public void questionOne(){
		qs.display();
		inputQuestion = 1;
	 }
	 public void questionTwo(){
		qs.display();
	 	inputQuestion = 1;
	 }
	 public void questionThree(){
		qs.display();
	 	inputQuestion = 1;
	 }
	 public void questionFour(){
	 	qs.display();
	 	inputQuestion = 1;
	 }
	 public void questionFive(){
	 	qs.display();
	 	inputQuestion = 1;
	 }
	 public void questionSix(){
	 	qs.display();
	 	inputQuestion = 1;
	 }
	public String questionPassword()
	{
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
	
//for objectdrag but it can only drag lighter now
	public void mousePressed() 
	{
		if(overobject) 
		{
			locked = true;
		} 
		else 
		{
			locked = false;
		}
		xOffset = mouseX-lighterx; 
		yOffset = mouseY-lightery; 
	}
	//for objectdrag but it can only drag lighter now
	public void mouseDragged()
	{
		if(locked) 
		{
		    lighterx = mouseX-xOffset; 
		    lightery = mouseY-yOffset; 
		}
	}
	//for objectdrag but it can only drag lighter now
	public void mouseReleased() 
	{
		locked = false;
	}
}