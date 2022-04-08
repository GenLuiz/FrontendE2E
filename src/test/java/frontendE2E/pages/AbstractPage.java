package frontendE2E.pages;

import frontendE2E.BrowserFactory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class AbstractPage {

    private BrowserFactory browserFactory = new BrowserFactory();

    public void waitPageLoad() {
        WebDriverWait wait = new WebDriverWait(browserFactory.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsToWait()));
    }


    protected List<WebElement> elementsToWait() {
        return null;
    }

    public WebElement waitForElement(By by) {
        Wait<WebDriver> wait = new FluentWait<>(browserFactory.getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(webDriver -> {
            if (webDriver == null) throw new AssertionError();
            return webDriver.findElement(by);
        });
    }

    public WebElement findElement(By by){
        waitForElement(by);
        return browserFactory.getWebDriver().findElement(by);
    }

    public void fillField(WebElement field, String input){
        field.clear();
        field.sendKeys(input);
    }

    public void waitForPageLoad() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoad(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
