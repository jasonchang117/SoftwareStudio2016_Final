
public class MiddleRoom {
	
	private int knif;		// 0->not visible, 1->visible
	private int pusheenBottle;
	private int securitybox;

	public MiddleRoom() 
	{
		pusheenBottle = 1;
		securitybox = 0;
		knif = 1;
	}
	

	public int knif() { return this.knif; }
	public int pusheenBottle() { return this.pusheenBottle; }
	public int securitybox(){return this.securitybox; }
	
	
	public void knif_vanish() { this.knif = 0; }
	public void pusheenBottle_vanish() {this.pusheenBottle = 0; }
	public void securitybox_vanish(){	this.securitybox = 0;}

	
	public void knif_appear() { this.knif = 1; }
	public void pusheenBottle_appear() {this.pusheenBottle = 1; }
	public void securitybox_appear(){this.securitybox = 1;}
	
}
