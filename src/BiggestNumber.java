import javax.swing.JFrame;

public class BiggestNumber extends JFrame{

	public static void main(String[] args){
	
		JFrame window = new JFrame ("Find the BiggestNumber");
		BiggestNumberApplet applet = new BiggestNumberApplet();
		applet.init();
		applet.start();
		applet.setFocusable(true);
		window.setContentPane(applet);
		window.setSize(400, 540);
		window.setVisible(true);
	}	
}
