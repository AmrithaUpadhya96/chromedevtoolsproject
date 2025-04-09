package ChromeDevToolDemo.ChromiumDriver;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.fetch.Fetch;

public class NetworkRequestMock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//create object of devTools to use CDP
		DevTools devtools=driver.getDevTools();
		//create session before using CPD commands
		devtools.createSession();
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request->
		{
			if(request.getRequest().getUrl().contains("AuthorName=shetty"))
			{
				String mockURL=request.getRequest().getUrl().replace("AuthorName=shetty", "AuthorName=BadGuy");
				System.out.println(mockURL);
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockURL), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),Optional.empty()));
			}
			else
			{
						devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),Optional.empty()));
			
			}
		});
		

	       driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	       driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();

	}
}
