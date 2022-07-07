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

public class FilterHospitals {
	public static WebDriver driver;
	public static List<String> hospitalList = new ArrayList<String>();

	//starts the automation of hospitals search page
	public static void startTesting(WebDriver div) throws Exception {
		//assigning the driver created in main
		driver = div;

		// finding and clicking onthe All Filters option to open other filter options
		AllActions.setDriver(driver);
		
		// HospitalFilterModule and openning the URL in browser
		AllActions.navigateToURL(HospitalFilterModule.URL);

		// maximizing the window size
		driver.manage().window().maximize();

		// finding and clicking on the 24x7 filter
		AllActions.clickElementByXpath(HospitalFilterModule.xpath24x7);
		
		//pausing the execution to let the webelements load
		Thread.sleep(2000);
		
		
		//find and click the all filters option
		AllActions.clickElementByXpath(HospitalFilterModule.xpathAllFilters);
		
		Thread.sleep(2000);
		
		//find and check the "Has Parking" option
		AllActions.clickElementByXpath(HospitalFilterModule.xpathHasParking);
		
		HospitalsLists.hospitals = null;
		int n = 20;
		
		
		String []ratingXpaths = HospitalFilterModule.getXpathsOfRatings(n);
		String []nameXpaths = HospitalFilterModule.getXpathsOfNames(n);
		
		Thread.sleep(6000);
		for(int i = 0; i<n-1; i++) {
			String ratingText = AllActions.returnTextByXpath(ratingXpaths[i]);
			double num = Double.parseDouble(ratingText);
			

			if(num > 3.5) {
				String str = AllActions.returnTextByXpath(nameXpaths[i]);
//				HospitalsLists.hospitals.add(str);
				hospitalList.add(str);
			}
			if((i+1) % 10 == 0) {
				
				JavascriptExecutor jsx = (JavascriptExecutor) driver;
				jsx.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(nameXpaths[i])));
				Thread.sleep(1500);
			}
		}
		
	}
}
