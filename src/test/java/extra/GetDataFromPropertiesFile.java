package extra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		
		// 1.Step 1> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("D:\\OOP\\vtiger-crm-framework-A11\\src\\test\\resources\\commondata.properties");
		
		// 2.load all the keys by using load() of Properties class
		Properties pObj = new Properties();
		pObj.load(fis);
		
		//3. get the value by passing the keys
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}

}
