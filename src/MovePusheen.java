import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MovePusheen extends JFrame{
	private final static int windowWidth = 400, windowHeight = 540;
	
	public MovePusheen()
	{
		MovePusheenApplet sheep = new MovePusheenApplet();
		sheep.init();
		sheep.start();
		sheep.setFocusable(true);
		
		JFrame window = new JFrame("Move the Sheep");
		window.setContentPane(sheep);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}
}
