package maven.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import maven.pageObject.LoginPage;
import maven.pageObject.addcustomer;

public class testdata extends baseclass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user);
		logger.info("User name is provided");
		lp.setpassword(pass);
		logger.info("Passsword is provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		addcustomer addcust=new addcustomer(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}