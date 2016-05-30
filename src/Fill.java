/****
 * Create an new Excel file.
 * ****/
import javax.swing.JFrame;

public class Fill extends JFrame {
	private final static int windowWidth = 600, windowHeight = 600;
	
	public Fill() {		
		FillApplet xl = new FillApplet();
		xl.init();
		xl.start();
		xl.setFocusable(true);
		
		JFrame window = new JFrame("Fill Questionnaire.");
		window.setContentPane(xl);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
	}

	
}

