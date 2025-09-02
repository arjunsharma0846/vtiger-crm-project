package extra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh =wb.getSheet("orgName");
		
	//	Row row = sh.getRow(2);
		
	//	Cell cell =row.getCell(0);
		
	/*	String v1 =sh.getRow(1).getCell(0).getStringCellValue();
		String v2 =sh.getRow(2).getCell(0).getStringCellValue();
		String v3 =sh.getRow(3).getCell(0).getStringCellValue();
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
	*/
		int lastrow =sh.getLastRowNum();
		System.out.println(lastrow);
		
		
		
		for (int i = 0; i <= 5 ; i++) {
			String v1 = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(v1);
			
		}
		
		wb.close();
	}

}
