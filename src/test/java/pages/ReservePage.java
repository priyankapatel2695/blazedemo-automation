package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {

    WebDriver driver;

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    By chooseFlightButton = By.cssSelector("input[type='submit']");

    public void chooseFlight() {

        driver.findElement(chooseFlightButton).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
