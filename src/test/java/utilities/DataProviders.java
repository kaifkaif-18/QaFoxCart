package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="LogInData")
			public String[][] getdata() throws IOException
			{
		
				String path =".\\testData\\Opencart_LoginData.xlsx";
				
				ExcelUtilities exuti = new ExcelUtilities(path);
				
				int rowcount = exuti.getRowCount("Sheet1");
				int colcount = exuti.getCellCount("Sheet1",1);
				
				String logindata[][] = new String [rowcount][colcount];
				for(int i = 1;i<=rowcount;i++)
				{
					for(int j = 0;j < colcount;j++)
					{
						logindata[i-1][j] = exuti.getCellData("Sheet1", i, j);
					}
				}
				return logindata;			
		}
				
}
			

