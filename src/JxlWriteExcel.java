/****
 * Create an new Excel file.
 * ****/
import java.util.Scanner; 
import java.io.IOException;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import jxl.write.*;
import jxl.write.Number;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;

public class JxlWriteExcel {

	public JxlWriteExcel(String text) {
		try{
			WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
					System.out.println("FQ~");
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			 
			
			WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);
			myFont.setColour(Colour.WHITE);
			WritableCellFormat cellFormat = new WritableCellFormat();
			 
			cellFormat.setFont(myFont); // 指定字型
			cellFormat.setBackground(Colour.LIGHT_BLUE); // 背景顏色
			cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
			
			
			//System set the format type: Date - Question - Yes - No. 
			Label typeD = new Label(0, 0, "Date"); 
			sheet.addCell(typeD); 
			Label typeQ = new Label(0, 0, "Question"); 
			sheet.addCell(typeQ); 
			Label typeO1 = new Label(0, 0, "Option1"); 
			sheet.addCell(typeO1);
			Label typeO2 = new Label(0, 0, "Option2"); 
			sheet.addCell(typeO2);
			
			  // Get the current date and time from the Calendar object .
			Date now = Calendar.getInstance().getTime(); 
			DateFormat customDateFormat = new DateFormat ("dd MMM yyyy hh:mm:ss"); 
			WritableCellFormat dateFormat = new WritableCellFormat (customDateFormat); 
			DateTime dateCell = new DateTime(0, 1, now, dateFormat); 
			sheet.addCell(dateCell); 
		/*	
			// Get the question for the questionnaire.
			System.out.print("Please enter the question for the questionnaire:");
			Scanner input = new Scanner(System.in);
			String s = new String(input.nextLine());*/
			Label label = new Label(1, 1, text); 
			sheet.addCell(label); 
			
			workbook.write(); 
			workbook.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}
}
