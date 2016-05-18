import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame implements JxlWriteExcel {
	
	private final static int windowWidth = 960, windowHeight = 540;
	private static String question = new String("12345678");
	
	public static void main(String [] args)
	{
		MainApplet applet = new MainApplet();
		applet.init();
		applet.start();
		applet.setFocusable(true);
		
		JFrame window = new JFrame("Pusheen-Escape the Room & Made Questionnaire.");
		window.setContentPane(applet);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
		/**Waiting for Turtle's class.**/
		/*Text textq = new TextQ();
		question = textq.getText();
		JxlWriteExcel(question);
	*/
	}

}