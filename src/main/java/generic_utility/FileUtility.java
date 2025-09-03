package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String value = pObj.getProperty(key);

		return value;
		
	}
	
	public String getStringDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {
FileInputStream fis2 = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(sheetName);

		String value = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();

		return value;
	}
	
	public String getNumericDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {
		FileInputStream fis2 = new FileInputStream(
				"D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		Sheet sh = wb.getSheet(sheetName);
		double phnnum = sh.getRow(2).getCell(1).getNumericCellValue();
		long phnnumLong = (long) phnnum;
		String phnnumString = String.valueOf(phnnumLong);
	//	System.out.println(phnnumString);
		return phnnumString;
		
	}
	
	public static void main(String[] args) throws IOException {
		FileUtility fUtil = new FileUtility();
		String value1 =fUtil.getNumericDataFromExcelFile("orgName", 1, 1);
		System.out.println(value1);
	}

}
