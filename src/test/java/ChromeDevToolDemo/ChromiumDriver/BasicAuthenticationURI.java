package ChromeDevToolDemo.ChromiumDriver;



import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthenticationURI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
	    Predicate<URI> uripredicate = URI -> URI.getHost().contains("httpbin.org");
	    
		((HasAuthentication)driver).register(uripredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
		//----------- OR below works too
		 //username password window pop up handling:
		 //http://Username:Password@SiteURL
		//driver.get("https://foo:bar@httpbin.org/basic-auth/foo/bar");

		System.out.println("new line added after initial comit by first person-chromiumdriver");
	}

}
