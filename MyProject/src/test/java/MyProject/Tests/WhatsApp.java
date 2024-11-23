package MyProject.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WhatsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/YourUsername/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Chats']")));
		driver.findElement(By.cssSelector("div[aria-label='Chats']")).click();
		driver.findElement(By.cssSelector("._ah_-")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("._ah_-")),"Afruja").build().perform();

	}

}
// new comment added for CI/CD interrogation success.