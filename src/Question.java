import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import processing.core.PApplet;

public class Question implements ActionListener
{
	private MainApplet parent;
	private String input;
	private int text = 0;
	TextField textfield = new TextField(15);
	
	public Question(MainApplet parent)
	{
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent event) 
	{
        input = textfield.getText();
        textfield.setText("");
    } 
	
	public void display()
	{
		if(parent.getCurRoom() == 3 && text == 0)
		{
			textfield.setBounds(200,300,250,30);
			parent.add(textfield);
			this.text = 1;
		}
		else if(parent.getCurRoom() != 3)
		{
			parent.remove(textfield);
			this.text = 0;
		}
	}
	
	public String getInput()
	{
		return this.input;
	}
}
