import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameColorTrapMain extends JFrame {
	private final static int windowWidth = 520, windowHeight = 645;
	private MainApplet main;
	private GameColorTrap colorTrap;
	
	public GameColorTrapMain(MainApplet m)
	{
		this.main = m;
		colorTrap = new GameColorTrap(this);
		colorTrap.init();
		colorTrap.start();
		colorTrap.setFocusable(true);
		
		JFrame window = new JFrame("Color Trap");
		window.setContentPane(colorTrap);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
	}
	
	public void getClue()
	{
		if(colorTrap.getScore() >= 15)
		{
			main.clue1 = 2;
			main.curRoom = 4;
		}
		else
		{
			main.clue1 = 1;
			main.curRoom = 4;
		}
	}
}