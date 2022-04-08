package frontendE2E.Steps;

import frontendE2E.BrowserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class AbstractSteps {

    private WebDriver driver;

    private BrowserFactory browserFactory = new BrowserFactory();

    public WebDriver getWebDriver(){
        return driver;
    }

    public void openBrowser(){
        driver = browserFactory.getWebDriver();
    }

    public void closeDriver(){
        browserFactory.closeDriver();
    }

}
