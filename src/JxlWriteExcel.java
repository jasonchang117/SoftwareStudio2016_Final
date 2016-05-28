/****
 * Create an new Excel file.
 * ****/
import javax.swing.JFrame;

public class JxlWriteExcel extends JFrame {
	private final static int windowWidth = 600, windowHeight = 600;
	
	public JxlWriteExcel() {		
		JxlWriteExcelApplet xl = new JxlWriteExcelApplet();
		xl.init();
		xl.start();
		xl.setFocusable(true);
		
		JFrame window = new JFrame("Create your excel file.");
		window.setContentPane(xl);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
		
	}

	
}


