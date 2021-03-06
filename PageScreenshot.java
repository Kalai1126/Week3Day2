package week3.Day2;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		File source = driver.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String strDate = date.toString();
		System.out.println("");
		String newStr = strDate.replaceAll(":", "");
		File target = new File("./snaps/window_"+newStr+".png");
		FileUtils.copyFile(source, target);

		
	}

}
