import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.util.*;
import java.text.*;


public class JxlWriteExcelApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	private String input;
	private Font f = new Font("Consolas", 0, 25);
	TextField textfield = new TextField(15);	
	private PImage back = loadImage("background/questionInput.png");

	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		
		textfield.setFont(f);
		textfield.addActionListener(this);
		textfield.setBounds(250,55,600,450);
		this.add(textfield);
		
		create();
		
	}
	
	public void draw()
	{
		background(200);
		fill(0);
		image(back, 0, 0, 1000, 540);
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
	
	public void create()
	{
		try
		{
		//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter("../questionnaire.csv", true), ',');
			
		//Info Setup.
			/*csvOutput.write("Name");
			csvOutput.write("Date");
			csvOutput.write("Question");
			csvOutput.write("answerNum");
			csvOutput.endRecord();*/
			
		//Create a new row in workbook
			csvOutput.write("testerA");
			String curTime = getDateTime();
			csvOutput.write(curTime);
			System.out.println(getText());
			csvOutput.write("???????");
			csvOutput.endRecord();
			
			csvOutput.close();			
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 	
		
	}
	
	public void read()
	{
		try {
			
			CsvReader XLfile = new CsvReader("questionnaire.csv");
		
			XLfile.readHeaders();

			while (XLfile.readRecord())
			{
				String InputName = XLfile.get("Name");
				String InputDate = XLfile.get("Date");
				String InputQ = XLfile.get("Question");
				String playerA = XLfile.get("answerNum");
				
				// perform program logic here
				System.out.println(InputName + ":" + InputDate);
			}
	
			XLfile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getDateTime()
	{
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
	
}
	
	
	
	
	

	
	