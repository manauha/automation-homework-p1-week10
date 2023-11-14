package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

public class P1_nopcommerce {

    // 1. Setup Chrome browser.
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/"; // Base URL declaration
    static WebDriver driver;

    // main method
    public static void main(String[] args) {

        //multi browser set up
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver(); ////object of the browser class
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid Browser name");
        }

        //launch the Chrome browser
        //2. get method open the URL in browser
        driver.get(baseUrl);

        //maximise the browser window
        driver.manage().window().maximize();

        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //get the title of the page
        String title = driver.getTitle();

        //3.  printing the title of the page
        System.out.println(title);

        //4. get the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The Current URL : " + currentUrl);

        //5. get the page source
        String pageSource = driver.getPageSource();
        System.out.println("Page Source : \n" + pageSource);

        //6. navigate to given Url
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl= %2F";
        driver.navigate().to(loginUrl);

        //7. 7. Print the current url.
        System.out.println("Get the current URL : " + driver.getCurrentUrl());

        //8. Navigate back to the home page.
        driver.navigate().to(baseUrl);

        //9. Navigate to the login page.
        driver.navigate().to(loginUrl);

        //10. Print the current url.
        System.out.println("Get the current URL : " + driver.getCurrentUrl());

        //11. Refresh the page.
        driver.navigate().refresh();

        //12. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("TestEmail@gmail.com");

        //13. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Element@1234");

        //14. Click on Login Button.
        WebElement loginLink = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginLink.click();

        //15. Close the browser.
        driver.quit();
    }
}
