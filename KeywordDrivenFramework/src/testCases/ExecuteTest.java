package testCases;
import java.util.Properties;
import operations.ReadObject;
import operations.UIOperation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import excelExportAndFileIO.ExcelReader;

public class ExecuteTest {
@Test
    public void testLogin() throws Exception {
    
		WebDriver webdriver = new FirefoxDriver();
		webdriver.get("http://172.25.30.99/myshop/");;
		ExcelReader file = new ExcelReader();
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(webdriver);
		//Read keyword sheet
		Sheet sheet = file.readExcel("..//KeywordDrivenFramework//FileFolder","Keywords.xlsx" , "Sheet1");
		//Find number of rows in excel file
		    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		    //Create a loop over all the rows of excel file to read it
		    for (int i = 1; i <= rowCount; i++) {
		        //Loop over all the rows
		        Row row = sheet.getRow(i);
		       	       
		       Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
		       //Check if the first cell contain a value, if yes, That means it is the new testcase name
		       if(cell.toString()==""){
		    	   Cell dataCell = row.getCell(5, Row.CREATE_NULL_AS_BLANK);   
		    	   
		        //Print testcase detail on console
		            System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+row.getCell(3).toString()+"----"+ row.getCell(4).toString()+"----"+row.getCell(5).toString());
		            
		        //Call perform function to perform operation on UI
		            operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(), row.getCell(4).toString(),dataCell.toString());
		    }
		        else{
		            //Print the new testcase name when it started
		              System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
		           }
		        }
    }
}