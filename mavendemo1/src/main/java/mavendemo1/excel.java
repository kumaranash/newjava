package mavendemo1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class excel {
	
	WebDriver driver;
	
	@BeforeClass
	public void set()
	{
		
		
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\Asus\\Desktop\\links\\chromedriver.exe");
		  driver= new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("http://demo.guru99.com/V4/");
		 
	}
	@AfterClass
	public void tear(){
		driver.close();
	}
	@Test(dataProvider="getdata", dataProviderClass=da.class)
	public void show(String edata[]) throws IOException
	{
		
		  driver.findElement(By.name("uid")).sendKeys(edata[0]);
		  
		  driver.findElement(By.name("password")).sendKeys(edata[1]);
		  
		  driver.findElement(By.name("btnLogin")).click();
		 
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
		
		String w=edata[0];
		
		String expected="mngr355909";
		if(w.equalsIgnoreCase(expected))
		{		
			System.out.print("perfect");
		}
		write e=new write();
		
		
		Alert alert =driver.switchTo().alert();
		alert.accept();
		
		
		//System.out.println(data[0]);
		//excel d= new excel();
		
	}
	public void data() throws IOException {
		String excel="\\C:\\Users\\Asus\\Desktop\\Book2.xls";
	File w=new File(excel);
	FileInputStream fs=new FileInputStream(w);
	HSSFWorkbook wb= new HSSFWorkbook(fs);
	HSSFSheet sheet=wb.getSheet("Sheet1");
	sheet.getRow(1).createCell(2).setCellValue("perfect1");
	sheet.getRow(2).createCell(2).setCellValue("perfect1");
	sheet.getRow(3).createCell(2).setCellValue("perfect1");
	sheet.getRow(1).createCell(3).setCellValue("perfect");
	sheet.getRow(2).createCell(3).setCellValue("perfect");
	FileOutputStream fd=new FileOutputStream(new File(excel));
	wb.write(fd);
	
	wb.close();
	fd.close();
}
	
	
	
}
