import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RapidSorting extends JFrame{
	private final static int windowWidth = 400, windowHeight = 600;
	private int called = 0;
	RapidSortingApplet sort;
	MainApplet main;
	
	public RapidSorting(MainApplet m)
	{
		this.main = m;
		sort = new RapidSortingApplet(this);
		sort.init();
		sort.start();
		sort.setFocusable(true);
		
		JFrame window = new JFrame("Rapid Sorting");
		window.setContentPane(sort);
		window.setSize(windowWidth, windowHeight);
		window.setVisible(true);
	}
	
	public void getClue()
	{
		if(sort.getPass() == 1 && this.called == 0)
		{
			main.clue2 = 2;
			main.prevRoom = main.curRoom;
			main.curRoom = 5;
		}
		else if(sort.getPass() == 0 && this.called == 0)
		{
			main.clue2 = 1;
			main.prevRoom = main.curRoom;
			main.curRoom = 5;
		}
		this.called = 1;
	}
}
