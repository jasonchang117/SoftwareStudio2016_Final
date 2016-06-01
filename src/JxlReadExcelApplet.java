import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

import com.csvreader.CsvReader;

public class JxlReadExcelApplet extends PApplet implements ActionListener{
	private final static int width = 1000, height = 540;
	public String input_name, input_ques;
	private Font f = new Font("Consolas", 0, 35);
	TextField textfield_name = new TextField(15);	
	TextField textfield_ques = new TextField(15);
	private PImage bkg = loadImage("background/questionInput.png");
	String encoding = "UTF8";
	public String result="";
	public boolean alreadyExists = true;

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
	}
	public void draw()
	{
		if (!alreadyExists){
			background(200);
			fill(0);
			image(bkg, 0, 0, 1000, 540);
			textSize(25);
			this.text("Your name:", 35, 120);
			textSize(35);
			this.text(result, 100, 200);
			
		}else{
			background(200);
			fill(0);
			image(bkg, 0, 0, 1000, 540);
			textSize(35);
			this.text("Please type in your name to see your questionnaire.", 35, 40);
			textSize(25);
			this.text("Your name:", 35, 120);
		//Show the file result.
			textSize(20);
			this.text(result, 100, 180);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		input_name = textfield_name.getText();
				
		read(input_name);
		
		textfield_name.setText("");   //Clear after Enter.	
		
	}
	
	
///////////////////////////////About Excel///////////////////////////////////////////////	
	public void read(String fileName) 
	{
		result = ""; //initial
		try {
		// before we open the file check to see if it already exists
			alreadyExists = new File("../"+fileName+".csv").exists(); 
			
			if (!alreadyExists){
				result="Do not find your file.\nPlease type in again.";
			}
			else{
				CsvReader XLfile = new CsvReader("../"+fileName+".csv");		
				XLfile.readHeaders();				
				
				while (XLfile.readRecord())
				{
					String InputTime = XLfile.get(fileName);
					String InputQuestion = XLfile.get("Question");
					String Option1 = XLfile.get("Always");
					String Option2 = XLfile.get("Sometime");
					String Option3 = XLfile.get("Never");
					
				//////jump to show the result.
					result = result +"\n" + InputQuestion +" Always- " + Option1+"  Sometime- " +Option2+"  Never- "+Option3;
				}
				XLfile.close();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


