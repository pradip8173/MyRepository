package excelExportAndFileIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.Sheet;


public class ExcelReader {

	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
	    //Create a object of File class to open xlsx file
	    File file =    new File(filePath+"\\"+fileName);
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    
	    //Find the file extension by spliting file name in substing and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    
	    Workbook workbook = new XSSFWorkbook(inputStream);
	   	    
	 	    //Read sheet inside the workbook by its name
	    Sheet firstsheet = workbook.getSheetAt(0);
	    workbook.close();
        inputStream.close();
        
	     return firstsheet;    
	    }
}