package mavendemo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class dd {
	public static String[][] excel() throws IOException {
		String excel="\\C:\\Users\\Asus\\Desktop\\Book2.xls";
		File w=new File(excel);
		FileInputStream fs=new FileInputStream(w);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("Sheet1");
	int lastrow=	sheet.getLastRowNum();
		short last=sheet.getRow(0).getLastCellNum();
		
	String [][] data=new String[lastrow][last];
		for (int i = 1; i <=lastrow; i++) {
	HSSFRow	row	=sheet.getRow(i);
			//System.out.println(f);
			for(int j=0;j<=1;j++)
			{
			HSSFCell value= row.getCell(j);
			DataFormatter dft=new DataFormatter();
			String d =dft.formatCellValue(value);
			System.out.println(d);
			data[i-1][j]=d;
			}
			
		}
		
		wb.close();
		return data;
	}
}
