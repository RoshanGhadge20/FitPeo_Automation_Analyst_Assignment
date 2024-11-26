package Base_Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.j2objc.annotations.LoopTranslation.LoopStyle;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal;

public class Homepage {
	public static void main(String[] args) throws InterruptedException {

		// Setting up webdriver manager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// with the help of driver maximizing window & opening URL
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");

		driver.navigate().to("https://www.fitpeo.com/revenue-calculator");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);");

		// slider to 820 value
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

		int targetValue = 820;
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", slider,
				targetValue);
		Thread.sleep(2000);
		String sliderValue = slider.getAttribute("value");
		System.out.println("Current slider value: " + sliderValue);

		// Slider to 560 value
		WebElement text_field = driver.findElement(By.cssSelector("input[id=':R57alklff9da:']"));
		text_field.clear();
		Thread.sleep(2000);
		text_field.sendKeys("5");
		Thread.sleep(2000);
		String sliderValue_updated = slider.getAttribute("value");
		System.out.println("Current slider value: " + sliderValue_updated);

		// Selecting CPT Codes :- CPT-99091, CPT-99453, CPT-99454, and CPT-99474
		ArrayList<String> CPT_Code = new ArrayList<String>();
		CPT_Code.add("CPT-99091");
		CPT_Code.add("CPT-99453");
		CPT_Code.add("CPT-99454");
		CPT_Code.add("CPT-99474");

		List<WebElement> CPT_CodeElement = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[2]/div"));

		int count = 0;
		for (WebElement cards : CPT_CodeElement) {
			WebElement card_number = cards.findElement(By.xpath(".//p[1]"));
			String cardNumberText = card_number.getText();
			// System.out.println("Card_Number: " + cardNumberText);

			// Check if the card number exists in the array list
			if (CPT_Code.contains(cardNumberText)) {
				WebElement card_checkbox = cards.findElement(By.xpath(".//label/span[2]"));
				card_checkbox.click();
				String card_checkbox_value = card_checkbox.getText();
				count++;

			}
			System.out.println("Loop Iterate through " + count + "times");
		}

		WebElement total_reimbursment_element = driver
				.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/p[4]/p"));
		String total_reimbursment = total_reimbursment_element.getText();
		// int total_reim= Integer.parseInt(total_reimbursment_text);
		System.out.println("Total Reimbursment :- " + total_reimbursment);
		if (total_reimbursment.contains("$110700")) {
			System.out.println("Total Reimbursment Value is as expected");
		} else {

			System.out.println("Total Reimbursment Value is not correct");
		}

		// Closing driver object
		driver.quit();
	}

}
