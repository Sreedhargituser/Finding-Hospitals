package common;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllActions {
	public static WebDriver driver;
	//Initializing the driver in AllActions class with the driver created previously
	public static void setDriver(WebDriver drv) {
		driver = drv;
	}
	//Navigating the driver to the required URL
	public static void navigateToURL(String URL) {
		driver.get(URL);
	}
	//finding and returning the element using Id
	public static WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}
	//finding and returning the element using class
	public static WebElement getElementByClass(String ClassName) {
		return driver.findElement(By.className(ClassName));
	}
	//finding and returning the element using xpath
	public static WebElement getElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	//Entering the text using Id of an element
	public static void enterTextById(String id, String text) {
		getElementById(id).sendKeys(text);;
	}
	//Entering the text using xpath of an element
	public static void enterTextByXpath(String xpath, String text) {
		getElementByXpath(xpath).sendKeys(text);
	}
	//clicking an element using the xpath of the element
	public static void clickElementByXpath(String xpath) {
		getElementByXpath(xpath).click();;	
	}
	//finding the Select element using the xpath and selecting the option using index
	public static void handleSelectByXpathIndex(String xpath, int index) {
		Select ele = new Select(getElementByXpath(xpath));
		ele.selectByIndex(index);
	}
	//finding the select element using the xpath and selecting the option
	public static void handleSelectByXpath(String xpath, String selectText) {
		Select ele = new Select(getElementByXpath(xpath));
		ele.selectByVisibleText(selectText);
	}
	
	//finding and returning the text in the element using xpath
		public static String returnTextByXpath(String xpath) {
			
			String str = driver.findElement(By.xpath(xpath)).getText();
			return str;
		}
		
		//finding and returning the text in the element using id
		public static String returnTextById(String id) {
			
			
			return driver.findElement(By.id(id)).getText();
		}
		
		//finding and returning the text in the element using class
		public static String returnTextByClass(String className) {
			
			
			return driver.findElement(By.className(className)).getText();
		}
		
		public static void clickElementByClassName(String className) {
				getElementByClass(className).click();
		}
	
		//finding the select element using the xpath and selecting the option
		public static void handleSelectById(String id, String selectText) {
			Select ele = new Select(getElementById(id));
			ele.selectByVisibleText(selectText);
		}

	
	
}
