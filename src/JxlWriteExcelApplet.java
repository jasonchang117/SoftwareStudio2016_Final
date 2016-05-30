import de.looksgood.ani.Ani;
//import jxl.read.biff.File;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

import com.csvreader.CsvWriter;
import java.io.File;    //Collide with import jxl.read.biff.File;

import java.text.SimpleDateFormat;
import java.util.Date;


public class JxlWriteExcelApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	public String input_name, input_ques;
	private Font f = new Font("Consolas", 0, 35);
	TextField textfield_name = new TextField(15);	
	TextField textfield_ques = new TextField(15);
	private PImage bkg = loadImage("background/questionInput.png");
	String encoding = "UTF8";

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
	}
	
	public void draw()
	{
		background(200);
		fill(0);
		image(bkg, 0, 0, 1000, 540);
		textSize(35);
		this.text("Please type in your questionnaire.", 35, 40);
		textSize(25);
		this.text("Your name:", 35, 120);
		this.text("Your Question:", 35, 200);
		textSize(20);
		this.text("¡° Please use _Tab_ to get to next blank.", 35, 280);
		this.text("¡° After filling all the blanks, press _Enter_ and we'll create an Excel file for you.", 35, 300);
		this.text("¡° Our options would be _Always_,_Sometime_, and _Never_.", 35, 330);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		input_name = textfield_name.getText();
		input_ques = textfield_ques.getText();
		
		create(input_name ,input_ques);
		
		textfield_ques.setText("");   //Clear after Enter.
		textfield_name.setText("");   //Clear after Enter.	
		
	}	


///////////////////////////////About Excel///////////////////////////////////////////////	
	public void create(String fileName, String QContent)
	{
		fileName = "../"+fileName+".csv";
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(fileName).exists();
		try
		{
		//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter(fileName, true), ',');
		//Info Setup: Time - Question - answerNum
		// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("Time");
				csvOutput.write("Question");
				csvOutput.write("Always");
				csvOutput.write("Sometime");
				csvOutput.write("Never");
				csvOutput.endRecord();
			}
			//Create a new row in workbook
				String curTime = getDateTime();
				csvOutput.write(curTime);
				csvOutput.write(QContent);   
				csvOutput.endRecord();
				
				csvOutput.close();	
		}
		catch(IOException e)
		{
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
	
	