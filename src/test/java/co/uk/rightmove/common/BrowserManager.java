package co.uk.rightmove.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BrowserManager extends DriverManager{

    public WebDriver initChrome()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver initFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    public WebDriver initSafari()
    {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    public WebDriver initChromeHeadless()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--headless");

        return new ChromeDriver(options);
    }

    public void launchBrowser(String browser)
    {
        switch(browser.toLowerCase())
        {
            case "chrome":
                driver = initChrome();
                break;
            case "firefox":
                driver = initFirefox();
                break;
            case "safari":
                driver = initSafari();
                break;
            case "headless":
                driver = initChromeHeadless();
                break;
            default:
                driver = initChromeHeadless();
                        break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.manage().deleteAllCookies();
      //  driver.close();
        driver.quit();
    }




}
