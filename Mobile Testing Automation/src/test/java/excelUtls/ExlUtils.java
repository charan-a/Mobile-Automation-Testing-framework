package excelUtls;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExlUtils {
	static String projectpath;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell Cell;
    private static XSSFRow Row;
	public ExlUtils(){
		try {
			projectpath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath +  "\\excel\\data.xlsx"); 
			sheet = workbook.getSheet("Sheet1"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		ExlUtils exl = new ExlUtils();
		//System.out.println( x );
		
	}
	
	public static int getrowcount(){
		int noofrows = sheet.getPhysicalNumberOfRows();
		return noofrows;
	}
	public static int getcolumncount(){
		int noofcols = sheet.getRow(0).getLastCellNum();
		return noofcols;
	}
	public static String getStringDataCell(int row, int col) {
		String value = sheet.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	
	public static double getDoubleDataCell(int row, int col) {
		Double value = sheet.getRow(row).getCell(col).getNumericCellValue();
		return value;
	}
	
}
