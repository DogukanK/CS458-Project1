
package testcase;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RememberMeTest {

    public static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("http://localhost:5500/index.html"); // open URL

        // TEST 2 (REMEMBER ME CHECKBOX EFFECTS)
        WebElement nameField;
        WebElement passwordField;
        WebElement rememberMeBtn;
        
        nameField = driver.findElement(By.id("inputEmail"));
        passwordField = driver.findElement(By.id("inputPassword"));
        rememberMeBtn = driver.findElement(By.id("rememberMe"));
        
        //Case 1 - Check whether the button works
        int repeatCheck = 2;
        boolean btnState = rememberMeBtn.isSelected();
        for (int i = 0; i < repeatCheck; i ++) {
            rememberMeBtn.click();
            if (rememberMeBtn.isSelected() == !btnState) {
                btnState = !btnState;
                if(i == repeatCheck - 1)
                    System.out.println("Button Test Succeeded.");
            }
            else {
                System.out.println("Button Test Failed.");
                break;
            }
        }

        //Wait before case 2
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Got interrupted.");
        }
        
        int validTestCount = 3;
        String[] validTestUsernames = new String[validTestCount];
        String[] validTestPasswords = new String[validTestCount];
        validTestUsernames[0]  = "test@test.com";
        validTestUsernames[1]  = "dogukanertunga@gmail.com";
        validTestUsernames[2]  = "123456789";
        validTestPasswords[0] = "aaaa";
        validTestPasswords[1] = "1234";
        validTestPasswords[2] = "qwe321";
        
        //Case 2 - Login while Remember Me is checked
        for (int i = 0; i < validTestCount; i ++) {
            rememberMeBtn = driver.findElement(By.id("rememberMe"));
            nameField = driver.findElement(By.id("inputEmail"));
            passwordField = driver.findElement(By.id("inputPassword"));
            
            while (!rememberMeBtn.isSelected()) {
                rememberMeBtn.click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Got interrupted.");
                }
            }
            
            nameField.sendKeys(validTestUsernames[i]);
            passwordField.sendKeys(validTestPasswords[i]);
            driver.findElement(By.className("signin-button")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Got interrupted.");
            }

            driver.findElement(By.className("img-logo")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Got interrupted.");
            }

            if (driver.findElement(By.id("inputEmail")).getAttribute("value").equals(validTestUsernames[i])) {
                System.out.println("Checked Remember Me Login Test Succeeded.");
            } else {
                System.out.println("Checked Remember Me Login Test Failed.");
            }

            driver.findElement(By.id("inputEmail")).clear();
        }
        
        //Case 3 - Login while Remember Me is unchecked
        for (int i = 0; i < validTestCount; i ++) {
            rememberMeBtn = driver.findElement(By.id("rememberMe"));
            nameField = driver.findElement(By.id("inputEmail"));
            passwordField = driver.findElement(By.id("inputPassword"));
            
            while (rememberMeBtn.isSelected()) {
                rememberMeBtn.click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Got interrupted.");
                }
            }
            
            nameField.sendKeys(validTestUsernames[i]);
            passwordField.sendKeys(validTestPasswords[i]);
            driver.findElement(By.className("signin-button")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Got interrupted.");
            }

            driver.findElement(By.className("img-logo")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Got interrupted.");
            }
            
            String textFieldInput = driver.findElement(By.id("inputEmail")).getAttribute("value");
            
            if (textFieldInput.isEmpty()) {
                System.out.println("Unchecked Remember Me Login Test Succeeded.");
            } else {
                System.out.println("Unchecked Remember Me Login Test Failed.");
            }
        }
        
      //close browser
      driver.close();
      driver.quit();
    }
}