package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCases {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); (DEPRECATED)
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); (DEPRECATED)
		driver.navigate().to("file:///C:/Users/ULAS/Documents/GitHub/CS458-Project1/index.html");		//open URL
		//driver.manage().window().maximize();
		
		//TEST 1 (VALID/INVALID INPUT NAVIGATION)
		
		WebElement nameField = driver.findElement(By.id("inputEmail"));
		WebElement passwordField = driver.findElement(By.id("inputPassword"));
		
		//Invalid case 1 (wrong combination)
		nameField.sendKeys("sarpkaya2000@gmail.com");
				
		passwordField.sendKeys("kerem123");
				
		driver.findElement(By.className("signin-button")).click();
		
		if (driver.getTitle().equals("Netflix")) {
			System.out.println("Invalid input test succeeded.");
		}
		else {
			System.out.println("Invalid input test failed.");
		}
		
		//Wait before retrying inputs
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
		
		//Invalid case 2 (wrong combination)
		nameField.sendKeys("kerembercin@gmail.com");
				
		passwordField.sendKeys("sarp123");
				
		driver.findElement(By.className("signin-button")).click();
		
		if (driver.getTitle().equals("Netflix")) {
			System.out.println("Invalid input test succeeded.");
		}
		else {
			System.out.println("Invalid input test failed.");
		}
		
		//Wait before retrying inputs
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
		
		//Invalid case 3 (empty name field)
						
		passwordField.sendKeys("sarp123");
						
		driver.findElement(By.className("signin-button")).click();
				
		if (driver.getTitle().equals("Netflix")) {
			System.out.println("Invalid input test succeeded.");
		}
		else {
			System.out.println("Invalid input test failed.");
		}
				
		//Wait before retrying inputs
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
		
		//Invalid case 4 (empty password field)
		
		nameField.sendKeys("kerembercin@gmail.com");
								
		driver.findElement(By.className("signin-button")).click();
						
		if (driver.getTitle().equals("Netflix")) {
			System.out.println("Invalid input test succeeded.");
		}
		else {
			System.out.println("Invalid input test failed.");
		}
						
		//Wait before retrying inputs
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
		
		//Valid
		nameField.sendKeys("sarpkaya2000@gmail.com");
		
		passwordField.sendKeys("sarp123");
				
		driver.findElement(By.className("signin-button")).click();
		
		/* (EÐER YENÝ CHROME TABINDA AÇARSAK SUCCESSFUL LOGIN EKRANINI)
		java.util.Set<String> handles = driver.getWindowHandles();
		String windowHandle1 = driver.getWindowHandle();
		handles.remove(windowHandle1);
		//create handle for new tab
		String windowHandle = handles.iterator().next();
		String windowHandle2 = " ";
		if (windowHandle != windowHandle1) {
			//Switch control to new tab
			windowHandle2 = windowHandle;
			driver.switchTo().window(windowHandle2);
			//System.out.println(windowHandle2);
		}
		*/
		
		if (driver.getTitle().equals("LoginSuccess")) {
			System.out.println("Valid input test succeeded.");
		}
		else {
			System.out.println("Valid input test failed.");
		}
			
		/* BEKLETMEK ÝÇÝN
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
		*/
	}

}
