package findinghospitals;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common.AllActions;
import elementmodules.BookingModule;

public class BookingTest {
	public static WebDriver driver;
	
	
	public static void setDriver(WebDriver driv) {
		driver = driv;
	}
	
	public static void startTest() throws IOException {
		AllActions.navigateToURL(BookingModule.CorporateBookingUrl);
		AllActions.enterTextById(BookingModule.nameId, "1234");
		AllActions.enterTextById(BookingModule.organizationNameId, "abcd");
		AllActions.enterTextById(BookingModule.contactNummberId, "87665566778");
		AllActions.enterTextById(BookingModule.officialMailId, "shajahan@234gmail.com");
		AllActions.handleSelectById(BookingModule.organizationSizeId, "<500");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id(BookingModule.nameId)));
		try {
			driver.findElement(By.xpath(BookingModule.scheduleDemoButtonXpath));
			
			
		}catch(ElementNotInteractableException e) {
		
			e.printStackTrace();
			
		
		}
		finally {
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("test.png");
			
			copyFileUsingChannel(SrcFile, destFile);
		}
	}
	public static void copyFileUsingChannel(File source, File dest) throws IOException {
	    FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
	        sourceChannel = new FileInputStream(source).getChannel();
	        destChannel = new FileOutputStream(dest).getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	        
			System.out.println("The 'Schedule Demo' Button is not interactable when the data entered is invalid.\nThe Screenshot is taken and is in the project root");
	       }finally{
	           sourceChannel.close();
	           destChannel.close();
	   }
	}
}
