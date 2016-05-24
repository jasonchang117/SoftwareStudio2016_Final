
public class MiddleRoom {
	
	private int knif, knifX, knifY;						// 0->not visible, 1->visible
	private int pusheenBottle, pusheenBottleX, pusheenBottleY;
	private int securitybox, securityboxX, securityboxY;
	private int lighter, lighterX, lighterY;

	public MiddleRoom() 
	{
		pusheenBottle = 1;
		securitybox = 0;
		knif = 1;
		lighter = 1;
	}
	

	public int knif() { return this.knif; }
	public int pusheenBottle() { return this.pusheenBottle; }
	public int securitybox(){ return this.securitybox; }
	public int lighter() { return this.lighter; }
	
	public void knif_vanish() { this.knif = 0; }
	public void pusheenBottle_vanish() {this.pusheenBottle = 0; }
	public void securitybox_vanish(){	this.securitybox = 0;}
	public void lighter_vanish() { this.lighter = 0; }
	
	public void knif_appear() { this.knif = 1; }
	public void pusheenBottle_appear() {this.pusheenBottle = 1; }
	public void securitybox_appear(){this.securitybox = 1;}
	public void lighter_appear() { this.lighter = 1; }
	
	public int getComX(String str)
	{
		if(str == "pusheenBottle")
			return this.pusheenBottleX;
		else if(str == "securitybox")
			return this.securityboxX;
		else if(str == "knif")
			return this.knifX;
		else if(str == "lighter")
			return this.lighterX;
		else 
			return 0;
	}
	
	public int getComY(String str)
	{

		if(str == "pusheenBottle")
			return this.pusheenBottleY;
		else if(str == "securitybox")
			return this.securityboxY;
		else if(str == "knif")
			return this.knifY;
		else if(str == "lighter")
			return this.lighterY;
		else 
			return 0;
	}
}
