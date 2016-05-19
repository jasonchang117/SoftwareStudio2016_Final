
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
	

	public int hammer() { return this.hammer; }
	public int pusheenBack() { return this.pusheenBack; }
	public int pusheenFront() { return this.pusheenFront; }
	public int pusheenLeft() { return this.pusheenLeft; }
	public int pusheenCut() { return this.pusheenCut; }
	public int pusheenWithoutHammer() { return this.pusheenWithoutHammer; }
	public int pusheenBeKnif() { return this.pusheenBeKnif; }
	
	public void hammer_vanish() { this.hammer = 0; }
	public void pusheenBack_vanish() {this.pusheenBack = 0; }
	public void pusheenFront_vanish() { this.pusheenFront = 0; }
	public void pusheenLeft_vanish() { this.pusheenLeft = 0; }
	public void pusheenCut_vanish() { this.pusheenCut = 0; }
	public void pusheenWithoutHammer_vanish() { this.pusheenWithoutHammer = 0; }
	public void pusheenBeKnif_vanish() { this.pusheenBeKnif = 0; }
	
	public void hammer_appear() { this.hammer = 1; }
	public void pusheenBack_appear() {this.pusheenBack = 1; }
	public void pusheenFront_appear() { this.pusheenFront = 1; }
	public void pusheenLeft_appear() { this.pusheenLeft = 1; }
	public void pusheenCut_appear() { this.pusheenCut = 1; }
	public void pusheenWithoutHammer_appear() { this.pusheenWithoutHammer = 1; }
	public void pusheenBeKnif_appear() { this.pusheenBeKnif = 1; }
	
}
