import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.awt.event.ActionEvent;

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
	private int state = 2; // to design "close window" for "more"(0), or "send info" for "submit"(1)

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
		
		//if(state == 0) //more
			create();
		//else if(state == 1) //submit
			//close();
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		input_name = textfield_name.getText();
		input_ques = textfield_ques.getText();
		
		textfield_ques.setText("");   //Clear after Enter.
		textfield_name.setText("");   //Clear after Enter.		
	}	
	
	public void submit() //send info
	{
		this.state = 0;
	}
	public void more()  // close window
	{
		this.state = 1;
	}
	
	/*public void actionClose(ActionEvent e)
	{
		getAppletContext().showDocument(appletCloseURL);
	}*/
	
	public void create()
	{
		try
		{
		//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter("../questionnaire1.csv", true), ',');
			
		//Info Setup: Name- Time - Question - answerNum
			
		//Create a new row in workbook
			csvOutput.write("testerA");
			String curTime = getDateTime();
			csvOutput.write(curTime);
			//System.out.println(getText());
			csvOutput.write("???????");   /*********BUG*******/
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
	
	