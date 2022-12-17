package co.uk.rightmove.pages;

import co.uk.rightmove.common.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends DriverManager {

    public String BASE_URL = "https://www.rightmove.co.uk/";

    private Select select;
    private Actions actions;

    public void launchUrl()
    {
        driver.navigate().to(BASE_URL);
    }

    public void selectElementByText(WebElement element, String text)
    {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectElementByValue(WebElement element, String value)
    {
        select = new Select(element);
        select.selectByValue(value);
    }

    public void selectElementByIndex(WebElement element, int index)
    {
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void HoverOverAnElement(WebElement element)
    {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
