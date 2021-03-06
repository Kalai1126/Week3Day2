package week3.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//a[contains(@href,'ComboBox_partyIdFrom')]").click();
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(allWindows);
		
		driver.switchTo().window(listWindows.get(1));		
		driver.findElementByName("id").sendKeys("10336");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String Id = driver.findElementByXPath("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//a)[1]").getText();
		driver.findElementByXPath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a").click();
		
		driver.switchTo().window(listWindows.get(0));		
		driver.findElementByXPath("//a[contains(@href,'ComboBox_partyIdTo')]").click();
		Set<String> allWindows1 = driver.getWindowHandles();
		List<String> listWindows1 = new ArrayList<String>(allWindows1);

		driver.switchTo().window(listWindows1.get(1));
		driver.findElementByName("id").sendKeys("10339");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a").click();
		
		driver.switchTo().window(listWindows.get(0));		
		driver.findElementByLinkText("Merge").click();
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(Id);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		//driver.findElementByXPath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a").click();
		if(driver.findElementByXPath("//div[text()='No records to display']").getText().contains("No records to display")) {
			System.out.println("The "+Id+" Lead is deleted successfylly.");

	}
	}
}
