import de.looksgood.ani.Ani;
//import jxl.read.biff.File;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import controlP5.ControlP5;

import java.awt.event.ActionEvent;

public class FillApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	public String input_name, input_ques;
	private Font f = new Font("Consolas", 0, 35);
	TextField textfield_name = new TextField(15);	
	TextField textfield_ques = new TextField(15);
	private PImage bkg = loadImage("background/questionInput.png");
	String encoding = "UTF8";
	private ControlP5 cp5;
	public int option = 0; //1=always, 2=sometime, 3= never.
	public int i_always=0, i_sometime=0, i_never=0;
	public String str_always, str_sometime ,str_never;
	public String questionShow, commentShow, fileName;
	
	public void setup(){
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
		
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("always").setLabel("Always").setPosition(60, 250).setSize(200, 50);
		cp5.addButton("sometime").setLabel("Sometime").setPosition(380, 250).setSize(200, 50);
		cp5.addButton("never").setLabel("Never").setPosition(700, 250).setSize(200,50);
		
		questionShow = chooseQues();
		commentShow = chooseComm();
		fileName = readUser();
	}
	public void draw(){
		background(200);
		fill(0);
		image(bkg, 0, 0, 1000, 540);
		textSize(20);
		this.text("Please type in your answer.", 35, 40);		
		textSize(30);
		this.text(questionShow, 60, 100);	/////////Wait for improve.
		textSize(20);
		this.text(commentShow, 100, 150);/////////Wait for improve.
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
	
/////To decide which option be chosen.
	public void always(){
		option = 1;
		getOption();
	}
	public void sometime(){
		option = 2;
		getOption();
	}
	public void never(){
		option = 3;
		getOption();
	}
	public void getOption(){
		if(option==1){
			i_always = 1;
			i_sometime=0;
			i_never=0;
			
		}
		else if(option==2){
			i_always=0;
			i_sometime=1;
			i_never=0;
		}
		else if(option==3){
			i_always=0;
			i_sometime=0;
			i_never=1;
		}
		str_always = Integer.toString(i_always);
		str_sometime = Integer.toString(i_sometime);
		str_never = Integer.toString(i_never);
		System.out.println(str_always+","+str_sometime+","+str_never);
		update(fileName);
	}
	
///////////////////////////////About Excel///////////////////////////////////////////////	
	public String chooseQues() //Read question from System.csv --> display
	{
		String question = ""; //initial
		try {
			CsvReader XLfile = new CsvReader("../System.csv");		
			XLfile.readHeaders();				
			
			while (XLfile.readRecord())
			{
				question = XLfile.get("Question");
				System.out.println(question);
			}
			XLfile.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return question;
	}
	public String chooseComm() //Read comment from System.csv --> display
	{
		String comment = ""; //initial
		try {
			CsvReader XLfile = new CsvReader("../System.csv");		
			XLfile.readHeaders();				
			
			while (XLfile.readRecord())
			{
				comment = XLfile.get("Comment");
			}
			XLfile.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comment;
	}
	
	
	public String readUser() //Get file name from System.csv--> update user.csv 
	{
		String fileName = "";  
		try {
			CsvReader XLfile = new CsvReader("../System.csv");		
			XLfile.readHeaders();				
			
			while (XLfile.readRecord())
			{
				fileName = XLfile.get("File name");
			}
			XLfile.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("fileName = "+fileName);
		
		return fileName;
	}	
	
	
	public void update(String fileName)
	{
		fileName = "../"+fileName+".csv";
		try
		{
			//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter(fileName, true), ',');
			//Info Setup: Question - answerNum
			csvOutput.write(questionShow);	
			//csvOutput.write("Always");
			csvOutput.write(str_always);
			//csvOutput.write("Sometime");
			csvOutput.write(str_sometime);
			//csvOutput.write("Never");
			csvOutput.write(str_never);
			csvOutput.endRecord();
			
			csvOutput.close();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 	
	}
	
}
