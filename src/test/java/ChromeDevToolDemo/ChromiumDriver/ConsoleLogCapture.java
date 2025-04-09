package ChromeDevToolDemo.ChromiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class ConsoleLogCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 //Thread.sleep(5000);
	     driver.findElement(By.linkText("Browse Products")).click();
	     driver.findElement(By.linkText("Selenium")).click();
	     driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	     driver.findElement(By.linkText("Cart")).click();
	     driver.findElement(By.id("exampleInputEmail1")).clear();
	     driver.findElement(By.id("exampleInputEmail1")).sendKeys("3");
	     
	    LogEntries logs=driver.manage().logs().get(LogType.BROWSER);
	    List<LogEntry> loglist= logs.getAll();
	    loglist.stream().forEach(s->System.out.println(s));
	    
	     
		
	
	
	
	
	}

}
