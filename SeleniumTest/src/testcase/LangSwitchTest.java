package testcase;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class LangSwitchTest {

    public static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("http://localhost:5500/index.html"); // open URL
        
        // TEST 4 (LANGUAGE SWITCHING)
        
        String loginTitleTR = "Oturum Aç";
        String rememberMeTextTR = "Beni hatýrla";
        String privacyTextTR = "Gizlilik";
        String needHelpTextTR = "Yardým ister misiniz?";
        
        String loginTitleEN = "Sign In";
        String rememberMeTextEN = "Remember me";
        String privacyTextEN = "Privacy";
        String needHelpTextEN = "Need help?"; 
        
        //case 1: Check for Turkish Elements
        if ( loginTitleTR.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > h1")).getText()) ) {
        	System.out.println("Turkish login title correct, test succeeded.");
        } else {
        	System.out.println("Turkish login title incorrect, test failed.");
        }
        
        if ( rememberMeTextTR.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > div.remember-flex > div:nth-child(1) > label")).getText()) ) {
        	System.out.println("Turkish Remember Me text correct, test succeeded.");
        } else {
        	System.out.println("Turkish Remember Me text incorrect, test failed.");
        }
        
        if ( privacyTextTR.equals(driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(2) > ul > li:nth-child(4) > a")).getText()) ) {
        	System.out.println("Turkish Privacy text correct, test succeeded.");
        } else {
        	System.out.println("Turkish Privacy text incorrect, test failed.");
        }
        
        if ( needHelpTextTR.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > div.remember-flex > div.help > a")).getText()) ) {
        	System.out.println("Turkish login title correct, test succeeded.");
        } else {
        	System.out.println("Turkish login title incorrect, test failed.");
        }
        
        //case 2: Check switching to English from Turkish
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(3) > select")).click();
        
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
        
        driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(3) > select > option:nth-child(2)")).click();
        
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
        
        if ( loginTitleEN.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > h1")).getText()) ) {
        	System.out.println("English login title correct, test succeeded.");
        } else {
        	System.out.println("English login title incorrect, test failed.");
        }
        
        if ( rememberMeTextEN.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > div.remember-flex > div:nth-child(1) > label")).getText()) ) {
        	System.out.println("English Remember Me text correct, test succeeded.");
        } else {
        	System.out.println("English Remember Me text incorrect, test failed.");
        }
        
        if ( privacyTextEN.equals(driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(2) > ul > li:nth-child(4) > a")).getText()) ) {
        	System.out.println("English Privacy text correct, test succeeded.");
        } else {
        	System.out.println("English Privacy text incorrect, test failed.");
        }
        
        if ( needHelpTextEN.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > div.remember-flex > div.help > a")).getText()) ) {
        	System.out.println("English login title correct, test succeeded.");
        } else {
        	System.out.println("English login title incorrect, test failed.");
        }
        
      //case 3: Check switching back to Turkish from English
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(3) > select")).click();
        
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
        
        driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(3) > select > option:nth-child(2)")).click();
        
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
        
        if ( loginTitleTR.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > h1")).getText()) ) {
        	System.out.println("Turkish login title correct, test succeeded.");
        } else {
        	System.out.println("Turkish login title incorrect, test failed.");
        }
        
        if ( rememberMeTextTR.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > div.remember-flex > div:nth-child(1) > label")).getText()) ) {
        	System.out.println("Turkish Remember Me text correct, test succeeded.");
        } else {
        	System.out.println("Turkish Remember Me text incorrect, test failed.");
        }
        
        if ( privacyTextTR.equals(driver.findElement(By.cssSelector("body > div.bottom > div > div:nth-child(2) > ul > li:nth-child(4) > a")).getText()) ) {
        	System.out.println("Turkish Privacy text correct, test succeeded.");
        } else {
        	System.out.println("Turkish Privacy text incorrect, test failed.");
        }
        
        if ( needHelpTextTR.equals(driver.findElement(By.cssSelector("body > div.upper > div.login-div > form > div.remember-flex > div.help > a")).getText()) ) {
        	System.out.println("Turkish login title correct, test succeeded.");
        } else {
        	System.out.println("Turkish login title incorrect, test failed.");
        }
        
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted.");
		}
        //close browser
      	driver.close();
      	driver.quit();
        
    }
}
