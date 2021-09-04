package Week4Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground {
public static void main(String[] args) throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://leafground.com/pages/frame.html");
	 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	 
	 WebElement findElement = driver.findElement(By.xpath("(//div[@id='wrapframe'])/iframe"));
		driver.switchTo().frame(findElement);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		//
		WebElement findElement2 = driver.findElement(By.xpath("(//div[@id='wrapframe'])[2]/iframe"));
		driver.switchTo().frame(findElement2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();
		//
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of frames==" +findElements.size());
		
		Thread.sleep(3000);
		driver.close();
}
}
