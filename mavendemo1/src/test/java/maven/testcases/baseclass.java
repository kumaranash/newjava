package maven.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import maven.utilities.Readconfig;

public class baseclass {
	
	Readconfig readconfig = new Readconfig();
	public String baseurl=readconfig.getappliction();
	public String user=readconfig.gwetusername();
	public String pass=readconfig.getpassword();
	public static WebDriver driver;
	
	Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void before(String br) {
		  logger= Logger.getLogger(baseclass.class);
		PropertyConfigurator.configure("log4j2.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/Desktop/MSSQL11.KUMAR/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("An error occured");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseurl);
	
	
	}
	
	@AfterClass
	public void after()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
		
	}

}
