package com.vodafone.vois.cucks.api;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

import com.vodafone.vois.cucks.api.constant.Constants;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Stepdefs {

	String url = null;
	HttpResponse<JsonNode> response = null;

	@When("^I make HTTP request$")
	public void i_make_HTTP_request() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.out.println(url);
		response = Unirest.get(url).header("accept", "application/json")

				.asJson();
	}

	@Then("^I get OK response$")
	public void i_get_OK_response() throws Throwable {

		Assert.assertEquals(200, response.getStatus());

	}
	
	@Given("^I add following headers$")
	public void i_add_following_headers(DataTable table) throws Throwable {
	
		Map<String, String> headers = table.asMap(String.class, String.class);
		for (Entry<String, String> header : headers.entrySet()) {
			System.out.println("Header Key : " + header.getKey() + "  Value : " + header.getValue());
		}
	}

	@Then("^response contains json$")
	public void request_contains_pet_id() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String json = response.getBody().toPrettyString();
		System.out.println(json);
		Assert.assertNotNull(json);
	}

	@Given("^I have base URL for user API$")
	public void i_have_base_URL_for_dashboard_API() throws Throwable {

	}

	@Given("^I use user list API$")
	public void i_use_dashboard_list_API() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		url = Constants.BASE_URL + "/" + "get";
	}

	@Given("^I use wrong API path$")
	public void i_use_wrong_API_path() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		url = Constants.BASE_URL + "/";
	}

	@Then("^I get (\\d+) response$")
	public void i_get_response(int exp) throws Throwable {
		Assert.assertEquals(exp, response.getStatus());
	}

}
