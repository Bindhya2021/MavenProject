package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suite1 {

	@Test (priority =1, enabled = false)
	public void register() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://magento.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).sendKeys("Kayra");
		driver.findElement(By.id("lastname")).click();
		driver.findElement(By.id("lastname")).sendKeys("Kapoor");
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("bindhyakdass@gmail.com");
		
		Select cp = new Select(driver.findElement(By.id("company_type")));
		cp.selectByIndex(1);
		
		Select role = new Select(driver.findElement(By.id("individual_role")));
		role.selectByValue("technical/developer");
		
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("Christmas Island");
		
		
		
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("abc@123");
		driver.findElement(By.id("password-confirmation")).click();
		driver.findElement(By.id("password-confirmation")).sendKeys("abc@123");
		
		
		driver.findElement(By.id("agree_terms")).click();
		
		if (!driver.findElement(By.id("agree_terms")).isSelected()) {
			driver.findElement(By.id("agree_terms")).click();
		}
		driver.close();	
		
			}
	@Test(priority =2)
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		WebDriver d = new ChromeDriver();
		d.get("http://magento.com");
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		d.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("bindhyakdass@gmail.com");;
		d.findElement(By.id("pass")).sendKeys("abc@123");
		d.findElement(By.name("send")).click();
		
		Thread.sleep(5000); // stops the code for 5 secs
		
		String  result = d.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		System.out.println(result); 
		
				
		if (result == "Invalid login or password.") {
			
			System.out.println("test passed");
			
		} else
		{
			System.out.println("test failed");
		}
				
		d.quit();

	}
	
}
