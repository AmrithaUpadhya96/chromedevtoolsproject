package ChromeDevToolDemo.ChromiumDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.fetch.Fetch;
import org.openqa.selenium.devtools.v132.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v132.network.model.ErrorReason;
import org.openqa.selenium.devtools.v132.fetch.model.RequestId;



public class NetworkRequestFailed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//create object of devTools to use CDP
		DevTools devtools=driver.getDevTools();
		//create session before using CPD commands
		devtools.createSession();
		Optional<List<RequestPattern>> pattern= Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		devtools.send(Fetch.enable(pattern, Optional.empty()));
		devtools.addListener(Fetch.requestPaused(), request->{
			devtools.send(Fetch.failRequest(request.getRequestId(),ErrorReason.FAILED));
			//System.out.println(request.getResponseErrorReason() + " " + request.getResponseStatusCode());
		});
		  driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	      driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();
		
	}

}
