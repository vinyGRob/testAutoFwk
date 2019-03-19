package framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private String baseURL = "https://www.desmos.com/scientific";
    private String browser = "chrome";

    @BeforeSuite
    public void beforeSuite() {
        if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else if ("ie".equals(browser)) {
            driver = new InternetExplorerDriver();
        } else {
            Reporter.log("browser : " + browser + " is invalid, Launching Chrome as browser of choice..");
            System.out.println(("browser : " + browser + " is invalid, Launching Chrome as browser of choice.."));
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();

    }
    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
                driver.close();
                driver.quit();
            }
     }

     public WebDriver getDriver() {
         return driver;
     }
}
