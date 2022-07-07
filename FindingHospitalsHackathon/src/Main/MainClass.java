package Main;

import java.util.List;

import org.openqa.selenium.WebDriver;


//importing all the custom packages 
import common.*;
import connectors.*;
import elementmodules.*;
import findinghospitals.*;
import outputs.HospitalsLists;
public class MainClass {
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		//creating the driver using the class DriverConnector
		driver = DriverConnector.getDriver("edge");
		
		FilterHospitals.startTesting(driver);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		DiagnosticsCityList.setDriver(driver);
		
		DiagnosticsCityList.startTest();
		
//		
//		String parentHandle = driver.getWindowHandle();
//		List<String> handles = (List<String>) driver.getWindowHandles();
//		String childHandle = null;
//		for(String hand : handles) {
//			if(!parentHandle.equals(hand)) {
//				childHandle = hand;
//			}
//		}
		
//		driver.switchTo().window(childHandle);
		
		
		BookingTest.setDriver(driver);
		BookingTest.startTest();
		HospitalsLists.setLists(DiagnosticsCityList.cityLists, FilterHospitals.hospitalList);
		
		System.out.println("***********************Hospitals List********************");
		
		HospitalsLists.printList(HospitalsLists.hospitals);
		System.out.println("**********************************************************\n");
		
		System.out.println("***********************Top Cities List********************");
		
		HospitalsLists.printList(HospitalsLists.topCities);
		
		System.out.println("*************************************************************");
		
		
		
		
		driver.close();
		
	}
	
}
