import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class questionSet implements ActionListener{
	private MainApplet parent;
	private String input;
	private Font f = new Font("Consolas", 0, 25);
	TextField textfield = new TextField(15);
	
	public questionSet(MainApplet parent)
	{
		this.parent = parent;
		textfield.setFont(f);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		input = textfield.getText();
        textfield.setText("");
	}
	
	public void display()
	{
		textfield.addActionListener(this);
		textfield.setBounds(50,50,850,300);
		parent.add(textfield);

	}
	
	public void removeText(){
		parent.remove(textfield);
	}
	
	public String getText()
	{
	   	return this.input;
	}
}
