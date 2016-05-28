import java.util.Random;

import controlP5.ControlP5;
import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.core.PFont;

public class GamePusheenPair extends PApplet{
	private ControlP5 cp5;
	private int width = 1000, height = 600;
	private int cardSize = 150;
	private int initial = 1, howPlay = 0, game = 0, winGame = 0, loseGame = 0;
	private int [] positionX = new int [12];
	private int [] positionY = new int [12];
	private int [] cardOpen  = new int [12]; 
	private int openCard = 0, cardOpened = -1, cardOpened1 = -1, cardOpenedPosition = -1, cardOpened1Position = -1;
	private int [] cardAlwaysOpen = new int[12] ;
	private int openTime = 0;
	private boolean win = false;
	private int calculate = 0, time = 0;
	private int limitedTime = 40;  // Game limited time
	private int pusheenMove = 1;
	private int pusheenWidth = 100, pusheenHeight = 60;
	private int pusheenX = width-pusheenWidth, pusheenY = height - pusheenHeight;
	
	
	private String[] file = {
			"pusheenpair/initial.png",
			"pusheenpair/background.png",
			"pusheenpair/howplay.png",
			"pusheenpair/win.png",
			"pusheenpair/lose.png"
	};
	private String[] cards = {
			"pusheenpair/A.png",
			"pusheenpair/B.png",
			"pusheenpair/C.png",
			"pusheenpair/D.png",
			"pusheenpair/E.png",
			"pusheenpair/F.png",
			"pusheenpair/back.png",
	};
	private int [] cardPosition = new int [12];
	
	public void setup()		
	{	
		Ani.init(this);
		this.setLayout(null);
		size(width, height);
		
		cp5 = new ControlP5(this);
		PFont p = createFont("Consolas", 20);
		cp5.setFont(p);
		cp5.addButton("startbutton").setLabel("START").setPosition(100, 500).setSize(200, 50);
		cp5.addButton("howplay").setLabel("How to play ?").setPosition(700, 500).setSize(200, 50);
	    
		for(int i = 0; i < 12; i++){
			cardAlwaysOpen[i] = 0;
			cardOpen[i] = 0;
			if(i == 0){
				positionX[i] = 0;
				positionY[i] = 0;
			}
			else if(i == 1){
				positionX[i] = 160;
				positionY[i] = 0;
			}
			else if(i == 2){
				positionX[i] = 320;
				positionY[i] = 0;
			}
			else if(i == 3){
				positionX[i] = 480;
				positionY[i] = 0;
			}
			else if(i == 4){
				positionX[i] = 0;
				positionY[i] = 160;
			}
			else if(i == 5){
				positionX[i] = 160;
				positionY[i] = 160;
			}
			else if(i == 6){
				positionX[i] = 320;
				positionY[i] = 160;
			}
			else if(i == 7){
				positionX[i] = 480;
				positionY[i] = 160;
			}
			else if(i == 8){
				positionX[i] = 0;
				positionY[i] = 320;
			}
			else if(i == 9){
				positionX[i] = 160;
				positionY[i] = 320;
			}
			else if(i == 10){
				positionX[i] = 320;
				positionY[i] = 320;
			}
			else if(i == 11){
				positionX[i] = 480;
				positionY[i] = 320;
			}
		}
		
		generateCardPosition();
	}
	public void draw()
	{
		background(255);
		
		if(this.initial == 1)
			image(loadImage(file[0]), 0, 0, width, height);
		if(this.howPlay == 1)
			image(loadImage(file[2]), 0, 0, width, height);
		if(this.game == 1){
			calculateTime();
			image(loadImage(file[1]), 0, 0, width, height);
			
			if(openCard == 1){
				cardOpened1 = cardOpened;
				cardOpened1Position = cardOpenedPosition;
			}
			if(openCard == 2){
				
				if(cardOpened == cardOpened1){
					cardAlwaysOpen[cardOpenedPosition] = 1;
					cardAlwaysOpen[cardOpened1Position] = 1;
					openCard = 0;
				}
				else{
					openTime += 1;
					if(openTime == 2){
						cardOpen[cardOpenedPosition] = 0;
						cardOpen[cardOpened1Position] = 0;
						openTime = 0;
						openCard = 0;
					}
				}
			}
			for(int i = 0; i < 12; i ++){
				if(cardAlwaysOpen[i] == 1){
					
					image(loadImage(cards[cardPosition[i]]),positionX[i],positionY[i],cardSize,cardSize); 
				}
				else{
					if(cardOpen[i] == 0){
						image(loadImage(cards[6]),positionX[i],positionY[i],cardSize,cardSize);
					}
					else{
						image(loadImage(cards[cardPosition[i]]),positionX[i],positionY[i],cardSize,cardSize);
					}
				}
			}
			if(pusheenMove == 1)
				image(loadImage("pusheenpair/pusheentime.png"),pusheenX-5,pusheenY+5,pusheenWidth,pusheenHeight);
			else 
				image(loadImage("pusheenpair/pusheentime.png"),pusheenX+5,pusheenY-5,pusheenWidth,pusheenHeight);
			
			ifEnd();
			ifWin();
		}
		if(this.winGame == 1){
			image(loadImage(file[3]),0,0,width,height);
		}
		if(this.loseGame == 1){
			image(loadImage(file[4]),0,0,width,height);			
		}
	}
	public void calculateTime(){
		if(calculate < 2){
			calculate ++;
		}
		if(calculate == 2){
			calculate = 0;
			time ++;
			pusheenMove *= -1;
			pusheenX = pusheenX - width/limitedTime;
		}
		if(time == limitedTime){  // Endgame
			this.initial = 0;
			this.howPlay = 0;
			this.game = 0;
			this.howPlay = 0;
		}
	}
	public void ifWin(){
		if(this.win == true && time < limitedTime){
			this.initial = 0;
			this.howPlay = 0;
			this.game = 0;
			this.howPlay = 0;
			this.winGame = 1;
		}
		else if (time >= limitedTime && this.win == false){
			this.initial = 0;
			this.howPlay = 0;
			this.game = 0;
			this.howPlay = 0;
			this.loseGame = 1;
		}
			
	}
	public void ifEnd(){
		int n = 0;
		for(int i = 0; i < 12; i++){
			if(cardAlwaysOpen[i] == 1){
				n += 1;
			}
		}
		if(n == 12)
			this.win = true;
	}
	
