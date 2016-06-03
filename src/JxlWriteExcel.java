/****
 * Create an new Excel file.
 * ****/
import javax.swing.JFrame;

public class JxlWriteExcel extends JFrame {
	private final static int windowWidth = 1000, windowHeight = 600;
	MainApplet main;
	private JxlWriteExcelApplet xl;
	
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
		xl.setOrder(o);
	}
	
}


