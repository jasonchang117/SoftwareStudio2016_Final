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
		int k = Integer.parseInt(num);
		main.callGame(k);
	}
	
	public void isReply()
	{
		int k = Integer.parseInt(num);
		
		if(k == 1)
			main.question_one_done = 1;
		else if(k == 2)
			main.question_two_done = 1;
		else if(k == 3)
			main.question_three_done = 1;
		else if(k == 4)
			main.question_four_done = 1;
		else if(k == 5)
			main.question_five_done = 1;
	}
	
}

