import de.looksgood.ani.Ani;
import processing.core.PApplet;

public class RapidSortingApplet extends PApplet{
	private final static int width = 400, height = 540;
	
	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
	}
	
	public void draw()
	{
		background(255);
	}
	
	public void keyPressed()
	{
		
	}
}
