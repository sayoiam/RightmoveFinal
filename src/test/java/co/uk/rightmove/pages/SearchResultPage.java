package co.uk.rightmove.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "searchSidebar-drawASearchLink")
    private WebElement editThisAreaLink;
    @FindBy(css = ".propertyCard-address.property-card-updates")
    private List<WebElement> results;


    public boolean isSearchResultPageUrlDisplayed()
    {
        return driver.getCurrentUrl().contains("/find.html?");
    }

    public boolean isEditThisAreaLinkDisplayed()
    {
        return editThisAreaLink.isDisplayed();
    }

    public boolean areResultsDisplayed()
    {
        return results.size() > 0;
    }

    public ProductDetailPage clickOnTheSecondResult()
    {
        results.get(1).click();
        return new ProductDetailPage(driver);
    }

    public ProductDetailPage clickOnARandomResult()
    {
        Random random = new Random();
        int ran = random.nextInt(results.size()-1);
        System.out.println("===============>>>>>>" + ran);

        results.get(ran).click();
        return new ProductDetailPage(driver);
    }
}

