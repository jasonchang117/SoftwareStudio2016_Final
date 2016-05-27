import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Random;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class RapidSortingApplet extends PApplet{
	private final static int width = 400, height = 540;
	private int shape = 0, ans, dir;
	private int wrong;
	private int score;
	private int prevShape = 0;
	private float moveX = 0, moveY = 0;
	private int shapeState = 0;
	private float timeLimit = 300, time = 0;
	Random rand = new Random();
	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private String[] file = 
	{
		"component/heartShape.png",
		"component/starShape.png",
		"component/circleShape.png",
		"component/pusheentime.png",
	};
	
	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		//genShape();
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
	}
	
	public void draw()
	{
		background(255);
		
		if(time == timeLimit)
		{	shapeState = 3; 
			//System.out.println("finish");
		}
		else 
			time += 0.1;
		
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
				genShape();
				this.shapeState = 0;
			}
		}
		
		if(this.wrong == 1)
		{
			this.fill(0, 150, 255);
			textSize(30);
			this.text("Wrong", 150, 220);
			this.fill(255);
		}
		
		image(images.get("pusheentime.png"), 400-this.time*2, 460, 100, 50);
		
		textSize(20);
		fill(0);
		text("Your Score: " + this.score, 10, 40);
	}
	
	public void keyPressed(KeyEvent arg0)
	{
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && this.shapeState == 2)
		{
			this.dir = 1;
			this.shapeState = 1;
			if(this.ans == 1)
			{
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
			if(this.ans == 0)
			{
				this.score += 1;
			}
			else
			{
				this.wrong = 1;
			}
		}
	}
	
	public void genShape()
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
}