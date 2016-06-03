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

public class JxlWriteExcelApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	private Font f = new Font("Consolas", 0,30);
	JxlWriteExcel jxl;	
	TextField textfield_ques = new TextField();
	TextField textfield_comm = new TextField();
	private PImage bkg = loadImage("background/questionInput.png");
	String encoding = "UTF8";
	public String input_name, input_ques, input_comm;
	public String fileName;
	public int order ;
	
	public JxlWriteExcelApplet(JxlWriteExcel jx){
		this.jxl = jx;
	}
	
	public void setup()
	{
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
	
	//textfield_comment
		textfield_comm.setFont(f);
		textfield_comm.addActionListener(this);
		textfield_comm.setBounds(280,170,600,45);
		this.add(textfield_comm);
	}
	
	public void draw()
	{
		background(200);
		fill(0);
		image(bkg, 0, 0, 1000, 540);
		textSize(35);
		this.text("Please type in your questionnaire.", 35, 40);
		textSize(30);
		this.text("Your Question:", 35, 200);
		textSize(19);
		this.text("¡° Please use _Tab_ to get to next blank.", 250, 400);
		this.text("¡° After filling all the blanks, press _Enter_ and we'll create an Excel file for you.", 250, 430);
		this.text("¡° Our options would be _Always_,_Sometime_, and _Never_.", 250, 460);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		input_ques = textfield_ques.getText();
		input_comm = textfield_comm.getText();

		createOrder();
		fileName = createFileName();
		system(input_name ,input_ques ,input_comm);
		create(fileName ,input_ques);
		
		textfield_ques.setText("");   //Clear after Enter.
		textfield_comm.setText("");
		
	}
	public void setOrder(int o){
		this.order = o;
	}
	public void createOrder()
	{
		fileName = Integer.toString(order);
		System.out.println("order = "+order);
		System.out.println("fileName = "+fileName);
	}
	public String createFileName()//to create fileName 
	{
		fileName = Integer.toString(order);
		System.out.print("filename :  "+fileName);
		return fileName;
	}
	
///////////////////////////////About Excel///////////////////////////////////////////////
	public void system(String user, String QContent, String QComment)
	{
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File("../System.csv").exists();
		try
		{
		//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter("../System.csv", true), ',');
		//Info Setup: Question - answerNum
		// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("File name");
				csvOutput.write("Comment");
				csvOutput.endRecord();
			}							//Create a new row in workbook
			csvOutput.write(fileName); 		//System manager will set a fileName for questionnaire-designer.
			csvOutput.write(QComment);	
			csvOutput.endRecord();
			
			csvOutput.close();	
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 	
	}
	
	public void create(String fileName, String QContent)
	{
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File("../"+fileName+".csv").exists();
		try
		{
		//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter("../"+fileName+".csv", true), ',');
		//Info Setup: Question - answerNum
		// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				//csvOutput.write("Question");
				csvOutput.write("Always");
				csvOutput.write("Sometime");
				csvOutput.write("Never");
				csvOutput.endRecord();
			}//Create a new row in workbook
			else
				csvOutput.endRecord();
			
			csvOutput.close();	
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 	
	}
	
	
}
	
	