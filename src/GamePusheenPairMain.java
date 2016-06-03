import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GamePusheenPairMain extends JFrame {
	private final static int windowWidth = 1000, windowHeight = 650;
	private MainApplet main;
	private GamePusheenPair pusheenpair;
	private int called = 0;
	
	public GamePusheenPairMain(MainApplet m)
	{
		this.main = m;
		pusheenpair = new GamePusheenPair(this);
		pusheenpair.init();
		pusheenpair.start();
		pusheenpair.setFocusable(true);
		
		JFrame window = new JFrame("PusheenPair");
		window.setContentPane(pusheenpair);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}

	public void getClue(int result)
	{
		if(result == 1 && this.called == 0)
		{
			main.clue3 = 2;
			main.prevRoom = main.curRoom;
			main.curRoom = 6;
		}
		else if(result == 0 && this.called == 0)
		{
			main.clue3 = 1;
			main.prevRoom = main.curRoom;
			main.curRoom = 6;
		}
		this.called = 1;
	}
}