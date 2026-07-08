package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ConfirmationPage;
import pages.HomePage;
import pages.PurchasePage;
import pages.ReservePage;
import utils.BaseClass;

public class FlightBookingTest extends BaseClass {

    @Test
    public void bookFlightTest() {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("New York");
        home.clickFindFlights();

        ReservePage reserve = new ReservePage(driver);
        reserve.chooseFlight();

        PurchasePage purchase = new PurchasePage(driver);

        purchase.bookFlight(
                "Priyanka",
                "ABC Street",
                "Indore",
                "MP",
                "452001",
                "1234567890123456",
                "12",
                "2028",
                "Priyanka Patel");

        ConfirmationPage confirmation = new ConfirmationPage(driver);

        Assert.assertEquals(
                confirmation.getConfirmationMessage(),
                "Thank you for your purchase today!");
}
}
