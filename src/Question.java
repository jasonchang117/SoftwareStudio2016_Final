import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import processing.core.PApplet;

public class Question implements ActionListener
{
	private PApplet parent;
	private String input;
	TextField textfield = new TextField(15);
	
	public Question(PApplet parent)
	{
		this.parent = parent;
		parent.add(textfield);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
        input = textfield.getText();
        textfield.setText("");
    } 
	
	public void display()
	{
		
	}
}
