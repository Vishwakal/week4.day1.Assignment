package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts{

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//ALERT SIMPLE DIALOG
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//ALERT CONFIRMDIALOG
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button")).click();
		Alert alertCD = driver.switchTo().alert();
		alertCD.accept();
		//SWEETALERT SIMPLE DIALOG
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following-sibling::button")).click();
		driver.findElement(By.xpath("//div[@class='ui-dialog-footer ui-widget-content']//button")).click();
		//SWEET MODALDIALOG
		driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following-sibling::button")).click();
		driver.findElement(By.xpath("(//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all']/span)[2]")).click();
		//ALERT PROMPT DIALOG
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button")).click();
		Alert alertPD=driver.switchTo().alert();
		alert.sendKeys("Vishwakala");
		alert.accept();
		//SWEETALERT CONFIRMATION
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following-sibling::button")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		//min & max
		driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']/following-sibling::button")).click();
		driver.findElement(By.xpath("//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-minimize ui-corner-all']")).click();
		driver.findElement(By.xpath("//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-maximize ui-corner-all']")).click();
		driver.close();

		
		


	}

}
