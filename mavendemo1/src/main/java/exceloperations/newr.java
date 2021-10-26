
package exceloperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mavendemo1.da;
import mavendemo1.write;

public class newr {

	

	WebDriver driver;
	
	@BeforeClass
	public void set()
	{
		
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Asus\\Desktop\\links\\chromedriver.exe"); driver= new
		 * ChromeDriver();
		 * 
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 * driver.get("http://demo.guru99.com/V4/");
		 */
		 
	}
	
	@Test
	public void show() throws IOException
	{
		/*
		 * driver.findElement(By.name("uid")).sendKeys(edata[0]);
		 * 
		 * driver.findElement(By.name("password")).sendKeys(edata[1]);
		 * 
		 * driver.findElement(By.name("btnLogin")).click();
		 * 
		 * driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
		 * 
		 * String w=edata[0];
		 * 
		 * String expected="mngr355909"; if(w.equalsIgnoreCase(expected)) {
		 * System.out.print("perfect"); } write e=new write();
		 * 
		 * 
		 * Alert alert =driver.switchTo().alert(); alert.accept();
		 * 
		 * //System.out.println(data[0]);
		 *///excel d= new excel();
		//excel();
		
	}
	public static void excel() throws IOException {
		String excel="\\C:\\Users\\Asus\\Desktop\\Book2.xls";
		File w=new File(excel);
		FileInputStream fs=new FileInputStream(w);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("Sheet1");
	int lastrow=	sheet.getLastRowNum();
		short last=sheet.getRow(0).getLastCellNum();
		
	//String [][] data=new String[lastrow][last];
		for (int i = 1; i <=lastrow; i++) {
	HSSFRow	row	=sheet.getRow(i);
			//System.out.println(f);
			for(int j=0;j<=1;j++)
			{
			HSSFCell value= row.getCell(j);
			DataFormatter dft=new DataFormatter();
			String d =dft.formatCellValue(value);
			System.out.println(d);
	///		data[i-1][j]=d;
			}
			
		}
		
		wb.close();
	
	}
}
