package ChromeDevToolDemo.ChromiumDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;

public class BlockImagesandCss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//create object of devTools to use CDP
		DevTools devtools=driver.getDevTools();
		//create session before using CPD commands
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		List<String> urls=new ArrayList<String>();
		urls.add("*.jpg");
		urls.add("*.css");
		devtools.send(Network.setBlockedURLs(urls));
		Long starttime=System.currentTimeMillis();
		System.out.println(starttime);
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 //Thread.sleep(5000);
	     driver.findElement(By.linkText("Browse Products")).click();
	     driver.findElement(By.linkText("Selenium")).click();
	     driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	     System.out.println(System.currentTimeMillis()-starttime);
	}

}
