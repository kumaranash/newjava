package maven.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties pro;
	
	public Readconfig()
	{
		File src= new File("./Configuration/config.properties");
		
	   try
		{
					FileInputStream fis= new FileInputStream(src);
					pro=new Properties();
					pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	public String getappliction()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String gwetusername()
	{
		String username=pro.getProperty("user");
		return username;
	}
	public String getpassword()
	{
		String password=pro.getProperty("pass");
		return password;
	}
	public String getpath() {
		String path=pro.getProperty("chromepath");
		return path;
	}
}
