package maven.testcases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import maven.pageObject.LoginPage;

public class testcase extends baseclass {

	@Test
	public void test() throws InterruptedException, IOException
	{
		driver.get(baseurl);
		logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		logger.info("username entered");
		Thread.sleep(2000);	
		lp.setusername(user);
		Thread.sleep(2000);
		logger.info("password entered");
		lp.setpassword(pass);
		Thread.sleep(2000); 
		lp.clicksubmit();
		 if (true) {
	            if (!true) {
	                System.out.println(false);
	            } else {
	                System.out.println(1);
	            }
	        } else {
	            System.out.println(true);

	        }
		
		String expected ="Welcome To Manager's Page of Guru99 Bank";
		String actual=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).getText();
		
		Assert.assertEquals(expected,actual);
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"testcase");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}
	
	
}
