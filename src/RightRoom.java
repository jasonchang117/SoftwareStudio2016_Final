import javax.swing.JFrame;

public class RightRoom {
	private int tape, tapeX, tapeY;	
	//private int fillingbottle;
	//private int fillingbottle1;
	//private int fillingbottle2;
	//private int fillingbottle3;
	//private int fillingbottle4;
	//private int fillingbottle5;
	//private int fillingbottle6;
	public int animate;// 0->not visible, 1->visible
	public int animateNum;
	public RightRoom() 
	{
		tape = 0;
		tapeX = 518;
		tapeY = 502;
		animate = 0;
		animateNum = 0;
	}

	public int tape() { return this.tape; }
	
	
	public void tape_vanish() { this.tape = 0; }
	
	public void tape_appear() { this.tape = 1; }
	
	public int getComX(String str)
	{
		if(str == "tape")
			return this.tapeX;
		else 
			return 0;
	}
	
	public int getComY(String str)
	{
		if(str == "tape")
			return this.tapeY;
		else 
			return 0;
	}
	
	public void setPostion(int x, int y, String str)
	{
		if(str == "tape"){
			this.tapeX = x; this.tapeY = y;
		}
	}
	
	public void success()  //Play media
	{
		JFrame media = new JFrame();
		media.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		media.setSize(300,  300);
		media.setVisible(true);	
	}
	
	

}
