package com.adactin.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.adactin.bassclass.cucumberproject.BassClass;
import com.adactin.pom.BookHotel;
import com.adactin.pom.BookingConfirmation;
import com.adactin.pom.LoginPage;
import com.adactin.pom.SearchHotel;
import com.adactin.pom.SelectHotel;
import com.adactin.runner.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends BassClass {

	public static WebDriver driver1 = Runner.driver;

	LoginPage lp = new LoginPage(driver1);
	SearchHotel sh = new SearchHotel(driver1);
	SelectHotel sh1 = new SelectHotel(driver1);
	BookHotel bh = new BookHotel(driver1);
	BookingConfirmation bc = new BookingConfirmation(driver1);

	@Given("User launch the adactin application")
	public void user_launch_the_adactin_application() {
		geturl("https://adactin.com/HotelApp/");

	}

	@When("User enter the username")
	public void user_enter_the_username() {
		inputvalueonelement(lp.getUsername(), "Sivskuma12");

	}

	@When("User enter the password")
	public void user_enter_the_password() {
		inputvalueonelement(lp.getPassword(), "ammaappa");
	}

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
		clickonelement(lp.getLogin());
	}

	@Then("User validate the name of the user in homepage")
	public void user_validate_the_name_of_the_user_in_homepage() {
	}

	@When("User select the location")
	public void user_select_the_location() {
		dropdown(sh.getLocation(), "Sydney", "byvalue");
	}

	@When("User select the best hotel")
	public void user_select_the_best_hotel() {
		dropdown(sh.getHotels(), "Hotel Creek", "byvalue");
	}

	@When("User Select the room types")
	public void user_Select_the_room_types() {
		dropdown(sh.getRoom_type(), "Super Deluxe", "byvalue");
	}

	@When("User Select the number of room booking")
	public void user_Select_the_number_of_room_booking() {
		dropdown(sh.getRoom_nos(), "2", "byvalue");
	}

	@When("User select the check in date")
	public void user_select_the_check_in_date() {
		clear(sh.getDatepick_in());
		inputvalueonelement(sh.getDatepick_in(), "28/02/2020");

	}

	@When("User select the check out date")
	public void user_select_the_check_out_date() {
		clear(sh.getDatepick_out());
		inputvalueonelement(sh.getDatepick_out(), "30/02/2020");
	}

	@When("User select the adults per room")
	public void user_select_the_adults_per_room() {
		dropdown(sh.getRoom_nos(), "2", "byvalue");
	}

	@When("User select the children per room")
	public void user_select_the_children_per_room() {
		dropdown(sh.getChild_room(), "1", "byvalue");
	}

	@Then("User click on the search button")
	public void user_click_on_the_search_button() {
		clickonelement(sh.getSubmit());
	
	}
	@When("User can click the select button")
	public void user_can_click_the_select_button() {
	clickonelement(sh1.getRadiobutton());
		
	}
	@Then("User can click the continue button")
	public void user_can_click_the_continue_button() {
		clickonelement(sh1.getContinue1());
	}
	@When("User is given the firstname")
	public void user_is_given_the_firstname() {
		inputvalueonelement(bh.getFirstname(), "Sivakumar");
		
	}

	@When("User is given the lastname")
	public void user_is_given_the_lastname() {
	inputvalueonelement(bh.getLastname(), "Sekar");
			}

	@When("User is fill the billing address")
	public void user_is_fill_the_billing_address() {
		inputvalueonelement(bh.getAddress(), "asdfg111fv");
	}

	@When("User is fill the credit card details")
	public void user_is_fill_the_credit_card_details() {
		inputvalueonelement(bh.getCc_num(), "1230456720001234");
	}

	@When("User select the credit card type")
	public void user_select_the_credit_card_type() {
		dropdown(bh.getCc_type(), "VISA", "byvalue");
	}

	@When("User need to fill the credit card Expiry date")
	public void user_need_to_fill_the_credit_card_Expiry_date() {
		dropdown(bh.getCc_exp_month(), "1", "byvalue");
		dropdown(bh.getCc_exp_year(), "2012", "byvalue");
	}

	@When("User is give the cvv number")
	public void user_is_give_the_cvv_number() {
		inputvalueonelement(bh.getCc_cvv(), "023");
	}

	@Then("User click on the book now option")
	public void user_click_on_the_book_now_option() {
		clickonelement(bh.getBook_now());
	}
	@Then("Booking Itinerary")
	public void booking_Itinerary() {
		clickonelement(bc.getBooking());
	}


}
