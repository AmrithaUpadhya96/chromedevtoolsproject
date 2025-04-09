package ChromeDevToolDemo.ChromiumDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.emulation.Emulation;

public class EmulationofdifferentDevice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      //--------- using send method to send(readily available CDP command) to selenium which interprets and sends to CDP devtools which then mimics browser behaviour under test
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//create object of devTools to use CDP
		DevTools devtools=driver.getDevTools();
		//create session before using CPD commands
		devtools.createSession();
		//run commands needed
		devtools.send(Emulation.setDeviceMetricsOverride(400,800,50,true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		//login to app
		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(2000);
		//after last line of code executed, screen resolution will go back to normal
		
		
		//-------- same can also be done using ExecuteCDPCommand(send command and customized parameters) to send directly to CDP devTools 
//		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//		ChromeDriver driver=new ChromeDriver();
//		DevTools devtools=driver.getDevTools();
//		devtools.createSession();
//		Map<String,Object> parameters=new HashMap<String,Object>();
//		parameters.put("width", 600);
//		parameters.put("height", 1000);
//		parameters.put("deviceScaleFactor", 50);
//		parameters.put("mobile", true);
//		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", parameters);
//		//login to app
//		driver.get("https://the-internet.herokuapp.com/");
//		Thread.sleep(2000);
		
	}

}
