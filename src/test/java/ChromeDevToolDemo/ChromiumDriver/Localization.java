package ChromeDevToolDemo.ChromiumDriver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Localization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
       DevTools devtools= driver.getDevTools();       
       devtools.createSession();
       Map<String,Object> location=new HashMap<String,Object>();
       location.put("latitude", 40);
       location.put("longitude", 3);
       location.put("accuracy", 1);
       driver.executeCdpCommand("Emulation.setGeolocationOverride", location);
       driver.get("https://www.google.com/");
       driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("amazon prime"+Keys.ENTER);
       Thread.sleep(3000);
       driver.findElements(By.cssSelector(".LC20lb")).get(1).click();
       
        
        
	}

}
