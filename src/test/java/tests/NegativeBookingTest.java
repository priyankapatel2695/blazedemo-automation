package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PurchasePage;
import pages.ReservePage;
import utils.BaseClass;

public class NegativeBookingTest extends BaseClass {

	@Test
	public void blankCreditCardTest() {

		HomePage home = new HomePage(driver);

		home.selectDepartureCity("Boston");
		home.selectDestinationCity("New York");
		home.clickFindFlights();

		ReservePage reserve = new ReservePage(driver);
		reserve.chooseFlight();

		PurchasePage purchase = new PurchasePage(driver);

		purchase.bookFlight("Priyanka", "ABC Street", "Indore", "MP", "452001", "", "12", "2028", "Priyanka Patel");

		Assert.assertEquals(driver.getTitle(), "BlazeDemo Confirmation");
	}

	@Test
	public void invalidCreditCardTest() {

		HomePage home = new HomePage(driver);

		home.selectDepartureCity("Boston");
		home.selectDestinationCity("New York");
		home.clickFindFlights();

		ReservePage reserve = new ReservePage(driver);
		reserve.chooseFlight();

		PurchasePage purchase = new PurchasePage(driver);

		purchase.bookFlight("Priyanka", "ABC Street", "Indore", "MP", "452001", "ABC@123", "12", "2028",
				"Priyanka Patel");

		Assert.assertEquals(driver.getTitle(), "BlazeDemo Confirmation");

	}
}
