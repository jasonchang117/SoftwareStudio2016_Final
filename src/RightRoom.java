
public class RightRoom {
	private int tape, tapeX, tapeY;		// 0->not visible, 1->visible
	private int pusheenBottle, pusheenBottleX, pusheenBottleY;
	private int securitybox, securityboxX, securityboxY;

	public RightRoom() 
	{
		tape = 1;
		pusheenBottle = 0;
		securitybox = 0;
	}
	

	public int tape() { return this.tape; }
	public int pusheenBottle() { return this.pusheenBottle; }
	public int securitybox() { return this.securitybox; }
	
	public void tape_vanish() { this.tape = 0; }
	public void pusheenBottle_vanish() { this.pusheenBottle = 0; }
	public void securitybox_vanish() { this.securitybox = 0; }
	
	public void tape_appear() { this.tape = 1; }
	public void pusheenBottle_appear() { this.pusheenBottle = 1; }
	public void security_appear() { this.securitybox = 1; }
	
	public int getComX(String str)
	{
		if(str == "tape")
			return this.tapeX;
		else if(str == "pusheenBottle")
			return this.pusheenBottleX;
		else if(str == "securitybox")
			return this.securityboxX;
		else 
			return 0;
	}
	
	public int getComY(String str)
	{
		if(str == "tape")
			return this.tapeY;
		else if(str == "pusheenBottle")
			return this.pusheenBottleY;
		else if(str == "securitybox")
			return this.securityboxY;
		else 
			return 0;
	}
}
