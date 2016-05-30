import de.looksgood.ani.Ani;
//import jxl.read.biff.File;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	JxlWriteExcelApplet XL = new JxlWriteExcelApplet();
	public String fileName;
	
	public void setup(){
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		smooth();
	}
	public void draw(){
		background(200);
		fill(0);
		image(bkg, 0, 0, 1000, 540);
		textSize(35);
		this.text("Please type in your questionnaire.", 35, 40);
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("always").setLabel("Always").setPosition(60, 450).setSize(200, 50);
		cp5.addButton("sometime").setLabel("Sometime").setPosition(380, 450).setSize(200, 50);
		cp5.addButton("never").setLabel("Never").setPosition(700, 450).setSize(200,50);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fileName = "../"+fileName+".csv";
		
		if(option == 1){ //Always
			//XL.create(fileName, QContent);
		}else if(option == 2){//Sometime
			
		}else if(option == 3){//Never
			
		}else{
			
		}
	}
	
	
/////To decide which option be chosen.
	public void always(){
		option = 1;
	}
	public void sometime(){
		option = 2;
	}
	public void never(){
		option = 3;
	}
}
