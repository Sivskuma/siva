package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation {
	public WebDriver driver;
	
	@FindBy(linkText = "Booked Itinerary")
	private WebElement Booking;

	public BookingConfirmation(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver, this);
	}

	public WebElement getBooking() {
		return Booking;
	}
	

}
