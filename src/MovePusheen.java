import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MovePusheen extends JFrame{
	private final static int windowWidth = 400, windowHeight = 600;
	MovePusheenApplet pusheen;
	MainApplet main;
	MiddleRoom middleroom;
	
	public MovePusheen(MainApplet applet, MiddleRoom middle)
	{
		this.main = applet;
		this.middleroom = middle;
		this.pusheen = new MovePusheenApplet(this);
		pusheen.init();
		pusheen.start();
		pusheen.setFocusable(true);
		
		JFrame window = new JFrame("Move the Sheep");
		window.setContentPane(pusheen);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}
	
	public void getClue()
	{
		if(middleroom.middlebackground==0)
		{
			middleroom.middlebackground = 1;		//mid+lamp
		}
		else if(middleroom.middlebackground==2)
		{
			middleroom.middlebackground = 3;		//mid+lamp+candle
		}
	}
}
