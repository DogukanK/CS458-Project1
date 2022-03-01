package testcase;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidInputTest {

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

		// TEST 3 (VALID/INVALID INPUT WARNINGS TEST)

		WebElement nameField;
		
		WebElement passwordField;
		
		Actions clicker = new Actions(driver); 
		
        // Invalid cases
        int invalidTestCount = 3;
        String[] invalidUsernames = new String[invalidTestCount];
        String[] invalidPasswords = new String[invalidTestCount];
        
        invalidUsernames[0] = "Meatloaf";
        invalidUsernames[1] = "458";
        invalidUsernames[2] = "xx_leeroy_420_xx";
        
        invalidPasswords[0] = "123";
        invalidPasswords[1] = "abc";
        invalidPasswords[2] = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        //Valid cases
        int validTestCount = 3;
        String[] validUsernames = new String[validTestCount];
        String[] validPasswords = new String[validTestCount];

        validUsernames[0] = "test@test.com";
        validUsernames[1] = "sarpkaya2000@gmail.com";
        validUsernames[2] = "kerembercin@gmail.com";

        validPasswords[0] = "cs458";
        validPasswords[1] = "uncleBen16";
        validPasswords[2] = "sir_almond12";
        
        // Invalid input tests
        for (int i = 0; i < invalidTestCount; i ++) {
        	
        	nameField = driver.findElement(By.id("inputEmail"));
        	passwordField = driver.findElement(By.id("inputPassword"));
        	
        	if ( i % 2 == 0) {
            	nameField.sendKeys(invalidUsernames[i]);
            	
            	sleepFor(1000);
            	
            	clicker.moveToElement(nameField, 500, 250).click().build().perform();
            	if (driver.findElement(By.xpath("//div[@id='warningEmail' and @style='display: block;']")) != null) {
            		System.out.println("Email warning succeeded.");
            	} else {
            		System.out.println("Email warning failed.");
            	}
            	
            	sleepFor(1000);
            	
            	passwordField.sendKeys(invalidPasswords[i]);
            	
            	sleepFor(1000);
            	
            	clicker.moveToElement(passwordField, 500, 250).click().build().perform();
            	if (driver.findElement(By.xpath("//div[@id='warningPassword' and @style='display: block;']")) != null) {
            		System.out.println("Password warning succeeded.");
            	} else {
            		System.out.println("Password warning failed.");
            	}
            	
        	} else {
        		sleepFor(1000);

        		passwordField.sendKeys(invalidPasswords[i]);

        		sleepFor(1000);

        		clicker.moveToElement(passwordField, 500, 250).click().build().perform();
        		if (driver.findElement(By.xpath("//div[@id='warningPassword' and @style='display: block;']")) != null) {
        			System.out.println("Password warning succeeded.");
        		} else {
        			System.out.println("Password warning failed.");
        		}
        		
        		sleepFor(1000);
            	
        		nameField.sendKeys(invalidUsernames[i]);
        		
        		sleepFor(1000);
        		
            	clicker.moveToElement(nameField, 500, 250).click().build().perform();
            	if (driver.findElement(By.xpath("//div[@id='warningEmail' and @style='display: block;']")) != null) {
            		System.out.println("Email warning succeeded.");
            	} else {
            		System.out.println("Email warning failed.");
            	}
            	
        	}
    		
        	sleepFor(1000);
        	
    		//Refresh Page
    		driver.navigate().refresh();
    		
    		sleepFor(1000);
        }
        
        // Valid input tests
        for (int i = 0; i < validTestCount; i ++) {
        	
        	nameField = driver.findElement(By.id("inputEmail"));
        	passwordField = driver.findElement(By.id("inputPassword"));
        	
        	if ( i % 2 == 0) {
            	nameField.sendKeys(validUsernames[i]);
            	
            	sleepFor(1000);
            	
            	clicker.moveToElement(nameField, 500, 250).click().build().perform();
            	if (driver.findElement(By.xpath("//div[@id='warningEmail' and @style='display: none;']")) != null) {
            		System.out.println("Valid email succeeded.");
            	} else {
            		System.out.println("Valid email failed.");
            	}
            	
            	sleepFor(1000);
            	
            	passwordField.sendKeys(validPasswords[i]);
            	
            	sleepFor(1000);
            	
            	clicker.moveToElement(passwordField, 500, 250).click().build().perform();
            	if (driver.findElement(By.xpath("//div[@id='warningPassword' and @style='display: none;']")) != null ) {
            		System.out.println("Valid password succeeded.");
            	} else {
            		System.out.println("Valid email failed.");
            	}
            	
        	} else {
        		sleepFor(1000);

        		passwordField.sendKeys(validPasswords[i]);

        		sleepFor(1000);

        		clicker.moveToElement(passwordField, 500, 250).click().build().perform();
        		if (driver.findElement(By.xpath("//div[@id='warningPassword' and @style='display: none;']")) != null) {
        			System.out.println("Valid password succeeded.");
        		} else {
        			System.out.println("Valid password failed.");
        		}
        		
        		sleepFor(1000);
            	
        		nameField.sendKeys(validUsernames[i]);
        		
        		sleepFor(1000);
        		
            	clicker.moveToElement(nameField, 500, 250).click().build().perform();
            	if (driver.findElement(By.xpath("//div[@id='warningEmail' and @style='display: none;']")) != null) {
            		System.out.println("Valid email succeeded.");
            	} else {
            		System.out.println("Valid email failed.");
            	}
            	
        	}
    		
        	sleepFor(1000);
        	
    		//Refresh Page
    		driver.navigate().refresh();
    		
    		sleepFor(1000);
        }
        
      //close browser
      driver.close();
      driver.quit();
	}
}