import java.util.HashMap;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class MovePusheenApplet extends PApplet{
	private final static int width = 400, height = 540;
	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private int wrong = 0, pass = 0, moving = 0;
	private float moveX = 110, moveY = 440;
	private String[] file = 
	{
		"component/same_pusheen.png",
		"component/different_pusheen.png",	
	};
	
	
	public void setup()
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
		
	}
	
	public void draw()
	{
		background(200);
		
		fill(0);
		textSize(25);
		this.text("Find the different Pusheen", 35, 40);
		
		if(wrong == 1)
		{
			fill(255, 0, 0);
			this.text("You're wrong !", 100, 240);
			fill(0);
		}
		
		image(images.get("different_pusheen.png"), 65, 400, 90, 90);
		image(images.get("same_pusheen.png"), 50, 80, 120, 120);
		image(images.get("same_pusheen.png"), 50, 230, 120, 120);
		image(images.get("same_pusheen.png"), 210, 80, 120, 120);
		image(images.get("same_pusheen.png"), 210, 230, 120, 120);
		image(images.get("same_pusheen.png"), 210, 380, 120, 120);
		image(images.get("same_pusheen.png"), moveX-60, moveY-60, 120, 120);
		
		if(pass == 1)
		{
			fill(0, 200, 0);
			this.text("You're Right !", 115, 240);
		}
	}
	
	public void mouseDragged()
	{
		if(mouseX >= moveX-40 && mouseX <= moveX+40 && mouseY >= moveY-40 && mouseY <= moveY+40)   // 110 440
		{
			this.moving = 1;
		}
		if(moving == 1)
		{
			this.moveX = mouseX;
			this.moveY = mouseY;
		}
	}
	
	public void mouseClicked()
	{
		if(moveX >= 66 && moveX <= 157 && moveY >= 397 && moveY <= 488)	
		{
			if(this.wrong == 0)
				this.wrong = 1;
			else
				this.wrong = 0;
		}
		else
		{
			if(mouseX >= 70 && mouseX <= 147 && mouseY >= 411 && mouseY <= 483)
			{
				this.pass = 1;
			}
		}
	}
	
	public void mouseReleased()
	{
		this.moving = 0;
	}
	
	public int getPass()
	{
		return this.pass;
	}
}
