/****
 * Create an new Excel file.
 * ****/
import javax.swing.JFrame;

public class Fill extends JFrame {
	private final static int windowWidth = 1000, windowHeight = 600;
	private String num; 
	private MainApplet main;
	
	public Fill(MainApplet m, String str) {
		this.main = m;
		this.num = str;
		FillApplet xl = new FillApplet(this, num);
		xl.init();
		xl.start();
		xl.setFocusable(true);
		
		JFrame window = new JFrame("Fill Questionnaire.");
		window.setContentPane(xl);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
	}
	
	public void callGame()
	{
		main.callPusheenPair();
	}
	
}

