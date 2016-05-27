import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RapidSorting extends JFrame{
	private final static int windowWidth = 400, windowHeight = 540;
	
	public RapidSorting()
	{
		RapidSortingApplet sort = new RapidSortingApplet();
		sort.init();
		sort.start();
		sort.setFocusable(true);
		
		JFrame window = new JFrame("Rapid Sorting");
		window.setContentPane(sort);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}
}
