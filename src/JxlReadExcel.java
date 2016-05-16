import java.io.IOException;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JxlReadExcel {

	public JxlReadExcel() {
		try{
			Workbook workbook = Workbook.getWorkbook(new File("output.xls"));
			Sheet sheet = workbook.getSheet("Sheet1");
			System.out.println(sheet.getCell(1,0).getContents());
			System.out.println(sheet.getColumns());
			System.out.println(sheet.getRows());
			workbook.close();
		} catch (BiffException e){
			e.printStackTrace();
		} catch (IOException e ){
			e.printStackTrace();
		}
	}

}
