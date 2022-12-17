package co.uk.rightmove.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCriteriaPage extends BasePage {

    public SearchCriteriaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "radius")
    private WebElement searchRadius;
    @FindBy(id = "minPrice")
    private WebElement minimumPrice;
    @FindBy(name = "maxPrice")
    private WebElement maximumPrice;
    @FindBy(id = "maxDaysSinceAdded")
    private WebElement dateAddedToSite;
    @FindBy(id = "submit")
    private WebElement findPropertiesButton;

    public void selectRadius(String text)
    {
        selectElementByText(searchRadius, text);
    }

    public void selectMinimumPrice(String text)
    {
        selectElementByText(minimumPrice, text);
    }

    public void selectMaximumPrice(String text)
    {
        selectElementByText(maximumPrice, text);
    }

    public void selectDateAddedToSite(String text)
    {
        selectElementByText(dateAddedToSite, text);
    }

    public SearchResultPage clickOnFindPropertiesButton()
    {
        findPropertiesButton.click();
        return new SearchResultPage(driver);
    }
}
