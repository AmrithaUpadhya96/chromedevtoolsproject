package ChromeDevToolDemo.ChromiumDriver;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;
import org.openqa.selenium.devtools.v132.network.model.Request;
import org.openqa.selenium.devtools.v132.network.model.Response;


public class NetworkValidations {

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
		//check for events according to needs
		devtools.addListener(Network.responseReceived(), response->{
			 Response res=response.getResponse();
			 if(res.getStatus().toString().startsWith("4"))
			 {
			 System.out.println(res.getStatus());
			 }
		});
		devtools.addListener(Network.requestWillBeSent(), request->{
			Request req=request.getRequest();
			if(req.getUrl().contains("=shetty"))
			{
			System.out.println(req.getUrl());
			}
		});
       driver.get("https://rahulshettyacademy.com/angularAppdemo/");
       driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();
      
	}

}
