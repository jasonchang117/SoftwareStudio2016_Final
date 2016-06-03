import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import controlP5.ControlP5;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

@SuppressWarnings("serial")
public class RapidSortingApplet extends PApplet{
	private final static int width = 400, height = 540;
	private RapidSorting sort;
	private ControlP5 cp5;
	private int shape = 0, ans, dir;
	private int wrong;
	private int score;
	private int prevShape = 0;
	private float moveX = 0, moveY = 0;
	private int shapeState = 0;
	private boolean isFirst = true;
	private int gameStart = 0;
	Random rand = new Random();
	private Date startTime = new Date();
	private Date now = new Date();
	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private String[] file = 
	{
		"component/heartShape.png",
		"component/starShape.png",
		"component/circleShape.png",
		"component/pusheentime.png",
		"background/rapidsortingBackground.png",
		"background/sorting_gameinfo.png",
	};
	
	public RapidSortingApplet(RapidSorting s)
	{
		this.sort = s;
	}
	
	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		this.textSize(30);
		this.score = 0;
		this.ans = 1;
		this.wrong = 0;
		this.frameRate = 120;
		
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
		cp5.addButton("startbutton").setLabel("START").setPosition(95, 380).setSize(200, 50);
		cp5.addButton("howplay").setLabel("How to Play ?").setPosition(95, 460).setSize(200, 50);
		
	}
	
	public void draw()
	{
		if(this.now.getTime() - this.startTime.getTime() >= 30000)
		{
			this.shapeState = 3;
			this.gameStart = 2;
		}
		background(255);
		
		if(gameStart == -1)
		{
			image(images.get("sorting_gameinfo.png"), 0, 0, 400, 540);
		}
		else if(this.gameStart == 0)
		{
			image(images.get("rapidsortingBackground.png"), 0, 0, 400, 540);
		}
		else if(this.gameStart == 1)
		{
			Calendar cal = Calendar.getInstance();
			now = cal.getTime();
			if(this.shape == 0)
				image(images.get("heartShape.png"), 120+moveX, -190+moveY, 150, 150);
			else if(this.shape == 1)
				image(images.get("starShape.png"), 120+moveX, -190+moveY, 150, 150);
			else
				image(images.get("circleShape.png"), 120+moveX, -190+moveY, 150, 150);
			
			
			if(shapeState == 0)		// fall down
			{
				moveY += 8;
				if(-190+moveY >= 195)
				{
					this.shapeState = 2;
				}
			}
			else if(shapeState == 1)	// slide aside
			{
				if(this.dir == 1)
					moveX += 8;
				else
					moveX -= 8;
				if(80+moveX >= 475 || 80+moveX <= -175)
				{
					this.isFirst = false;
					genShape();
					this.shapeState = 0;
				}
			}
			
			if(this.wrong == 1 && this.isFirst == false)
			{
				this.fill(0, 150, 255);
				textSize(30);
				this.text("Wrong", 150, 220);
				this.fill(255);
			}
			
			textSize(20);
			fill(0);
			text("Your Score: " + this.score, 10, 40);
			text("Time Left : " + (30-((this.now.getTime()-this.startTime.getTime())/1000)), 230, 40);
		}
		else if(this.gameStart == 2)
		{
			textSize(35);
			if(this.score >= 15)
			{
				fill(0, 200, 50);
				text("You Win !", 120, 240);
				sort.getClue();
			}
			else
			{
				fill(200, 0, 50);
				text("You Lose !", 110, 240);
				sort.getClue();
			}
		}
	}
	
	public void keyPressed(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && this.shapeState == 2)
		{
			this.dir = 1;
			this.shapeState = 1;
			if(this.ans == 1 || this.isFirst == true)
			{
				if(this.isFirst == true)
					this.ans = 1;
				this.score += 1;
			}
			else
			{
				this.wrong = 1;
			}
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_LEFT && this.shapeState == 2)
		{
			this.dir = 0;
			this.shapeState = 1;
			if(this.ans == 0 || this.isFirst == true)
			{
				if(this.isFirst == true)
					this.ans = 0;
				this.score += 1;
			}
			else
			{
				this.wrong = 1;
			}
		}
	}
	
	private void genShape()
	{
		this.prevShape = this.shape;
		this.shape = rand.nextInt(3);
		this.moveX = 0;
		this.moveY = 0;
		if(this.shape != this.prevShape && this.ans == 1 && wrong == 0)
			this.ans = 0;
		else if(this.shape != this.prevShape && this.ans == 0 && wrong == 0)
			this.ans = 1;
		else if(this.shape != this.prevShape && this.dir == 0 && wrong == 1)
			this.ans = 1;
		else if(this.shape != this.prevShape && this.dir == 1 && wrong == 1)
			this.ans = 0;
		else if(this.shape == this.prevShape && this.dir == 0 && wrong == 1)
			this.ans = 0;
		else if(this.shape == this.prevShape && this.dir == 1 && wrong == 1)
			this.ans = 1;
		this.wrong = 0;
	}
	
	public void startbutton()
	{
		cp5.remove("startbutton");
		cp5.remove("howplay");
		this.gameStart = 1;
		Calendar cal = Calendar.getInstance();
		this.startTime = cal.getTime();
	}
	
	public void howplay()
	{
		cp5.remove("startbutton");
		cp5.remove("howplay");
		this.gameStart = -1;
		cp5.addButton("back").setLabel("Back").setPosition(320, 450).setSize(50,50);
	}
	
	public void back()
	{
		cp5.addButton("startbutton").setLabel("START").setPosition(95, 380).setSize(200, 50);
		cp5.addButton("howplay").setLabel("How to Play ?").setPosition(95, 460).setSize(200, 50);
		cp5.remove("back");
		this.gameStart = 0;
	}
	
	public int getPass()
	{
		if(this.score >= 15)
			return 1;
		else
			return 0;
	}
}
