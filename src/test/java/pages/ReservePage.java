package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservePage {

    WebDriver driver;

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    By chooseFlightButton = By.cssSelector("input[type='submit']");

    public void chooseFlight() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(chooseFlightButton)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(chooseFlightButton)).click();
        }
    }
}