import javax.swing.JFrame;

public class BiggestNumber extends JFrame{
	BiggestNumberApplet applet;
	MainApplet main;
	
	public BiggestNumber(MainApplet m)
	{
		this.main = m;
		JFrame window = new JFrame ("Find the BiggestNumber");
		applet = new BiggestNumberApplet(this);
		applet.init();
		applet.start();
		applet.setFocusable(true);
		window.setContentPane(applet);
		window.setSize(500, 580);
		window.setVisible(true);
	}	
	
	public void getPass()
	{
		if(applet.getPass() == 1)
			main.success = 1;
		else 
			main.success = 0;
	}
}
