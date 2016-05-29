import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.util.*;
import java.text.*;

public class WritingXL {
	JxlWriteExcelApplet xl = new JxlWriteExcelApplet();
	public WritingXL() {
	}
	
	public void create()
	{
		try
		{
		//Create a blank workbook
			CsvWriter csvOutput = new CsvWriter(new FileWriter("../questionnaire.csv", true), ',');
			
		//Info Setup.
			/*csvOutput.write("Name");
			csvOutput.write("Date");
			csvOutput.write("Question");
			csvOutput.write("answerNum");
			csvOutput.endRecord();*/
			
		//Create a new row in workbook
			csvOutput.write("testerA");
			String curTime = getDateTime();
			csvOutput.write(curTime);
			//System.out.println(getText());
			csvOutput.write("???????");
			csvOutput.endRecord();
			
			csvOutput.close();			
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 	
	}
	
	public void read()
	{
		try {
			
			CsvReader XLfile = new CsvReader("questionnaire.csv");
		
			XLfile.readHeaders();

			while (XLfile.readRecord())
			{
				String InputName = XLfile.get("Name");
				String InputDate = XLfile.get("Date");
				String InputQ = XLfile.get("Question");
				String playerA = XLfile.get("answerNum");
				
				// perform program logic here
				System.out.println(InputName + ":" + InputDate);
			}
			XLfile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	
	