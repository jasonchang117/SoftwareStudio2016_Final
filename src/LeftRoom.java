
import processing.core.PApplet;
import processing.core.PImage;


public class LeftRoom
{
	private PApplet parent;
	private int hammer;		// 0->not visible, 1->visible
	private int pusheenBack,pusheenFront,pusheenLeft;
	private int pusheenCut,pusheenWithoutHammer;
	private int pusheenBeKnif;

	public LeftRoom(MainApplet parent) 
	{
		this.parent = parent;
		hammer = 0;
		pusheenBack = 1;
		pusheenFront = 1;
		pusheenLeft = 1;
		pusheenCut = 0;
		pusheenWithoutHammer = 0;
		pusheenBeKnif = 0;
		
	}
	
	
	
}
