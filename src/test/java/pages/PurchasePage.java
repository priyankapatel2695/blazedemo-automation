package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zipCode = By.id("zipCode");
    By cardType = By.id("cardType");
    By creditCardNumber = By.id("creditCardNumber");
    By creditCardMonth = By.id("creditCardMonth");
    By creditCardYear = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By purchaseFlight = By.cssSelector("input[type='submit']");

    public void bookFlight(String passengerName,
                           String passengerAddress,
                           String passengerCity,
                           String passengerState,
                           String passengerZip,
                           String cardNumber,
                           String month,
                           String year,
                           String cardHolderName) {

        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(passengerName);

        driver.findElement(address).sendKeys(passengerAddress);
        driver.findElement(city).sendKeys(passengerCity);
        driver.findElement(state).sendKeys(passengerState);
        driver.findElement(zipCode).sendKeys(passengerZip);

        driver.findElement(creditCardNumber).clear();
        driver.findElement(creditCardNumber).sendKeys(cardNumber);

        driver.findElement(creditCardMonth).clear();
        driver.findElement(creditCardMonth).sendKeys(month);

        driver.findElement(creditCardYear).clear();
        driver.findElement(creditCardYear).sendKeys(year);

        driver.findElement(nameOnCard).sendKeys(cardHolderName);

        driver.findElement(purchaseFlight).click();
    }
}
