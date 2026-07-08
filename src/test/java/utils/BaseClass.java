package utils;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://blazedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {

            ScreenshotUtil.captureScreenshot(driver, result.getName());

        }

        driver.quit();
    }

}
