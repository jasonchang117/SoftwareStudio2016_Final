import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import controlP5.ControlP5;
import controlP5.Label;
import controlP5.Textlabel;
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
	private PImage middleroom, rightroom, leftroom, start, start2, passwordBackground, setQuestion, questionInput;
	private int curRoom;
	private ControlP5 cp5;
	private int catMove = 0, backbutton = 0, startmenu = 1;
	private int questionButton = 0;
	private int questionSet = 0;
	private int inputQuestion = 0;
	private AudioClip cat;
	private LeftRoom leftRoom = new LeftRoom(this);
	private Question q = new Question(this);
	private questionSet qs = new questionSet(this);
	private String password = "520053";
	
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
		setQuestion = loadImage("background/setquestion.png");
		questionInput = loadImage("background/questionInput.png");
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
		
		if(this.curRoom == 0)
		{
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
		else if(this.curRoom == 3)
		{
			image(passwordBackground, 0, 0, 960, 540);
			
			if(this.startmenu == 1)
			{
				cp5.remove("voice");
				cp5.remove("startbutton");
				cp5.remove("questionnaire");
				this.startmenu = 0;
			}
			
		}
		if(q.getQuestionSet()){
			image(setQuestion, 0, 0, 960, 540);	
		}
		if(q.getQuestionSet() && questionButton == 0){
			q.removeText();	
			cp5.addButton("questionOne").setLabel("Question 1").setPosition(70, 100).setSize(200, 70);
			cp5.addButton("questionTwo").setLabel("Question 2").setPosition(680, 100).setSize(200, 70);
			cp5.addButton("questionThree").setLabel("Question 3").setPosition(70, 200).setSize(200, 70);
			cp5.addButton("questionFour").setLabel("Question 4").setPosition(680, 200).setSize(200, 70);
			cp5.addButton("questionFive").setLabel("Question 5").setPosition(70, 300).setSize(200, 70);
			cp5.addButton("questionSix").setLabel("Question 6").setPosition(680, 300).setSize(200, 70);
			questionButton = 1;
		}
		if(inputQuestion == 1){
		
			cp5.remove("questionOne");
			cp5.remove("questionTwo");
			cp5.remove("questionThree");
			cp5.remove("questionFour");
			cp5.remove("questionFive");
			cp5.remove("questionSix");
			image(questionInput, 0, 0, 960, 540);
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
	//Question Set Button
	public void questionOne(){
		qs.display();
		inputQuestion = 1;
		this.questionSet = 1;
	}
	public void questionTwo(){
		qs.display();
		inputQuestion = 1;
		this.questionSet = 2;
	}
	public void questionThree(){
		qs.display();
		inputQuestion = 1;
		this.questionSet = 3;
	}
	public void questionFour(){
		qs.display();
		inputQuestion = 1;
		this.questionSet = 4;
	}
	public void questionFive(){
		qs.display();
		inputQuestion = 1;
		this.questionSet = 5;
	}
	public void questionSix(){
		qs.display();
		inputQuestion = 1;
		this.questionSet = 6;
	}
	public String questionPassword(){
		return this.password;
	}
}