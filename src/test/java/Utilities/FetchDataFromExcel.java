package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConstantsData.ConstantData;





public class FetchDataFromExcel {
	
	public  static String  getCredentials(int x,int y) throws IOException
	{
		
		FileInputStream fs=new FileInputStream(ConstantData.EXCEL_PATH);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFCell value=sheet.getRow(x).getCell(y);
		String URLval=value.toString();
		return URLval;
		
		
		
		
	}
	

}
