import java.util.HashMap;
import controlP5.ControlP5;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

@SuppressWarnings("serial")
public class BiggestNumberApplet extends PApplet{
	BiggestNumber biggest;
	private boolean pass = false;
	private boolean wrong = false;
	private boolean curNumber1 = false;
	private boolean curNumber2 = false;
	private boolean lockscreen = false;
	private boolean locked8 = false, locked5 = false, locked4 = false, locked1 = false;
	private boolean locked2_1 = false, locked2_2 = false, locked0_1 = false, locked0_2 = false;
	private boolean on8 = false, on5 = false, on4 = false, on1 = false;
	private boolean on2_1 = false, on2_2 = false, on0_1 = false, on0_2 = false;
	private int space = 0;
	private float two_oneX = 360, two_oneY = 80;
	private float two_twoX = 35, two_twoY = 280;
	private float zero_twoX = 90, zero_twoY = 120;
	private float eightX = 200, eightY = 80;
	private float fiveX = 155, fiveY = 310;
	private float fourX = 190, fourY = 190;
	private float zero_oneX = 345, zero_oneY = 300;
	private float oneX = 290, oneY = 165;
	private ControlP5 cp5;
	
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
		"component/infinite.png",
	};
	
	public BiggestNumberApplet(BiggestNumber b)
	{
		this.biggest = b;
	}
	
	public void setup(){
		Ani.init(this);
		this.setLayout(null);
		size(540, 540);
		smooth();
		
		String []temp = new String[10];
		for(int i=0;i<file.length;i++)
		{
			PImage image = loadImage(this.file[i]);
			temp = this.file[i].split("/");
			images.put(temp[1], image);
		}
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("submit").setLabel("SUBMIT").setPosition(430, 500).setSize(90, 40);
		cp5.addButton("retry").setLabel("RETRY").setPosition(0, 500).setSize(90, 40);
		
	}
	
	public void draw()
	{
		background(160, 100, 100);
		fill(0);
		textSize(36);
		text("Answer", 186 ,435);
		fill(0, 200, 160);
		stroke(0, 200, 160);
		rect(0, 439, 540, 60);
		fill(0, 100, 100);
		stroke(0, 100, 100);
		rect(0, 0, 540, 60);
		fill(0);
		textSize(33);
		text("Find The BiggestNumber", 44, 45);
		
		image(images.get("eight.png"), eightX, eightY, 60, 60);
		image(images.get("five.png"), fiveX, fiveY, 60, 60);
		image(images.get("four.png"), fourX, fourY, 60, 60);
		image(images.get("one.png"), oneX, oneY, 60, 60);
		image(images.get("two_1.png"), two_oneX, two_oneY, 60, 60);
		image(images.get("two_2.png"), two_twoX, two_twoY, 60, 60);
		if(this.curNumber2 == false)
		{
			image(images.get("zero_1.png"), zero_oneX, zero_oneY, 60, 60);
			image(images.get("zero_2.png"), zero_twoX, zero_twoY, 60, 60);
		}
		else
			image(images.get("infinite.png"), 8, 430, 110, 80);
		
		
		if(wrong)
		{
			fill(255, 0, 0);
			textSize(55);
			this.text("You're wrong!", 60, 260);
			}
		if(pass)
		{
			fill(0, 200, 0);
			textSize(60);
			this.text("You Win !", 120, 260);
		}
		
	}

	public void mousePressed() 
	{	
		if(lockscreen){
			mouseX = 45;
			mouseY = 520;
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
				if(space == 0){
					eightX = 5;
					eightY = 440;
					space = 1;
				}
				else if(space == 1){
					eightX = 65;
					eightY = 440;
					space = 2;
				}
				else if(space == 2){
					eightX = 125;
					eightY = 440;
					space = 3;
				}
				else if(space == 3){
					eightX = 185;
					eightY = 440;
					space = 4;
				}
				else if(space == 4){
					eightX = 245;
					eightY = 440;
					space = 5;
				}
				else if(space == 5){
					eightX = 305;
					eightY = 440;
					space = 6;
				}
				else if(space == 6){
					eightX = 365;
					eightY = 440;
					space = 7;
				}
				else if(space == 7){
					eightX = 425;
					eightY = 440;
					space = 8;
				}
			}
			else locked8 = false;
		}
		if(on5){
			if(fiveY > 415 && fiveY < 470){
				if(space == 0){
					fiveX = 5;
					fiveY = 440;
					space = 1;
				}
				else if(space == 1){
					fiveX = 65;
					fiveY = 440;
					space = 2;
				}
				else if(space == 2){
					fiveX = 125;
					fiveY = 440;
					space = 3;
				}
				else if(space == 3){
					fiveX = 185;
					fiveY = 440;
					space = 4;
				}
				else if(space == 4){
					fiveX = 245;
					fiveY = 440;
					space = 5;
				}
				else if(space == 5){
					fiveX = 305;
					fiveY = 440;
					space = 6;
				}
				else if(space == 6){
					fiveX = 365;
					fiveY = 440;
					space = 7;
				}
				else if(space == 7){
					fiveX = 425;
					fiveY = 440;
					space = 8;
				}
			}
			else locked5 = false;
		}
		if(on4){
			if(fourY > 415 && fourY < 470){
				if(space == 0){
					fourX = 5;
					fourY = 440;
					space = 1;
				}
				else if(space == 1){
					fourX = 65;
					fourY = 440;
					space = 2;
				}
				else if(space == 2){
					fourX = 125;
					fourY = 440;
					space = 3;
				}
				else if(space == 3){
					fourX = 185;
					fourY = 440;
					space = 4;
				}
				else if(space == 4){
					fourX = 245;
					fourY = 440;
					space = 5;
				}
				else if(space == 5){
					fourX = 305;
					fourY = 440;
					space = 6;
				}
				else if(space == 6){
					fourX = 365;
					fourY = 440;
					space = 7;
				}
				else if(space == 7){
					fourX = 425;
					fourY = 440;
					space = 8;
				}
			}
			else locked4 = false;
		}
		if(on1){
			if(oneY > 415 && oneY < 470){
				if(space == 0){
					oneX = 5;
					oneY = 440;
					space = 1;
				}
				else if(space == 1){
					oneX = 65;
					oneY = 440;
					space = 2;
				}
				else if(space == 2){
					oneX = 125;
					oneY = 440;
					space = 3;
				}
				else if(space == 3){
					oneX = 185;
					oneY = 440;
					space = 4;
				}
				else if(space == 4){
					oneX = 245;
					oneY = 440;
					space = 5;
				}
				else if(space == 5){
					oneX = 305;
					oneY = 440;
					space = 6;
				}
				else if(space == 6){
					oneX = 365;
					oneY = 440;
					space = 7;
				}
				else if(space == 7){
					oneX = 425;
					oneY = 440;
					space = 8;
				}
			}
			else locked1 = false;
		}
		if(on2_1){
			if(two_oneY > 415 && two_oneY < 470){
				if(space == 0){
					two_oneX = 5;
					two_oneY = 440;
					space = 1;
				}
				else if(space == 1){
					two_oneX = 65;
					two_oneY = 440;
					space = 2;
				}
				else if(space == 2){
					two_oneX = 125;
					two_oneY = 440;
					space = 3;
				}
				else if(space == 3){
					two_oneX = 185;
					two_oneY = 440;
					space = 4;
				}
				else if(space == 4){
					two_oneX = 245;
					two_oneY = 440;
					space = 5;
				}
				else if(space == 5){
					two_oneX = 305;
					two_oneY = 440;
					space = 6;
				}
				else if(space == 6){
					two_oneX = 365;
					two_oneY = 440;
					space = 7;
				}
				else if(space == 7){
					two_oneX = 425;
					two_oneY = 440;
					space = 8;
				}
			}
			else locked2_1 = false;
		}
		if(on2_2){
			if(two_twoY > 415 && two_twoY < 470){
				if(space == 0){
					two_twoX = 5;
					two_twoY = 440;
					space = 1;
				}
				else if(space == 1){
					two_twoX = 65;
					two_twoY = 440;
					space = 2;
				}
				else if(space == 2){
					two_twoX = 125;
					two_twoY = 440;
					space = 3;
				}
				else if(space == 3){
					two_twoX = 185;
					two_twoY = 440;
					space = 4;
				}
				else if(space == 4){
					two_twoX = 245;
					two_twoY = 440;
					space = 5;
				}
				else if(space == 5){
					two_twoX = 305;
					two_twoY = 440;
					space = 6;
				}
				else if(space == 6){
					two_twoX = 365;
					two_twoY = 440;
					space = 7;
				}
				else if(space == 7){
					two_twoX = 425;
					two_twoY = 440;
					space = 8;
				}
			}
			else locked2_2 = false;
		}
		if(on0_1){
			if(zero_oneY > 415 && zero_oneY < 470){
				if(space == 0){
					zero_oneX = 5;
					zero_oneY = 440;
					space = 1;
					this.curNumber1 = true;
				}
				else if(this.curNumber1 && space == 1){
					zero_oneX = 65;
					zero_oneY = 440;
					this.curNumber2 = true;
					space = 2;
				}
				else if(space == 1){
					zero_oneX = 65;
					zero_oneY = 440;
					space = 2;
				}
				else if(space == 2){
					zero_oneX = 125;
					zero_oneY = 440;
					space = 3;
				}
				else if(space == 3){
					zero_oneX = 185;
					zero_oneY = 440;
					space = 4;
				}
				else if(space == 4){
					zero_oneX = 245;
					zero_oneY = 440;
					space = 5;
				}
				else if(space == 5){
					zero_oneX = 305;
					zero_oneY = 440;
					space = 6;
				}
				else if(space == 6){
					zero_oneX = 365;
					zero_oneY = 440;
					space = 7;
				}
				else if(space == 7){
					zero_oneX = 425;
					zero_oneY = 440;
					space = 8;
				}
			}
			else locked0_1 = false;
		}
		if(on0_2){
			if(zero_twoY > 415 && zero_twoY < 470){
				if(space == 0){
					zero_twoX = 5;
					zero_twoY = 440;
					space = 1;
					this.curNumber1 = true;
				}
				else if(this.curNumber1 && space == 1){
					zero_twoX = 65;
					zero_twoY = 440;
					this.curNumber2 = true;
					space = 2;
				}
				else if(space == 1){
					zero_twoX = 65;
					zero_twoY = 440;
					space = 2;
				}
				else if(space == 2){
					zero_twoX = 125;
					zero_twoY = 440;
					space = 3;
				}
				else if(space == 3){
					zero_twoX = 185;
					zero_twoY = 440;
					space = 4;
				}
				else if(space == 4){
					zero_twoX = 245;
					zero_twoY = 440;
					space = 5;
				}
				else if(space == 5){
					zero_twoX = 305;
					zero_twoY = 440;
					space = 6;
				}
				else if(space == 6){
					zero_twoX = 365;
					zero_twoY = 440;
					space = 7;
				}
				else if(space == 7){
					zero_twoX = 425;
					zero_twoY = 440;
					space = 8;
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
	
	public void submit()
	{
		this.lockscreen = true;
		if(this.curNumber2 == true && this.space == 2)
		{
			this.pass = true;
			biggest.getPass();
		}
		else
			this.wrong = true;
	}
	
	public void retry()
	{
		two_oneX = 360; two_oneY = 80;
		two_twoX = 35; two_twoY = 280;
		zero_twoX = 90; zero_twoY = 120;
		eightX = 200; eightY = 80;
		fiveX = 155; fiveY = 310;
		fourX = 190; fourY = 190;
		zero_oneX = 345; zero_oneY = 300;
		oneX = 290; oneY = 165;
		this.space = 0;
		this.curNumber1 = false;
		this.curNumber2 = false;
		this.pass = false;
		this.wrong = false;
		this.lockscreen = false;
		this.locked0_1 = false;
		this.locked0_2 = false;
		this.locked2_1 = false;
		this.locked2_2 = false;
		this.locked1 = false;
		this.locked4 = false;
		this.locked5 = false;
		this.locked8 = false;
	}
	
	public int getPass()
	{
		if(this.pass == true)
			return 1;
		else
			return 0;
	}
}
