package Main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import common.DriverConnector;
import findinghospitals.BookingTest;
import findinghospitals.DiagnosticsCityList;
import findinghospitals.FilterHospitals;
import outputs.HospitalsLists;

public class MainTest {
	public static WebDriver driver;

	@BeforeClass // Creating a driver and opening the link
	public void createDrvier() throws Exception {
		driver = DriverConnector.getDriver("chrome");

	}

	@Test(priority = 0) // filtering the hospitlas and saving their names in a list
	public void getHospitalList() throws Exception {
		FilterHospitals.startTesting(driver);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1) // getting the list of top cities in diagnostics page
	public void getCityList() throws InterruptedException {
		DiagnosticsCityList.setDriver(driver);

		DiagnosticsCityList.startTest();
	}
	@Test (priority = 2) //corporate booking test using invalid details
	public void corporateBooking() throws IOException {
		BookingTest.setDriver(driver);
		BookingTest.startTest();
		HospitalsLists.setLists(DiagnosticsCityList.cityLists, FilterHospitals.hospitalList);
		
		System.out.println("***********************Hospitals List********************");
		
		HospitalsLists.printList(HospitalsLists.hospitals);
		System.out.println("**********************************************************\n");
		
		System.out.println("***********************Top Cities List********************");
		
		HospitalsLists.printList(HospitalsLists.topCities);
		
		System.out.println("*************************************************************");
		
		
	}
	@AfterClass //closing the driver
	public void closeDriver() {
		driver.close();
	}

}
