package maven.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class log4j {
	
	Logger logger;
	WebDriver driver;
	
	@BeforeClass
	
	public void set()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Desktop\\links\\chromedriver.exe");
		driver= new ChromeDriver();
	    
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}
	@AfterClass
	public void tear(){
		driver.quit();
	}
	@Test
	public void show() throws IOException
	{
		logger=Logger.getLogger(log4j.class);
		PropertyConfigurator.configure("log4j2.properties");
		  driver.findElement(By.name("uid")).sendKeys("mngr355909");
		  logger.info("hi");
		  driver.findElement(By.name("password")).sendKeys("epYtuby");
		  
		  driver.findElement(By.name("btnLogin")).click(); 
		 driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();		
	}
	public static void snapshot(WebDriver webdriver,String filewithpath) throws IOException
	{
		TakesScreenshot scr=((TakesScreenshot)webdriver);
		File srcfile=  scr.getScreenshotAs(OutputType.FILE);
		File destfile= new File(filewithpath);
		FileHandler.copy(srcfile,destfile);
		
	}
}
