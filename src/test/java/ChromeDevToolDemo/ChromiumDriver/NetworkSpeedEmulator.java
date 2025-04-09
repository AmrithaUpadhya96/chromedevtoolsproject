package ChromeDevToolDemo.ChromiumDriver;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;
import org.openqa.selenium.devtools.v132.network.model.ConnectionType;
import org.openqa.selenium.devtools.v132.network.model.Request;
import org.openqa.selenium.devtools.v132.network.model.Response;


import io.github.bonigarcia.wdm.WebDriverManager;



public class NetworkSpeedEmulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//create object of devTools to use CDP
		DevTools devtools=driver.getDevTools();
		//create session before using CPD commands
		devtools.createSession();
		//run commands needed enable network first
		devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		devtools.send(Network.emulateNetworkConditions(false, 3000, 50000, 100000, Optional.of(ConnectionType.CELLULAR2G), Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		 Long starttime=System.currentTimeMillis();
		 System.out.println(starttime);
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 //Thread.sleep(5000);
	     driver.findElement(By.linkText("Browse Products")).click();
	     driver.findElement(By.linkText("Selenium")).click();
	     driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	     driver.findElement(By.linkText("Cart")).click();
	     driver.findElement(By.id("exampleInputEmail1")).clear();
	     driver.findElement(By.id("exampleInputEmail1")).sendKeys("3");
	     System.out.println(System.currentTimeMillis() - starttime);
	}

}
