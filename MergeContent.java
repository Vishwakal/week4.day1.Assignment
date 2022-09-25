package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContent {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver =new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
        driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
        driver.findElement(By.linkText("Contacts")).click();
        //Click on Merge Contacts using Xpath Locator
        driver.findElement(By.xpath("//div[@class='contentarea']//a[text()='Merge Contacts']")).click();
        //Click on Widget of From Contact
       driver.findElement(By.xpath("//table[@class ='twoColumnForm']//a")).click();
       
       Set<String> WH = driver.getWindowHandles();
       List<String> LS = new ArrayList<String>(WH);
       //switching to window
       driver.switchTo().window(LS.get(1));
	   driver.manage().window().maximize();
	   driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
	 
	   //switching back to parent window
	   driver.switchTo().window(LS.get(0));
	   driver.findElement(By.xpath("(//table[@class ='twoColumnForm']//a)[2]")).click();
	   Set<String> SWH = driver.getWindowHandles();
       List<String> LWS = new ArrayList<String>(SWH);
       //switching to window
       driver.switchTo().window(LWS.get(1));
       driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
       //Switching back to parent window
       driver.switchTo().window(LS.get(0));
	
	   //Click on Merge button using Xpath Locator
       
       driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
       //Switching to alert
       Alert alert=driver.switchTo().alert();
       alert.accept();
       //Verify the title of the page
       String Title=driver.getTitle();
       System.out.println(Title);
	   

    		   
       
        //
//        driver.findElement(By.id("widget_ComboBox_partyIdTo")).click();		

	}

}
