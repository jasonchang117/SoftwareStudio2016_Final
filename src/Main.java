import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import java.io.FileWriter;
import java.io.IOException;

/*
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;*/

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private final static int windowWidth = 960, windowHeight = 540;
	
	
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
		
		
	}


}