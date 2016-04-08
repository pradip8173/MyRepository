import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 

public class ExcelRead {
     
    public static void main(String[] args) throws IOException {
        
    	WebDriver wd= new FirefoxDriver();
    	wd.get("http://172.25.30.99/myshop/");
    	
    	String excelFilePath = "C:\\Users\\pradippa\\Desktop\\Keywords.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        int rowcount = firstSheet.getLastRowNum()-firstSheet.getFirstRowNum();
        
        for(int i=1; i<rowcount+1; i++)
        {
        	Row row = firstSheet.getRow(i);
        	
        	if(row.getCell(0).toString().length()==0){
                //Print testcase detail on console
                    System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
                    row.getCell(3).toString()+"----"+ row.getCell(4).toString());
                    
                    
                //Call perform function to perform operation on UI
//                    operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
//                        row.getCell(3).toString(), row.getCell(4).toString());
        	}
        	else
        	{
        		
        		System.out.println(("New Test case ->"+row.getCell(0).toString()));
        	}
        }
        
        
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
         
        workbook.close();
        inputStream.close();
    }
 
}