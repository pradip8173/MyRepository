
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CrossBrowserTest {
	protected static WebDriver wd;
	String appUrl="http://172.25.30.xx/myshop/";
	 
	@BeforeClass
    public static void setup()  
	{
	//System.setProperty("webdriver.chrome.driver","D://Selenium//From Akash//Selenium//chromedriver_win32//chromedriver.exe");//
	System.setProperty("webdriver.ie.driver","D://Selenium//IEDriverServer.exe");
    //wd = new ChromeDriver();
    wd = new InternetExplorerDriver();
    //wd=new FirefoxDriver();
   
   }
	
	@Test(priority=0, enabled =true,groups="A")
	void MyshopLaunch() throws Exception {
	    wd.get(appUrl);
	    wd.findElement(By.cssSelector("body")).click();
	    assertEquals(wd.getTitle(), "myShop");
	    assertEquals(wd.findElement(By.linkText("Log in")).getText(), "Log in");	
	}
	
	@Test(priority=1,groups="A")
	void Login() throws Exception
	{
		wd.get(appUrl); 	  			
		wd.manage().window().maximize(); 	 				
 		String expectedTitle = "myShop"; 	 		 	
 		String actualTitle = wd.getTitle();			
        if (expectedTitle.equals(actualTitle)) 	
 		{ 	System.out.println("Verification Successful - The correct title is displayed on the web page.");} 	
 		 else 	
 		{ 	System.out.println("Verification Failed - An incorrect title is displayed on the web page.");}
        
        	wd.findElement(By.className("ico-login")); 			
        	wd.findElement(By.className("ico-login")).click(); 	 			
 		    wd.findElement(By.id("Email")); 	
 		    wd.findElement(By.id("Email")).clear(); 	
 		    wd.findElement(By.id("Email")).sendKeys("");
 	        wd.findElement(By.id("Password")); 	
 	        wd.findElement(By.id("Password")).clear(); 		
 	        wd.findElement(By.id("Password")).sendKeys("");
 		    wd.findElement(By.xpath("html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")); 		   			
 		    wd.findElement(By.xpath("html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click(); 		 		
 		    System.out.println("Test script executed successfully."); 		  
	}
	
	@Test(priority=2,enabled =true, groups="B")
	void ProductSearch() throws Exception
	{		
			wd.findElement(By.id("small-searchterms")).clear();
			wd.findElement(By.id("small-searchterms")).sendKeys("Cooking");
			wd.findElement(By.cssSelector("input.button-1.search-box-button")).click();
	        //assertEquals("Cooking for Two More Than 200 Foolproof Recipes for Weeknights and Special Occasions (Hardcover) \n $27.00 $19.00", wd.findElement(By.cssSelector("div.product-item")).getText());
	        wd.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();		
	}
	
	@Test(priority=3,enabled= true, groups="B")
	void Logout() throws Exception
	{	
		   wd.findElement(By.linkText("Log out")).click();
		   assertEquals(wd.findElement(By.linkText("Log in")).getText(), "Log in");	
	}
	
@AfterClass
public static void teardown()  {
		 wd.close();
		 wd.quit();		 
}	 
 
}
