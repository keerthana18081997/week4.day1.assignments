package Week4Assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
			public static void main(String[] args) throws InterruptedException, IOException {
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get( "https://dev113545.service-now.com/");
		    WebElement findElement = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement);
			driver.findElement(By.id("user_name")).sendKeys("admin");
            driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
			driver.findElement(By.id("sysverb_login")).click();
			driver.switchTo().parentFrame();
			Thread.sleep(4000);
			WebElement findElement3=driver.findElement(By.id("filter"));
			findElement3.sendKeys("Incidents");
			Thread.sleep(2000);
			findElement3.sendKeys(Keys.ENTER);
			WebElement findElement4 = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement4);
			driver.findElement(By.xpath("//span[@id='incident_breadcrumb']//b")).click();
			driver.findElement(By.xpath("//button[text()='New']")).click();
			driver.switchTo().parentFrame();
			WebElement findElement5 = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement5);
			String attribute = driver.findElement(By.id("incident.number")).getAttribute("value");
			System.out.println("Incident number:" +attribute);
			WebElement findElement6 = driver.findElement(By.id("sys_display.incident.caller_id"));
			findElement6.click();
			Thread.sleep(4000);
			findElement6.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(4000);
			findElement6.sendKeys(Keys.ENTER);
			driver.findElement(By.id("incident.short_description")).sendKeys("Created to check on new incident creation");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			driver.switchTo().parentFrame();
			WebElement findElement7 = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement7);
			driver.findElement(By.xpath("(//label[text()='Search'])/following::input")).sendKeys(attribute+Keys.ENTER);
			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File file = new File("./snaps/incident.png");
			FileUtils.copyFile(screenshotAs, file);		
			
		}
	}


