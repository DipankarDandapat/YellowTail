package GenericLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelHelper extends ExtentReportsHelper {
	
	
String filePath = "Testdata File\\TestData.xlsx";	

private Logger log = LoggerHelper.getLogger(AlertHelper.class);

public ExcelHelper(WebDriver driver) {
	this.driver = driver;
	log.debug("ExcelHelper : " + this.driver.hashCode());
}

	
	
	public String getExcelData(String sheeetName , int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheeetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(colNum).getStringCellValue();
			return data;
		   } catch (Exception ex) {
			ex.printStackTrace();
			log.info("Excel Data Not Found.."+ex);
		  }
		return sheeetName;
	    }
	
	
	
	public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(colNum);
			cel.setCellType(cel.CELL_TYPE_STRING);
			FileOutputStream fos = new FileOutputStream(filePath);
			cel.setCellValue(data);
			wb.write(fos);
			wb.close();
		} catch (Exception ex) {
			
			ex.printStackTrace();
			log.info("Excel Data Not Found.."+ex);
		}
	}

}
