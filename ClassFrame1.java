package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassFrame1 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver =new EdgeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input")).sendKeys("Animals");
		driver.switchTo().defaultContent();
//		driver.switchTo().frame("frame3");
//		driver.findElement(By.xpath("//input[@type='checkbox']")).click();	
//		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");
     	WebElement animals = driver.findElement(By.className("col-lg-3"));
		Select dropdown = new Select(animals);
		dropdown.selectByVisibleText("Baby Cat");
	}

}
