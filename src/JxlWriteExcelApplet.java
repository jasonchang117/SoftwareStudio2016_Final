import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;

import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JxlWriteExcelApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	private String input;
	private Font f = new Font("Consolas", 0, 25);
	TextField textfield = new TextField(15);	

	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		
		textfield.setFont(f);
		textfield.addActionListener(this);
		textfield.setBounds(40,55,800,450);
		this.add(textfield);
		

		try
		{
			System.out.println("I'm Creating a file.");
			FileWriter writer = new FileWriter("output.csv");
			/*
		    writer.append("DisplayName");
		    writer.append(',');
		    writer.append("Age");
		    writer.append('\n');

		    writer.append("MKYONG");
		    writer.append(',');
		    writer.append("26");
	            writer.append('\n');
				*/
		    //generate whatever data you want
				
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 	
	}
	
	public void draw()
	{
		background(200);
		fill(0);
		textSize(25);
		this.text("Please type in your questionnaire.", 35, 40);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		input = textfield.getText();
        textfield.setText("");   //Clear after Enter.
        

	}
	
	public String getText()
	{
	   	return this.input;
	}
	
}
	
	
	
	
	

	
	