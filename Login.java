package rummycircle;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	
	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		try {
			openapplication();
			selectlanguage();
			login();
			createteam();
		} catch(Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
	
	}
	
	
	public static void openapplication() throws Exception
	{
		
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability("appiumVersion", "1.21.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "3c430635");
		cap.setCapability("app", "/Users/rashmi.h.a/Downloads/Dream11_base.apk");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appWaitForLaunch", "false");
		
		
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);  

		System.out.println("application started.....");
		
	}
	
	
	public static void selectlanguage()
	{
		driver.findElement(By.className("android.widget.Button")).click();
		System.out.println("language selected.....");
	}
	
	
	
	public static void login() throws Exception
	{
		
		System.out.println("on the login page.....");
		driver.findElement(By.id("com.dream11.fantasy.cricket.football.kabaddi:id/2131361960")).click();
		
		
	//clickable locater id
		WebElement element = driver.findElement(By.id("com.dream11.fantasy.cricket.football.kabaddi:id/2131363535"));
		element.sendKeys("6362222321");
		//Actions actions = new Actions(driver);
		//actions.moveToElement(element).sendKeys("6362222321").build().perform();
		
		

		
		
		
		driver.findElement(By.id("com.dream11.fantasy.cricket.football.kabaddi:id/2131362393")).click();
		driver.findElement(By.id("com.dream11.fantasy.cricket.football.kabaddi:id/2131361910"
)).click();
		

	   //open the message to get the otp
		
		//((AndroidDriver)driver).openNotifications();
		
		WebElement elemment=driver.findElement(By.id("com.google.android.gms:id/positive_button"));
		if(elemment.isDisplayed())
		{
			elemment.click();
		}else
		{
			
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElement(By.id("com.dream11.fantasy.cricket.football.kabaddi:id/2131365492")).click();
			driver.findElement(By.id("com.google.android.gms:id/positive_button")).click();
		}
	}
	
	
	public static void createteam()
	{
		WebElement elemment=driver.findElement(By.className("android.widget.TextView"));
		if(elemment.isDisplayed())
		{
			elemment.click();
		}else
		{
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		}
		//selecting cricket match
		driver.findElement(By.className("android.widget.TextView")).click();
		System.out.println("cricket match selected.....");
		
		driver.findElement(By.id("contest-home-create-team-button")).click();
		
		List<MobileElement> addplayers =driver.findElements(By.id("add-remove-player-button"));
		for(WebElement elem : addplayers){
		    elem.click();
		}
	}
	
	

}