	public void generateCardPosition(){
		
		Random ran = new Random();
		int [] check = new int [12];
		for(int i = 0; i < 12; i++){
			check[i] = 0;
		}
		
		for(int i = 0; i < 12; i++){
				cardPosition[i] = ran.nextInt(6);
				if(check[cardPosition[i]] == 2)
					i = i - 1;
				else
					check[cardPosition[i]] += 1;
		}
		/*for(int i = 0; i < 12 ;i++){
			System.out.println(cardPosition[i]);
		}*/
	}
	public void mousePressed()
	{
		if(this.game == 1 && this.openCard != 2){
			for(int i = 0; i < 12; i ++){
				if(mouseX >= positionX[i] && mouseX <= positionX[i] + cardSize && mouseY >= positionY[i] && mouseY <= positionY[i] + cardSize && cardAlwaysOpen[i] != 1){
					cardOpen[i] = 1;
					openCard += 1;
					cardOpened = cardPosition[i];
					cardOpenedPosition = i;
				}
			}
		}
	}
	
	public void startbutton(){
		cp5.remove("startbutton");
		cp5.remove("howplay");
		this.initial = 0;
		this.howPlay = 0;
		this.game = 1;
		
	}
	public void howplay(){
		cp5.remove("startbutton");
		cp5.remove("howplay");
		cp5.addButton("buttonBack").setLabel("Back").setPosition(900, 500).setSize(100,100);
		this.initial = 0;
		this.howPlay = 1;
	}
	public void buttonBack(){
		cp5.remove("buttonBack");
		cp5.addButton("startbutton").setLabel("START").setPosition(100, 500).setSize(200, 50);
		cp5.addButton("howplay").setLabel("How to play ?").setPosition(700, 500).setSize(200, 50);
		this.initial = 1;
		this.howPlay = 0;
	}
}
