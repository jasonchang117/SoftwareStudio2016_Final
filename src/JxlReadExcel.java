import javax.swing.JFrame;

public class JxlReadExcel {
	private final static int windowWidth = 1000, windowHeight = 600;
	public JxlReadExcel() {
		
		JxlReadExcelApplet xl = new JxlReadExcelApplet();
		xl.init();
		xl.start();
		xl.setFocusable(true);
		
		JFrame window = new JFrame("Choose which file do you want to see.");
		window.setContentPane(xl);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}

}
