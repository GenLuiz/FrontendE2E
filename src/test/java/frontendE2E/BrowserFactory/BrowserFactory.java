package frontendE2E.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    private static WebDriver driver = null;

    public WebDriver getWebDriver(){
        if(driver == null){
            return createWebDriver();
        }else{
            return driver;
        }
    }

    public void closeDriver(){
        try {
            Thread.sleep(1000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver createWebDriver(){
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

}
