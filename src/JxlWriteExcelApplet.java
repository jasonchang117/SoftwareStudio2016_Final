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

import com.csvreader.CsvWriter;

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
			//Blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter("../output.csv", true), ',');
			
			//test info
			csvOutput.write("DisplayName");
			csvOutput.write("Age");
			csvOutput.endRecord();

			csvOutput.write("MKYONG");
			csvOutput.write("26");
			csvOutput.endRecord();
				
		    //generate whatever data you want
				
			csvOutput.close();
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
	
	
	
	
	

	
	