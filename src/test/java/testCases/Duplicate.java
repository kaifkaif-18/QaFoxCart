package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Duplicate {

	public Properties p;
	
	
	public void check() throws IOException
	{
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		
		p = new Properties();
		p.load(file);
		
		System.out.println(p.getProperty("appURL"));
		
	}
}
