package Base_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage 
{
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	
	driver.manage().window().maximize();
	driver.get("https://www.fitpeo.com/");
	
	driver.navigate().to("https://www.fitpeo.com/revenue-calculator");
	Thread.sleep(2000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600);");
	

	//slider to 820 value
	WebElement slider = driver.findElement(By.xpath("//input[@type='range']")); 

	int targetValue = 820; 
	js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", slider,
			targetValue);
	Thread.sleep(2000);
	String sliderValue = slider.getAttribute("value");
	System.out.println("Current slider value: " + sliderValue);
	
	//Slider to 560 value 
	WebElement text_field= driver.findElement(By.cssSelector("input[id=':R57alklff9da:']"));
	text_field.clear();
	Thread.sleep(2000);
	text_field.sendKeys("5");
	Thread.sleep(2000);
	String sliderValue_updated = slider.getAttribute("value");
	System.out.println("Current slider value: " + sliderValue_updated);
	
	
	
	
	driver.quit();
}
	
}
