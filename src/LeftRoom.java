
import processing.core.PApplet;
import processing.core.PImage;


public class LeftRoom extends PApplet
{
	private PApplet parent;
	private PImage hammer,knif;
	private PImage pusheenBack,pusheenFront,pusheenLeft;
	private PImage pusheenCut,pusheenWithoutHammer;
	private PImage pusheenBeKnif;
	public LeftRoom(PApplet parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		
	}
		
	public void Setup(){
		hammer = loadImage("component/hammer.png");
		pusheenBack = loadImage("component/pusheenBack.png");
		pusheenFront = loadImage("component/pusheenFront.png");
		pusheenLeft = loadImage("component/pusheenLeft.png");
		knif = loadImage("component/knif.png");
		pusheenCut = loadImage("component/pusheen_cut");
		pusheenWithoutHammer = loadImage("component/pusheen_hammer");
		pusheenBeKnif = loadImage("component/beknif_pusheen");
	}

	public void drawknif()
	{
		image(knif, 50, 50);
	}
	
}
