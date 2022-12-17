package co.uk.rightmove.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ksc_inputText.ksc_typeAheadInputField")
    private WebElement searchField;
    @FindBy(xpath = "//button[text()=\"For Sale\"]")
    private WebElement forSaleButton;
    @FindBy(css = ".ksc_button.large.primary.searchPanelControls")
    private List<WebElement> forSaleButtonMultiple;


    public void enterLocation(String location)
    {
        searchField.sendKeys(location);
    }

    public SearchCriteriaPage clickOnForSaleButton()
    {
        forSaleButton.click();
        return new SearchCriteriaPage(driver);
    }

    public SearchCriteriaPage clickOnForSaleButtonMulti()
    {
        forSaleButtonMultiple.get(0).click();
        return new SearchCriteriaPage(driver);
    }
}
