/****
 * Create an new Excel file.
 * ****/
import java.util.Scanner; 
import java.io.IOException;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import jxl.write.*;
import jxl.write.Label;
import jxl.write.Number;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;

public class JxlWriteExcel {

	public JxlWriteExcel() {
		try{
			WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			 
			/*
			WritableFont myFont = new WritableFont(WritableFont.createFont("�з���"), 14);
			myFont.setColour(Colour.WHITE);
			WritableCellFormat cellFormat = new WritableCellFormat();
			 
			cellFormat.setFont(myFont); // ���w�r��
			cellFormat.setBackground(Colour.LIGHT_BLUE); // �I���C��
			cellFormat.setAlignment(Alignment.CENTRE); // ����覡
			*/
			
			//System set the format type: Date - Question - Option1 - Option2 - Option3. 
			Label typeD = new Label(0, 0, "Date"); 
			sheet.addCell(typeD); 
			Label typeQ = new Label(0, 0, "Question"); 
			sheet.addCell(typeQ); 
			Label typeO1 = new Label(0, 0, "Option1"); 
			sheet.addCell(typeO1);
			Label typeO2 = new Label(0, 0, "Option2"); 
			sheet.addCell(typeO2);
			Label typeO3 = new Label(0, 0, "Option3"); 
			sheet.addCell(typeO3);
			
			  // Get the current date and time from the Calendar object .
			Date now = Calendar.getInstance().getTime(); 
			DateFormat customDateFormat = new DateFormat ("dd MMM yyyy hh:mm:ss"); 
			WritableCellFormat dateFormat = new WritableCellFormat (customDateFormat); 
			DateTime dateCell = new DateTime(0, 1, now, dateFormat); 
			sheet.addCell(dateCell); 
			
			// Get the question for the questionnaire.
			System.out.print("Please enter the question for the questionnaire:");
			Scanner input = new Scanner(System.in);
			String s = new String(input.nextLine());
			Label label = new Label(1, 1, s); 
			sheet.addCell(label); 
			
			//Get the options for the questionnaire.
			System.out.println("Please enter the options for your question.");
			System.out.println("Option1:");
			Scanner input1 = new Scanner(System.in);
			String o1 = new String(input1.nextLine());
			Label label1 = new Label(1, 1, o1); 
			sheet.addCell(label1); 
			System.out.println("Option2:");
			Scanner input2 = new Scanner(System.in);
			String o2 = new String(input2.nextLine());
			Label label2 = new Label(1, 1, o2); 
			sheet.addCell(label2); 
			
			workbook.write(); 
			workbook.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}

}
