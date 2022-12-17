package co.uk.rightmove.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDetailsPageDisplayed()
    {
        return driver.getCurrentUrl().contains("/?channel=");
    }
}
