package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ConfirmationPage;
import pages.HomePage;
import pages.PurchasePage;
import pages.ReservePage;
import utils.BaseClass;

public class DataDrivenBookingTest extends BaseClass {

    @DataProvider(name = "bookingData")
    public Object[][] bookingData() {

        return new Object[][] {

            {"Priyanka", "ABC Street", "Indore", "MP", "452001", "1111222233334444", "12", "2028", "Priyanka Patel"},

            {"Rahul", "XYZ Road", "Delhi", "Delhi", "110001", "5555666677778888", "10", "2029", "Rahul Sharma"},

            {"Amit", "MG Road", "Pune", "Maharashtra", "411001", "9999000011112222", "08", "2030", "Amit Kumar"}

        };
    }

    @Test(dataProvider = "bookingData")
    public void bookFlightDataDriven(String name,
                                     String address,
                                     String city,
                                     String state,
                                     String zip,
                                     String cardNumber,
                                     String month,
                                     String year,
                                     String cardHolder) {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("New York");
        home.clickFindFlights();

        ReservePage reserve = new ReservePage(driver);
        reserve.chooseFlight();

        PurchasePage purchase = new PurchasePage(driver);

        purchase.bookFlight(
                name,
                address,
                city,
                state,
                zip,
                cardNumber,
                month,
                year,
                cardHolder);

        ConfirmationPage confirmation = new ConfirmationPage(driver);

        Assert.assertEquals(
                confirmation.getConfirmationMessage(),
                "Thank you for your purchase today!");
    }
}
