import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.image.ImagingOpException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextField;
import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

@SuppressWarnings("serial")
public class BiggestNumberApplet extends PApplet{
	private boolean pass = false;
	private boolean wrong = false;
	private boolean submit = false;
	private boolean empty = true;
	private boolean curNumber1 = false;
	private boolean curNumber2 = false;
	private boolean lockscreen = false;
	private boolean locked8 = false, locked5 = false, locked4 = false, locked1 = false;
	private boolean locked2_1 = false, locked2_2 = false, locked0_1 = false, locked0_2 = false;
	private boolean on8 = false, on5 = false, on4 = false, on1 = false;
	private boolean on2_1 = false, on2_2 = false, on0_1 = false, on0_2 = false;
	private float moveX, moveY;
	private float eightX = 80, eightY = 300;
	private float fiveX = 230, fiveY = 60;
	private float fourX = 230, fourY = 140;
	private float oneX = 230, oneY = 300;
	private float two_oneX = 80, two_oneY = 60;
	private float two_twoX = 80, two_twoY = 220;
	private float zero_oneX = 230,zero_oneY = 220;
	private float zero_twoX = 80, zero_twoY = 140;

	private HashMap<String, PImage> images = new HashMap<String, PImage>();
	private String[] file = 
	{
		"component/eight.png",
		"component/five.png",
		"component/four.png",
		"component/one.png",
		"component/two_1.png",
		"component/two_2.png",
		"component/zero_1.png",
		"component/zero_2.png",
	};
	
	
	public void setup(){
		Ani.init(this);
		this.setLayout(null);
		size(400, 540);
		smooth();
		
		String []temp = new String[10];
		for(int i=0;i<file.length;i++)
		{
			PImage image = loadImage(this.file[i]);
			temp = this.file[i].split("/");
			images.put(temp[1], image);
		}
	}
	
	public void draw(){
		background(160, 100, 100);
		fill(0);
		textSize(40);
		text("Answer", 120 ,440);
		fill(0, 200, 160);
		stroke(0, 200, 160);
		rect(0, 440, 480, 60);
		fill(0, 100, 160);
		stroke(0, 100, 160);
		rect(320, 500, 80, 40);
		rect(0, 500, 80, 40);
		fill(255);
		textSize(20);
		text("Submit", 328, 528);
		textSize(20);
		text("Again", 10, 528);
		
		image(images.get("eight.png"), eightX, eightY, 60, 60);
		image(images.get("five.png"), fiveX, fiveY, 60, 60);
		image(images.get("four.png"), fourX, fourY, 60, 60);
		image(images.get("one.png"), oneX, oneY, 60, 60);
		image(images.get("two_1.png"), two_oneX, two_oneY, 60, 60);
		image(images.get("two_2.png"), two_twoX, two_twoY, 60, 60);
		image(images.get("zero_1.png"), zero_oneX, zero_oneY, 60, 60);
		image(images.get("zero_2.png"), zero_twoX, zero_twoY, 60, 60);
		
		if(this.curNumber1 && this.curNumber2){
			pass = true;
			wrong = false;
		}
		else{
			wrong = true;
		}
		
		if(wrong && submit)
		{
			fill(255, 0, 0);
			textSize(55);
			this.text("You're wrong!", 20, 240);
		}
		if(pass && submit){
			fill(0, 200, 0);
			textSize(60);
			this.text("You Win !", 60, 240);
			lockscreen = true;
		}
		
	}

	public void mousePressed() {
		if(lockscreen){
			mouseX = 0;
			mouseY = 0;
		}
		
		if(mouseX > 320 && mouseX < 400 && mouseY > 500 && mouseY < 540){
			submit = true;
		}
		
		if(mouseX > eightX && mouseX < eightX+60 && mouseY > eightY && mouseY < eightY+60 && !locked8){
			this.eightX = mouseX-30;
			this.eightY = mouseY-30;
			locked8 = true;
			on8 = true;
		}
		else if(mouseX > fiveX && mouseX < fiveX+60 && mouseY > fiveY && mouseY < fiveY+60 && !locked5){
			this.fiveX = mouseX-30;
			this.fiveY = mouseY-30;
			locked5 = true;
			on5 = true;
		}
		else if(mouseX > fourX && mouseX < fourX+60 && mouseY > fourY && mouseY < fourY+60 && !locked4){
			this.fourX = mouseX-30;
			this.fourY = mouseY-30;
			locked4 = true;
			on4 = true;
		}
		else if(mouseX > oneX && mouseX < oneX+60 && mouseY > oneY && mouseY < oneY+60 && !locked1){
			this.oneX = mouseX-30;
			this.oneY = mouseY-30;
			locked1 = true;
			on1 = true;
		}
		else if(mouseX > two_oneX && mouseX < two_oneX+60 && mouseY > two_oneY && mouseY < two_oneY+60 && !locked2_1){
			this.two_oneX = mouseX-30;
			this.two_oneY = mouseY-30;
			locked2_1 = true;
			on2_1 = true;
		}
		else if(mouseX > two_twoX && mouseX < two_twoX+60 && mouseY > two_twoY && mouseY < two_twoY+60 && !locked2_2){
			this.two_twoX = mouseX-30;
			this.two_twoY = mouseY-30;
			locked2_2 = true;
			on2_2 = true;
		}
		else if(mouseX > zero_oneX && mouseX < zero_oneX+60 && mouseY > zero_oneY && mouseY < zero_oneY+60 && !locked0_1){
			this.zero_oneX = mouseX-30;
			this.zero_oneY = mouseY-30;
			locked0_1 = true;
			on0_1 = true;
		}
		else if(mouseX > zero_twoX && mouseX < zero_twoX+60 && mouseY > zero_twoY && mouseY < zero_twoY+60 && !locked0_2){
			this.zero_twoX = mouseX-30;
			this.zero_twoY = mouseY-30;
			locked0_2 = true;
			on0_2 = true;
		}
	}
	

