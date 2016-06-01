import java.util.HashMap;
import java.util.Random;

import controlP5.ControlP5;
import controlP5.Label;
import controlP5.Textlabel;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class GameColorTrap extends PApplet {
	private ControlP5 cp5, cp6, cp7;
	private Random ran ;
	private int width = 500, height = 600;
	private int game = 0, howPlay = 0, initial = 1;
	private int correct = 1;
	private int colorblock_X0 = 50, colorblock_X1 = 190, colorblock_X2 = 330;
	private int wrongBlock;
	private int wrongRandomNum = 0;
	private int colorNum0,colorNum1,colorNum2;
	private int score = 0;
	private int addOneTime = 1;
	private int calculate = 0, time = 0;
	private int limitedTime = 60;  // Game limited time
	private int gameWinScore = 15; // Win Score
	private boolean gameWin = false;
	private boolean gameLose = false;
	private int pusheenWidth = 100, pusheenHeight = 60;
	private int pusheenX = width-pusheenWidth, pusheenY = height - pusheenHeight;
	private int pusheenMove = 1;
	private GameColorTrapMain gameColorTrapMain;
	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private String[] file = {
			"background/colorbackground.png",
			"background/colorhowplay.png",
			"pusheenpair/win.png",
			"pusheenpair/lose.png"
	};
	private String[] color = {
			"BLACK",
			"BLUE",
			"BROWN",
			"GRAY",
			"GREEN",
			"ORENGE",
			"PINK",
			"PURPLE",
			"RED",
			"YELLOW"
	};
	private String[] colorImage = {
			"colorblock/black.png",
			"colorblock/blue.png",
			"colorblock/brown.png",
			"colorblock/gray.png",
			"colorblock/green.png",
			"colorblock/orenge.png",
			"colorblock/pink.png",
			"colorblock/purple.png",
			"colorblock/red.png",
			"colorblock/yellow.png"
	};
	
	public GameColorTrap(GameColorTrapMain main)
	{
		this.gameColorTrapMain = main;
	}
	
	public void setup()		
	{	
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		
		String []temp = new String[10];
		for(int i=0;i<file.length;i++)
		{
			PImage image = loadImage(this.file[i]);
			temp = this.file[i].split("/");
			images.put(temp[1], image);
		}
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("startbutton").setLabel("START").setPosition(150, 350).setSize(200, 50);
		cp5.addButton("howplay").setLabel("How to play ?").setPosition(150, 450).setSize(200, 50);
	    
		cp6 = new ControlP5(this);
		PFont f = createFont("Consolas",30);
		cp6.setFont(f);
		
		cp7 = new ControlP5(this);
		PFont k = createFont("Concolas",30);
		cp7.setFont(k);
		
	    
	}
	public void draw()
	{
		background(255);
		
		
		if(this.initial == 1){
			image(images.get("colorbackground.png"), 0, 0, width, height);
			image(images.get("colorbackground.png"), 0, 0, width, height);
			image(images.get("colorbackground.png"), 0, 0, width, height);
			
		}
		else{
			cp5.remove("startbutton");
			cp5.remove("howplay");
		}
		
		if(this.game == 1){
			calculateTime();
			if(addOneTime == 1){
				cp7.addLabel("Score: "+this.score).setColor(color(0));
				addOneTime = 0;
			}
			if(correct == 1){
				generateColor();
				setWrongBlock();
				addColorLabel();
				correct = 0;
			}
			
			image(loadImage(colorImage[colorNum0]),colorblock_X0,180,120,120);
			image(loadImage(colorImage[colorNum1]),colorblock_X1,180,120,120);
			image(loadImage(colorImage[colorNum2]),colorblock_X2,180,120,120);
			if(pusheenMove == 1)
				image(loadImage("component/pusheentime.png"),pusheenX-5,pusheenY+5,pusheenWidth,pusheenHeight);
			else 
				image(loadImage("component/pusheentime.png"),pusheenX+5,pusheenY-5,pusheenWidth,pusheenHeight);
			
			
		}
		if(this.howPlay == 1){
			image(images.get("colorhowplay.png"), 0, 0, width, height);
		}
		if(this.gameWin){
			image(loadImage(file[2]),0,0,width,height);
		}
		if(this.gameLose){
			image(loadImage(file[3]),0,0,width,height);			
		}
	}
	public void calculateTime(){
		if(calculate < 15){
			calculate ++;
		}
		if(calculate == 15){
			calculate = 0;
			time ++;
			pusheenMove *= -1;
			pusheenX = pusheenX - width/limitedTime;
		}
		if(time == limitedTime){  // Endgame
			this.initial = 0;
			this.howPlay = 0;
			this.game = 0;
			this.howPlay = 0;
			cp7.remove("Score: "+this.score);
			removeColorLabel();
			if(this.score >= gameWinScore)
			{
				gameWin = true;
				this.gameColorTrapMain.getClue();
			}
			else
			{
				gameLose = true;
				this.gameColorTrapMain.getClue();
			}
			//draw();
		}
	}
	public void generateColor(){
		ran = new Random();
		for(int i = 0; i < 3; i++){
			if(i == 0)
				colorNum0 = ran.nextInt(color.length);
			else if(i == 1){
				colorNum1 = ran.nextInt(color.length);
				if(colorNum1 == colorNum0)
					i = i - 1;
			}
			else{
				colorNum2 = ran.nextInt(color.length);
				if((colorNum2 == colorNum0) || (colorNum2 == colorNum1))
					i = i - 1;
			}
		}
	}
	
	public void setWrongBlock(){
		ran = new Random();
		wrongBlock = ran.nextInt(3);
	}
	
	public void addColorLabel(){
		for(int i = 0; i < 3; i++){
			if(i != wrongBlock){
				 if(i == 0){
					 cp6.addLabel(color[colorNum0]).setPosition(colorblock_X0+60-color[colorNum0].length()*9,225);
				 }
				 else if(i == 1){
					 cp6.addLabel(color[colorNum1]).setPosition(colorblock_X1+60-color[colorNum1].length()*9,225);
				 }
				 else{
					 cp6.addLabel(color[colorNum2]).setPosition(colorblock_X2+60-color[colorNum2].length()*9,225);
				 }
			}
		}
			ran = new Random();
			for(int j = 0; j < 1; j++){
				wrongRandomNum = ran.nextInt(color.length);
				if(wrongBlock == 0){
					if((wrongRandomNum == colorNum0) || (wrongRandomNum == colorNum1) || (wrongRandomNum == colorNum2))
						j = j - 1;
				}
				else if(wrongBlock == 1){
					if((wrongRandomNum == colorNum0) || (wrongRandomNum == colorNum1) || (wrongRandomNum == colorNum2))
						j = j - 1;
				}
				else{
					if((wrongRandomNum == colorNum0) || (wrongRandomNum == colorNum1) || (wrongRandomNum == colorNum2))
						j = j - 1;
				}
			}
			if(wrongBlock == 0)
				 cp6.addLabel(color[wrongRandomNum]).setPosition(colorblock_X0+60-color[wrongRandomNum].length()*9,225);
			else if(wrongBlock == 1)
				 cp6.addLabel(color[wrongRandomNum]).setPosition(colorblock_X1+60-color[wrongRandomNum].length()*9,225);
			else
				 cp6.addLabel(color[wrongRandomNum]).setPosition(colorblock_X2+60-color[wrongRandomNum].length()*9,225);
			
		this.correct = 0;
		
	}
	public void removeColorLabel(){
		for(int i = 0; i < 3; i++){
			if(i != wrongBlock){
				 if(i == 0)
					 cp6.remove(color[colorNum0]);
				 else if(i == 1)
					 cp6.remove(color[colorNum1]);
				 else
					 cp6.remove(color[colorNum2]);
			}
			else{
				cp6.remove(color[wrongRandomNum]);
			}
		}
	}
	
	public void addScore(){
		this.score = this.score + 1;
	}
	
	public void mousePressed()
	{
		if(this.game == 1){
			if(wrongBlock == 0){
				if(mouseX >= colorblock_X0 && mouseX <= colorblock_X0+120 && mouseY >= 180 && mouseY < 300){
					game = 1;
					removeColorLabel();
					cp7.remove("Score: "+this.score);
					addScore();
					cp7.addLabel("Score: "+this.score).setColor(color(0));
					generateColor();
					setWrongBlock();
					addColorLabel();
				}
			}
			else if(wrongBlock == 1){
				if(mouseX >= colorblock_X1 && mouseX <= colorblock_X1+120 && mouseY >= 180 && mouseY < 300){
					game = 1;
					removeColorLabel();
					cp7.remove("Score: "+this.score);
					addScore();
					cp7.addLabel("Score: "+this.score).setColor(color(0));
					generateColor();
					setWrongBlock();
					addColorLabel();
				}
			}
			else{
				if(mouseX >= colorblock_X2 && mouseX <= colorblock_X2+120 && mouseY >= 180 && mouseY < 300){
					game = 1;
					removeColorLabel();
					cp7.remove("Score: "+this.score);
					addScore();
					cp7.addLabel("Score: "+this.score).setColor(color(0));
					generateColor();
					setWrongBlock();
					addColorLabel();
				}
			}
		}
	}
	
	public void startbutton(){
		this.initial = 0;
		this.howPlay = 0;
		this.game = 1;
		
	}
	public void howplay(){
		this.initial = 0;
		this.howPlay = 1;
		cp5.addButton("buttonBack").setLabel("Back").setPosition(450, 550).setSize(50,50);
	}
	public void buttonBack(){
		this.initial = 1;
		this.howPlay = 0;
		cp5.addButton("startbutton").setLabel("START").setPosition(150, 350).setSize(200, 50);
		cp5.addButton("howplay").setLabel("How to play ?").setPosition(150, 450).setSize(200, 50);
		cp5.remove("buttonBack");
	}
	
	public int getScore()
	{
		return this.score;
	}
}
