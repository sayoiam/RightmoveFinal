package co.uk.rightmove.stepDefinitions;

import co.uk.rightmove.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class searchSteps extends BasePage {

    HomePage homePage = new HomePage(driver);
    SearchCriteriaPage searchCriteriaPage = new SearchCriteriaPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);

    @Given("I navigate to the homepage")
    public void i_navigate_to_the_homepage() {
        launchUrl();
    }

    @When("I enter {string} into the search field")
    public void i_enter_into_the_search_field(String location) {
        homePage.enterLocation(location);
    }

    @When("I click on For Sale button")
    public void i_click_on_for_sale_button() {
        searchCriteriaPage = homePage.clickOnForSaleButtonMulti();
    }

    @When("I select radius {string} of the location")
    public void i_select_radius_of_the_location(String radius) {
        searchCriteriaPage.selectRadius(radius);
    }

    @When("minimum price range of {string}")
    public void minimum_price_range_of(String miniPrice) {
        searchCriteriaPage.selectMinimumPrice(miniPrice);
    }

    @When("maximum price range of {string}")
    public void maximum_price_range_of(String max) {
        searchCriteriaPage.selectMaximumPrice(max);
    }

    @When("I select {string} as the minimum no of bedrooms")
    public void i_select_as_the_minimum_no_of_bedrooms(String string) {

    }

    @When("I select {string} as the maximum no of bedrooms")
    public void i_select_as_the_maximum_no_of_bedrooms(String string) {

    }

    @When("I select {string} as the property type")
    public void i_select_as_the_property_type(String string) {

    }

    @When("I select {string} as Added to site option")
    public void i_select_as_added_to_site_option(String date) {
        searchCriteriaPage.selectDateAddedToSite(date);
    }

    @When("I click on Find properties button")
    public void i_click_on_find_properties_button() {
        searchResultPage = searchCriteriaPage.clickOnFindPropertiesButton();
    }

    @When("I ensure that Search Result page is displayed")
    public void i_ensure_that_search_result_page_is_displayed() {
        //verification
        Assert.assertTrue("Search result page url does not contain /find.html",
                searchResultPage.isSearchResultPageUrlDisplayed());
        Assert.assertTrue("Edit this Area link is not displayed",
                searchResultPage.isEditThisAreaLinkDisplayed());
        Assert.assertTrue("No search result was return for the search",
                searchResultPage.areResultsDisplayed());
    }

    @When("I click on the second result")
    public void i_click_on_the_second_result() {
        productDetailPage = searchResultPage.clickOnARandomResult();
    }

    @Then("the details of the property is displayed")
    public void the_details_of_the_property_is_displayed() {
        productDetailPage.isProductDetailsPageDisplayed();
    }

}
