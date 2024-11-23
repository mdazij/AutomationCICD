package MyProject.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("email")).sendKeys("6295870487");
		driver.findElement(By.id("pass")).sendKeys("Sk@8768443858");
		driver.findElement(By.cssSelector("button[name='login']")).click();
		driver.findElement(By.cssSelector("div[aria-label='Messenger']")).click();
		driver.findElement(By.cssSelector("input[aria-label='Search Messenger']")).sendKeys("Moinul");
		driver.findElement(By.id("100013258325984")).click();
		WebElement msgtext = driver.findElement(By.cssSelector("div[aria-placeholder='Aa']"));
//		WebElement sendbtn = driver.findElement(By.cssSelector("div[aria-label='Press Enter to send']"));
		for(int i= 0; i<200; i++) {
			msgtext.sendKeys("Bhai Ganr mere ga6e lawra");
			driver.switchTo().activeElement().sendKeys(Keys.RETURN);
			
		}
		
	}
	
}
