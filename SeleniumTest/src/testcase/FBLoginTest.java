package testcase;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLoginTest {

    public static WebDriver driver;

    private static void sleepFor(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
	}
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("http://localhost:5500/index.html"); // open URL

        // TEST 5 (FACEBOOK LOGIN)
        
        // Case 1 - User enters the wrong email-password combination for their FB account.
        
        // Store the current window handle
        String origWinHandle = driver.getWindowHandle();
        
        sleepFor(3000);
        
        // Perform the click operation that opens new window
        driver.findElement(By.className("fb_iframe_widget")).click();
        
        sleepFor(3000);
        
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // Perform the actions on new window
        driver.findElement(By.id("email")).sendKeys("sarpkaya2000@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("hohoho");
        driver.findElement(By.id("loginbutton")).click();
        
        sleepFor(3000);
        
        WebElement passwordWarning = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
        if ((passwordWarning != null)) {
        	System.out.println("Failed FB login attempt test successful.");
        } else {
        	System.out.println("Failed FB login attempt test unsuccessful.");
        }
        
        sleepFor(3000);
        
        // Close the FB login window and try again.
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(origWinHandle);
        driver.navigate().refresh();
        
        // Case 2 - User enters the correct email-password combination for their FB account.
        
        // Store the current window handle
        origWinHandle = driver.getWindowHandle();
        
        sleepFor(3000);
        
        // Perform the click operation that opens new window
        driver.findElement(By.className("fb_iframe_widget")).click();
        
        sleepFor(3000);
        
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // Perform the actions on new window
        driver.findElement(By.id("email")).sendKeys("sarpkaya2000@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Never/Forget73");
        driver.findElement(By.id("loginbutton")).click();
        
        sleepFor(3000);
        
        // Close the FB login window.
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(origWinHandle);
        
        //User will be able to login with their FB account from now on.
        driver.findElement(By.className("fb_iframe_widget")).click();
        
        sleepFor(3000);

        if (driver.getTitle().equals("Netflix - HomePage")) {
        	System.out.println("Successful FB login attempt test successful.");
		} else {
			System.out.println("Successful FB login attempt test unsuccessful.");
		}
        
        //close browser
        driver.close();
        driver.quit();
	}
	
}
