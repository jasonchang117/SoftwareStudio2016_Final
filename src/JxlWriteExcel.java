import java.util.Scanner; 
import java.io.IOException;
import java.io.File;
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
			WritableWorkbook workbook = Workbook.createWorkbook(new File("output_test.xls"));
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			 
			WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);
			myFont.setColour(Colour.WHITE);
			WritableCellFormat cellFormat = new WritableCellFormat();
			 
			cellFormat.setFont(myFont); // 指定字型
			cellFormat.setBackground(Colour.LIGHT_BLUE); // 背景顏色
			cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
			
			Scanner input = new Scanner(System.in);
			String s = new String(input.nextLine());
			Label label = new Label(0, 1, s); 
			sheet.addCell(label); 
			//Number number = new Number(3, 4, 3.1459); 
			//sheet.addCell(number); 
			
			workbook.write(); 
			workbook.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}catch(WriteException e){
			e.printStackTrace();
		}
	}

}
