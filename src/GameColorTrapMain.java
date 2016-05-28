import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameColorTrapMain extends JFrame {
	
	private final static int windowWidth = 520, windowHeight = 645;
	
	public GameColorTrapMain()
	{
		GameColorTrap colorTrap = new GameColorTrap();
		colorTrap.init();
		colorTrap.start();
		colorTrap.setFocusable(true);
		
		JFrame window = new JFrame("Color Trap");
		window.setContentPane(colorTrap);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
		
	}

}