package Base_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeo_HomepageTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();

		WebElement revenueCalButton = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		revenueCalButton.click();
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		

		//slider to 820 value
		WebElement slider = driver.findElement(By.cssSelector("input[type='range']")); // Replace selector if needed

		int targetValue = 820; 
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", slider,
				targetValue);
		String sliderValue = slider.getAttribute("value");
		System.out.println("Current slider value: " + sliderValue);

		if (sliderValue.equalsIgnoreCase("820")) 
		{
			assert sliderValue.equals(String.valueOf(targetValue)) : "Slider value mismatch. Expected: " + targetValue;
			System.out.println("Slider Values Matches");
		}
		else {
			System.out.println("Slider Value Doesn't Match as expected");
		}
		
		
		
		driver.quit();

	}
}
