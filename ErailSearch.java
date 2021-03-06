package week3.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("ms",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("mdu",Keys.TAB);
		driver.findElementById("chkSelectDateOnly").click();
		
		Thread.sleep(3000);

		//table[contains(@class,'DataTable TrainList')]
		
		List<WebElement> rows =  driver.findElementsByXPath("//table[contains(@class,'DataTable TrainList')]//tr");
		
		List<String> listTrainNames = new ArrayList<String>();
		
		for(int i=1; i<=rows.size();i++) {
			
			String trainName = driver.findElementByXPath("//table[contains(@class,'DataTable TrainList')]//tr["+i+"]//td[2]").getText();
			listTrainNames.add(trainName);
		}
		

		Set<String> SetTrainNames = new HashSet<String>(listTrainNames);

		if(listTrainNames.size()==SetTrainNames.size()) {
			System.out.println("No Duplicates in Train Name");
		}
		else System.out.println("Ther are duplicates in Train Name");
		/*for(WebElement eachTrainName : TrainName) {
			
			System.out.println(eachTrainName.getText());
		}*/

		
	}

}
