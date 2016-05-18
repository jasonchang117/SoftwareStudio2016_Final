import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import processing.event.KeyEvent;

import java.awt.Font;

public class Question implements ActionListener
{
	private MainApplet parent;
	private String input;
	private int text = 0;
	private boolean questionSet = false;
	Font f = new Font("Consolas", 0, 25);
	TextField textfield = new TextField(15);
	
	public Question(MainApplet parent)
	{
		this.parent = parent;
		textfield.setFont(f);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
        input = textfield.getText();
        textfield.setText("");
        if(input.equals(parent.questionPassword())){
        	this.questionSet = true;
        }
    } 
	 
	public void display()
	{
		if(parent.getCurRoom() == 3 && text == 0)
		{
			textfield.addActionListener(this);
			textfield.setBounds(340,180,250,30);
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
	public boolean getQuestionSet(){
		return this.questionSet;
	}
	public void removeText(){
		parent.remove(textfield);
	} 
}
