package Base_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeo_HomepageTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver","C://Users//Admin//Desktop//General//WebDrivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		
		
		driver.quit();
		
		
	}
	
}
