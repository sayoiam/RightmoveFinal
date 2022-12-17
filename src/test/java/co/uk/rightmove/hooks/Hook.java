package co.uk.rightmove.hooks;

import co.uk.rightmove.common.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BrowserManager {

    @Before
    public void setUp()
    {
        launchBrowser("Chrome");
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