	public void mouseDragged(){
		if(on8) {
			this.eightX = mouseX-30;
			this.eightY = mouseY-30;
	 	}
		if(on5){
			this.fiveX = mouseX-30;
			this.fiveY = mouseY-30;
		}
		if(on4){
			this.fourX = mouseX-30;
			this.fourY = mouseY-30;
		}
		if(on1){
			this.oneX = mouseX-30;
			this.oneY = mouseY-30;
		}
		if(on2_1){
			this.two_oneX = mouseX-30;
			this.two_oneY = mouseY-30;
		}
		if(on2_2){
			this.two_twoX = mouseX-30;
			this.two_twoY = mouseY-30;
		}
		if(on0_1){
			this.zero_oneX = mouseX-30;
			this.zero_oneY = mouseY-30;
		}
		if(on0_2){
			this.zero_twoX = mouseX-30;
			this.zero_twoY = mouseY-30;
		}
	}

	public void mouseReleased() {
		if(on8){
			if(eightY > 415 && eightY < 470){
				if(empty){
					eightX = 10;
					eightY = 440;
					empty = false;
				}
				else{
					eightX = 70;
					eightY = 440;
				}
			}
			else locked8 = false;
		}
		if(on5){
			if(fiveY > 415 && fiveY < 470){
				if(empty){
					fiveX = 10;
					fiveY = 440;
					empty = false;
				}
				else{
					fiveX = 70;
					fiveY = 440;
				}
			}
			else locked5 = false;
		}
		if(on4){
			if(fourY > 415 && fourY < 470){
				if(empty){
					fourX = 10;
					fourY = 440;
					empty = false;
				}
				else{
					fourX = 70;
					fourY = 440;
				}
			}
			else locked4 = false;
		}
		if(on1){
			if(oneY > 415 && oneY < 470){
				if(empty){
					oneX = 10;
					oneY = 440;
					empty = false;
				}
				else{
					oneX = 70;
					oneY = 440;
				}
			}
			else locked1 = false;
		}
		if(on2_1){
			if(two_oneY > 415 && two_oneY < 470){
				if(empty){
					two_oneX = 10;
					two_oneY = 440;
					empty = false;
				}
				else{
					two_oneX = 70;
					two_oneY = 440;
				}
			}
			else locked2_1 = false;
		}
		if(on2_2){
			if(two_twoY > 415 && two_twoY < 470){
				if(empty){
					two_twoX = 10;
					two_twoY = 440;
					empty = false;
				}
				else{
					two_twoX = 70;
					two_twoY = 440;
				}
			}
			else locked2_2 = false;
		}
		if(on0_1){
			if(zero_oneY > 415 && zero_oneY < 470){
				if(empty){
					zero_oneX = 10;
					zero_oneY = 440;
					empty = false;
					this.curNumber1 = true;
				}
				else if(this.curNumber1){
					zero_oneX = 70;
					zero_oneY = 440;
					this.curNumber2 = true;
				}
				else{
					zero_oneX = 70;
					zero_oneY = 440;
				}
			}
			else locked0_1 = false;
		}
		if(on0_2){
			if(zero_twoY > 415 && zero_twoY < 470){
				if(empty){
					zero_twoX = 10;
					zero_twoY = 440;
					empty = false;
					this.curNumber1 = true;
				}
				else if(this.curNumber1){
					zero_twoX = 70;
					zero_twoY = 440;
					this.curNumber2 = true;
				}
				else{
					zero_twoX = 70;
					zero_twoY = 440;
				}
			}
			else locked0_2 = false;
		}
		on8 = false;
		on5 = false;
		on4 = false;
		on1 = false;
		on2_1 = false;
		on2_2 = false;
		on0_1 = false;
		on0_2 = false;
	}	
}
