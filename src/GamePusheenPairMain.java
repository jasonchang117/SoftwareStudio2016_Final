import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GamePusheenPairMain extends JFrame {
	
	private final static int windowWidth = 1000, windowHeight = 650;
	
	public GamePusheenPairMain()
	{
		GamePusheenPair pusheenpair = new GamePusheenPair();
		pusheenpair.init();
		pusheenpair.start();
		pusheenpair.setFocusable(true);
		
		JFrame window = new JFrame("Color Trap");
		window.setContentPane(pusheenpair);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
	}

}