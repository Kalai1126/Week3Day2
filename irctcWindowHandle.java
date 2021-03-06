package week3.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctcWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();

		driver.findElementByXPath("//button[@type='submit']").click();
		driver.findElementByXPath("//div[@class='h_menu_drop_button hidden-xs']//i[1]").click();
		driver.findElementByXPath("//label[text()='FLIGHTS']").click();

		Set<String> allWindows = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(allWindows);
		driver.switchTo().window(listWindows.get(1));
		
		String CustomerContact = driver.findElementByXPath("//a[@href='mailto:flights@irctc.co.in']").getText();
		System.out.println(CustomerContact);
		driver.switchTo().window(listWindows.get(0));

		driver.close();
	}

}
