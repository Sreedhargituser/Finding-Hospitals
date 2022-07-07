package findinghospitals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




import common.*;
import connectors.*;
import elementmodules.*;
import outputs.HospitalsLists;

public class DiagnosticsCityList {
	
	public static WebDriver driver;
	public static List<String> cityLists = new ArrayList<String>();
	
	
	
	public static void setDriver(WebDriver dri) {
		driver = dri;
	}
	
	public static void startTest() throws InterruptedException {
		
		driver.get(DiagnosticsModule.URL);
		
		HospitalsLists.topCities = null;
		String[] cityXpaths = DiagnosticsModule.getCityXpaths();
		
		//div[@class='dg-inner-wrapper']
		
//		JavascriptExecutor jsx = (JavascriptExecutor) driver;
//		jsx.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='dg-inner-wrapper']")));
//		for(int i = 0; i<6; i++) {
//			String st = AllActions.returnTextByXpath(cityXpaths[i]);
//			HospitalsLists.topCities.add(st);
//			
//		}
		
		Thread.sleep(1400);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"u-margint--standard o-f-color--primary\"]"));
		ArrayList<WebElement> arList = new ArrayList(elements);
		for(int i = 0; i<6; i++) {
			String str = ((WebElement)arList.get(i)).getText();
//			HospitalsLists.topCities.add(str);
			cityLists.add(str);
			
		}
		
		
	}
		
}
