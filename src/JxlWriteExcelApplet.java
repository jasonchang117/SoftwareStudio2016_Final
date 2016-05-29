import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.util.*;
import java.text.*;
import controlP5.ControlP5;


public class JxlWriteExcelApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	private String input_name, input_ques;
	private Font f = new Font("Consolas", 0, 35);
	TextField textfield_name = new TextField(15);	
	TextField textfield_ques = new TextField(15);
	private PImage back = loadImage("background/questionInput.png");
	private ControlP5 cp5;
    controlP5.Button btn_submit;
	private int state;

	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
	//textfield_name
		textfield_name.setFont(f);
		textfield_name.addActionListener(this);
		textfield_name.setBounds(200,80,300,45);
		this.add(textfield_name);
	//textfield_ques
		textfield_ques.setFont(f);
		textfield_ques.addActionListener(this);
		textfield_ques.setBounds(250,170,300,45);
		this.add(textfield_ques);
		
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("submit").setLabel("Submit").setPosition(500, 250).setSize(150, 50);
		cp5.addButton("more").setLabel("Create another questionnaire>>").setPosition(550, 400).setSize(400, 50);
		
		
		create();
		
	}
	
	public void draw()
	{
		background(200);
		fill(0);
		image(back, 0, 0, 1000, 540);
		textSize(35);
		this.text("Please type in your questionnaire.", 35, 40);
		textSize(25);
		this.text("Your name:", 35, 120);
		this.text("Your Question:", 35, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		input_name = textfield_name.getText();
		input_ques = textfield_ques.getText();
		
		textfield_ques.setText("");   //Clear after Enter.
		textfield_name.setText("");   //Clear after Enter.		
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
			//System.out.println(getText());
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
	
	public void submit()
	{
		this.state = 0;
		
	}
	public void more()
	{
		this.state = 1;
	}
}
	
	