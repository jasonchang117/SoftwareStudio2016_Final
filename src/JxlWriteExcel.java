/****
 * Create an new Excel file.
 * ****/
import javax.swing.JFrame;

public class JxlWriteExcel extends JFrame {
	private final static int windowWidth = 1000, windowHeight = 600;
	MainApplet main;
	private JxlWriteExcelApplet xl;
	private int order;
	
	public JxlWriteExcel(MainApplet m) {	
		this.main = m;
		xl = new JxlWriteExcelApplet(this);
		xl.init();
		xl.start();
		xl.setFocusable(true);
		
		JFrame window = new JFrame("Create your excel file.");
		window.setContentPane(xl);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
	}
	public void setOrder(int o){
		this.order = o;
		xl.setOrder(order);
	}
	
	public void setQuestionSeted()
	{
		if(this.order == 1)
			main.questionOneSet = 1;
		else if(this.order == 2)
			main.questionTwoSet = 1;
		else if(this.order == 3)
			main.questionThreeSet = 1;
		else if(this.order == 4)
			main.questionFourSet = 1;
		else if(this.order == 5)
			main.questionFiveSet = 1;
	}
}


