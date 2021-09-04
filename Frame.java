package Week4Assignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {
	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 
		 WebElement findElement = driver.findElement(By.id("frame1"));
			driver.switchTo().frame(findElement);
			WebElement element=driver.findElement(By.xpath("//input[@type='text']"));
			element.sendKeys("HI");
			String a=element.getText();
			System.out.println("Topic==" +a);
			
			WebElement findElement1 = driver.findElement(By.id("frame3"));
			driver.switchTo().frame(findElement1);
			driver.findElement(By.id("a")).click();
			driver.switchTo().defaultContent();
			System.out.println("checkbox clicked");
			
			WebElement findElement2 = driver.findElement(By.id("frame2"));
			driver.switchTo().frame(findElement2);
			WebElement findElement3 = driver.findElement(By.id("animals"));
			Select findvalue= new Select(findElement3);
			findvalue.selectByValue("babycat");
			String b=findElement3.getText();
			System.out.println(b);
			
			driver.close();
	}
}
