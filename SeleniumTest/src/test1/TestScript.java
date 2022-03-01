package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {

	public static void main(String[] args) {
		//Set the Path of Executable Browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();  //Parent p = new Child (WebDriver is parent and ChromeDriver is child)
		
		driver.get("file:///C:/Users/ULAS/Documents/GitHub/CS458-Project1/index.html");		//open URL
		System.out.println(driver.getTitle());	//print title

		//Locate a web element
		String className = "";
		className = driver.findElement(By.className("signin-button")).getText();
		System.out.println(className);
		
		//Login
		WebElement nameField = driver.findElement(By.id("inputEmail"));
		nameField.sendKeys("sarpkaya2000@gmail.com");
		
		WebElement passwordField = driver.findElement(By.id("inputPassword"));
		passwordField.sendKeys("sarp123");
		
		driver.findElement(By.className("signin-button")).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
		
		//close browser
		driver.close();
		driver.quit();
	}

}
