
public class RightRoom {
	private int tape;		// 0->not visible, 1->visible
	private int pusheenBottle;
	private int securitybox;

	public RightRoom() 
	{
		tape = 1;
	}
	

	public int tape() { return this.tape; }
	
	public void tape_vanish() { this.tape = 0; }
	
	public void tape_appear() { this.tape = 1; }
}
