package mavendemo1;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class da {
@DataProvider
public String [][] getdata() throws IOException
{
	String [][] edata=dd.excel();
	
	
	return edata;
	
}
	
}
