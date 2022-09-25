package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver =new EdgeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement frame1 = driver
				.findElement(By.xpath("//h5[text() =' Click Me (Inside frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[@id = 'Click']")).click();
		String buttonText = driver.findElement(By.xpath("//button[@id = 'Click']")).getText();
		System.out.println("Current text from first button : " + buttonText);
		driver.switchTo().defaultContent();
		WebElement frame2 = driver
				.findElement(By.xpath("//h5[text() =' How many frames in this page?']/following-sibling::iframe"));
		driver.switchTo().frame(frame2);
		String buttonText2 = driver.findElement(By.xpath("//button[@id = 'Click']")).getText();
		System.out.println("button text from second frame : " + buttonText2);
		driver.switchTo().defaultContent();
		WebElement frame3 = driver
				.findElement(By.xpath("//h5[text() =' Click Me (Inside Nested frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame3);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id = 'Click']")).click();
		String buttonText3 = driver.findElement(By.xpath("//button[@id = 'Click']")).getText();
		System.out.println("Current text from third button : " + buttonText3);

	}

}
