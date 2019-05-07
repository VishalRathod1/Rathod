import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class Wait1 {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "E:\\16122018\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
	
	driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	WebElement element=wait.until(new Function<WebDriver,WebElement>() {

		@Override
		public WebElement apply(WebDriver arg0) {
			WebElement msgElement=driver.findElement(By.xpath("//p[@id='demo']"));

			//WebElement msgElement=driver.findElement(By.xpath("//p[@id='demo'][.='Software Testing Material - DEMO PAGE']"));
			String msgtext=msgElement.getText();
			if(msgtext.equalsIgnoreCase("Software Testing Material - DEMO PAGE")){
				System.out.println(msgtext);
				return msgElement;
			}
			else{
				System.out.println("Fluent wait is failed");
				return null;
			}
			//return null;
		}
		
	});

}
}
