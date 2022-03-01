package testcase;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NetflixLoginTest {

	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://localhost:5500/index.html"); // open URL

		// TEST 1 (NETFLIX CREDENTIALS LOGIN TESTS)

		WebElement nameField;
		
		WebElement passwordField;
		
        // Invalid cases
        int invalidTestCount = 6;
        String[] invalidTestUsernames = new String[invalidTestCount];
        String[] invalidTestPasswords = new String[invalidTestCount];
        // Usernames that will be tested
        invalidTestUsernames[0] = invalidTestUsernames[3] = "test@test.com";
        invalidTestUsernames[2] = invalidTestUsernames[4] = "";
        invalidTestUsernames[1] = invalidTestUsernames[5] = "wrongemail@email.com";
        // Passwords that will be tested
        invalidTestPasswords[1] = invalidTestPasswords[2] = "aaaa";
        invalidTestPasswords[3] = invalidTestPasswords[4] = "";
        invalidTestPasswords[0] = invalidTestPasswords[5] = "wrongpassword";
        
        for (int i = 0; i < invalidTestCount; i ++) {
        	
        	nameField = driver.findElement(By.id("inputEmail"));
        	passwordField = driver.findElement(By.id("inputPassword"));
        	
        	try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			System.out.println("Got interrupted.");
    		}
        	
    		if (!invalidTestUsernames[i].equals(""))
                nameField.sendKeys(invalidTestUsernames[i]);
            if (!invalidTestPasswords[i].equals(""))
    		    passwordField.sendKeys(invalidTestPasswords[i]);
    		    
    		driver.findElement(By.className("signin-button")).click();
    		
    		if (driver.getTitle().equals("Netflix")) {
    			System.out.println("Invalid input test succeeded.");
    		} else {
    			System.out.println("Invalid input test failed.");
    		}
    		
    		// Wait before trying next inputs
    		try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			System.out.println("Got interrupted.");
    		}
    		
    		//Refresh Page
    		driver.navigate().refresh();
    		
        }
        
        // Valid cases
        int validTestCount = 3;
        String[] validTestUsernames = new String[validTestCount];
        String[] validTestPasswords = new String[validTestCount];
        validTestUsernames[0]  = "test@test.com";
        validTestUsernames[1]  = "dogukanertunga@gmail.com";
        validTestUsernames[2]  = "123456789";
        validTestPasswords[0] = "aaaa";
        validTestPasswords[1] = "1234";
        validTestPasswords[2] = "qwe321";

		// Valid case 1
		for (int i = 0; i < validTestCount; i ++) {
		    
			nameField = driver.findElement(By.id("inputEmail"));
        	passwordField = driver.findElement(By.id("inputPassword"));
			
		    nameField.sendKeys(validTestUsernames[i]);

    		passwordField.sendKeys(validTestPasswords[i]);
    
    		driver.findElement(By.className("signin-button")).click();
    
    		if (driver.getTitle().equals("Netflix - HomePage")) {
    			System.out.println("Valid input test succeeded.");
    		} else {
    			System.out.println("Valid input test failed.");
    		}
    
    		// Wait before trying inputs
		    try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			System.out.println("Got interrupted.");
    		}
		    
    		driver.findElement(By.className("img-logo")).click();
    		
    		try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			System.out.println("Got interrupted.");
    		}
		}

		//close browser
		driver.close();
		driver.quit();
	}
}
