package operations;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class UIOperation {
    WebDriver driver;
    public UIOperation(WebDriver driver){
        this.driver = driver;
    }
    public void perform(Properties p,String operation,String objectName,String objectType,String value, String data) throws Exception{
        System.out.println("");
        switch (operation.toUpperCase()) {
        case "CLICKLINK":
            //Perform click
            driver.findElement(this.getObject(p,objectName,objectType)).click();
            break;
        case "SETTEXT":
            //Set text on control
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(data);
            break;    
        case "CLICKBUTTON":
            //Perform click
            driver.findElement(this.getObject(p,objectName,objectType)).click();
            break; 
        default:
            break;
        }
    }
    private By getObject(Properties p,String objectName,String objectType) throws Exception{
        //Find by xpath
        if(objectType.equalsIgnoreCase("XPATH")){
             
            return By.xpath(p.getProperty(objectName));
        }
        //find by class
        else if(objectType.equalsIgnoreCase("CLASS")){
             
            return By.className(p.getProperty(objectName));
             
        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){
             
            return By.name(p.getProperty(objectName));
             
        }
        
        //find by name
        else if(objectType.equalsIgnoreCase("id")){
             
            return By.id(p.getProperty(objectName));
             
        }
        //Find by css
        else if(objectType.equalsIgnoreCase("CSS")){
             
            return By.cssSelector(p.getProperty(objectName));
             
        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINKTEXT")){
             
            return By.linkText(p.getProperty(objectName));
             
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
             
            return By.partialLinkText(p.getProperty(objectName));
             
        }else
        {
            throw new Exception("Wrong object type");
        }
    }
}