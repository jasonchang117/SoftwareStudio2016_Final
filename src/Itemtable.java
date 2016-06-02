
public class Itemtable {
	private int tape;		// 0->not visible, 1->visible
	private int knif;						// 0->not visible, 1->visible
	private int pusheenBottle;
	private int normalBottleFull;
	private int lighter;	
	private int hammer;
	private int hose;
	private int normalBottle;
	private int pusheenBottleFull;
	private int normalBottleWithHose;
	
	public Itemtable() {
		// TODO Auto-generated constructor stub
		tape = 0;
		knif = 0;
		pusheenBottle = 0;
		normalBottleFull = 0;
		lighter = 1;
		hammer = 0;
		hose = 0;
		normalBottle = 0;
		pusheenBottleFull = 0;
		normalBottleWithHose = 0;
	}

	
	
	
	public int tape() { return this.tape; }
	public int knif() { return this.knif; }
	public int pusheenBottle() { return this.pusheenBottle; }
	public int lighter() { return this.lighter; }
	public int hammer() { return this.hammer; }
	public int hose(){return this.hose; }
	public int normalBottle(){return this.normalBottle; }
	public int pusheenBottleFull() {return this.pusheenBottleFull;}
	public int normalBottleWithHose() {return this.normalBottleWithHose;}
	public int normalBottleFull() {return this.normalBottleFull;}
	
	
	public void tape_vanish() { this.tape = 0; }
	public void knif_vanish() { this.knif = 0; }
	public void pusheenBottle_vanish() {this.pusheenBottle = 0; }
	public void lighter_vanish() { this.lighter = 0; }
	public void hammer_vanish() { this.hammer = 0; }
	public void hose_vanish(){	this.hose = 0;}
	public void normalBottle_vanish(){	this.normalBottle = 0;}
	public void pusheenBottleFull_vanish() { this.pusheenBottleFull = 0;}
	public void normalBottleFull_vanish() {this.normalBottleFull = 0;}
	public void normalBottleFullWithHose_vanish() {this.normalBottleWithHose = 0;}
	
	public void tape_appear() { this.tape = 1; }
	public void knif_appear() { this.knif = 1; }
	public void pusheenBottle_appear() {this.pusheenBottle = 1; }
	public void lighter_appear() { this.lighter = 1; }
	public void hammer_appear() { this.hammer = 1; }
	public void hose_appear(){this.hose = 1;}
	public void normalBottle_appear(){this.normalBottle = 1;}
	public void pusheenBottleFull_appear() {this.pusheenBottleFull = 1;}
	public void normalBottleFull_appear() {this.normalBottleFull = 1;}
	public void normalBottleFullWithHose_appear() {this.normalBottleWithHose = 1;}
	
}
