package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.net.URL;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	

public static WebDriver driver;
public Logger logger;  //Log4j
public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
				
		logger=LogManager.getLogger(this.getClass());  //lOG4J2
				
//		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
//		{
//			DesiredCapabilities capabilities=new DesiredCapabilities();
//			
//			//os
//			if(os.equalsIgnoreCase("windows"))
//			{
//				capabilities.setPlatform(Platform.WIN11);
//			}
//			else if (os.equalsIgnoreCase("mac"))
//			{
//				capabilities.setPlatform(Platform.MAC);
//			}
//			else
//			{
//				System.out.println("No matching os");
//				return;
//			}
//			
//			//browser
//			switch(br.toLowerCase())
//			{
//			case "chrome": capabilities.setBrowserName("chrome"); break;
//			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
//			case "firefox": capabilities.setBrowserName("firefox");break;
//			default: System.out.println("No matching browser"); return;
//			}
//			
//			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
//		}
//		
//				
//		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
//		{

			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
//		}
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(p.getProperty("appURL"));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
//	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	public String randomf()
	{
		String randomfn = RandomStringUtils.randomAlphabetic(5);
		return randomfn;
	}
	
	public String randoml()
	{
		String randomln = RandomStringUtils.randomAlphabetic(5);
		return randomln;
	}
	
	public String randome()
	{
		String randome = RandomStringUtils.randomAlphabetic(3);
		String randomm = RandomStringUtils.randomNumeric(3);
		return (randome+randomm);
	}
	
	public String randomt()
	{
		String randomte = RandomStringUtils.randomNumeric(10);
		return randomte;
	}
	
	public String randomp()
	{
		String randompw = RandomStringUtils.randomAlphabetic(6);
		return randompw;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
}