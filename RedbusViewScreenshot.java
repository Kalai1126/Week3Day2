package week3.Day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RedbusViewScreenshot {
	
	public static void main(String[] args) throws InterruptedException,IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.manage().window().maximize();
		driver.findElementByXPath("//input[@data-message='Please enter a source city']").sendKeys("Koyambedu, Chennai");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@data-message='Please enter a source city']").sendKeys(Keys.TAB);
		driver.findElementByXPath("//input[@data-message='Please enter a destination city']").sendKeys("Madurai (All Locations)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@data-message='Please enter a source city']").sendKeys(Keys.TAB);
		driver.findElementById("onward_cal").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//table[contains(@class,'rb-monthTable')]//tr/td[@class='current day']/following::td)").click();
		driver.findElementByXPath("//button[text()='Search Buses']").click();
		Thread.sleep(3000);
		String noOfBusesText = driver.findElementByXPath("(//span[@class='f-bold'])[1]").getText();
		String noOfBuses = noOfBusesText.replaceAll("[a-zA-Z]", "");
		System.out.println("The no: of Buses available for the search is: "+noOfBuses);
		
		List<WebElement> TravelsList = driver.findElementsByXPath("//div[contains(@Class,'travels')]");
		int Listlen = TravelsList.size();
		ArrayList<String> TravelsLists = new ArrayList<String>();
		for(int i = 0; i<Listlen;i++) {
			String TravelName = TravelsList.get(i).getText();
			TravelsLists.add(TravelName);
			}
		Set<String> UniqTravels = new LinkedHashSet<String>(TravelsLists);
		System.out.println("The Unique Travel Names are as follows:");
		for(String EachUniqTravels :UniqTravels ) {
			System.out.println(EachUniqTravels);
		}
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElementByXPath("(//div[text()='View Seats'])[1]"));
		
		//Frame code
		Thread.sleep(3000);
		  int size = driver.findElements(By.tagName("iframe")).size();
		 System.out.println(size);
		 if(driver.findElementById("restStopIframe").isDisplayed())System.out.println("The frame is captured");
		driver.switchTo().frame(driver.findElement(By.id("restStopIframe")));
		Thread.sleep(3000);
		driver.navigate().back();
		//driver.findElementByXPath("//div[@class='modalClose']//i[1]").click();
		//driver.switchTo().defaultContent();
		
		//Screenshot code
		Thread.sleep(3000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String strDate = date.toString();
		System.out.println("");
		String newStr = strDate.replaceAll(":", "");
		File target = new File("./snaps/RedbusSeats_"+newStr+".png");
		FileUtils.copyFile(source, target);

	}

}
 