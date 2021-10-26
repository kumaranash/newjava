package mavendemo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class write {
@Test
	public void data() throws IOException {
		String excel="\\C:\\Users\\Asus\\Desktop\\Book2.xls";
	File w=new File(excel);
	FileInputStream fs=new FileInputStream(w);
	HSSFWorkbook wb= new HSSFWorkbook(fs);
	HSSFSheet sheet=wb.getSheet("Sheet1");
	sheet.getRow(1).createCell(2).setCellValue("perfect");
	sheet.getRow(2).createCell(2).setCellValue("perfect");
	sheet.getRow(3).createCell(2).setCellValue("perfect");
	sheet.getRow(1).createCell(3).setCellValue("perfect");
	sheet.getRow(2).createCell(3).setCellValue("perfect");
	FileOutputStream fd=new FileOutputStream(new File(excel));
	wb.write(fd);
	
	wb.close();
	fd.close();
}
}
