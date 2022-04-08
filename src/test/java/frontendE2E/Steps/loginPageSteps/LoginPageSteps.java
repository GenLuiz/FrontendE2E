package frontendE2E.Steps.loginPageSteps;

import frontendE2E.Steps.AbstractSteps;
import frontendE2E.Steps.InterfaceSteps;
import frontendE2E.pages.loginPage.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class LoginPageSteps extends AbstractSteps implements InterfaceSteps {

    private final String LOGIN_PAGE_URL= "https://test.com/";

    private LoginPage loginPage = new LoginPage();

    @Before()
    public void openBrowserBeforeScenario() {
        openBrowser();
    }


    @Given("I am in the test login page")
    public void imInTheLoginPage() {
        getWebDriver().navigate().to(LOGIN_PAGE_URL);
    }

    @When("I insert an invalid credentials")
    public void insertInvalidLoginCredentials() {
       loginPage.fillUserNameId("Tests123");
       loginPage.fillUserPwd("Tests123");
       loginPage.clickSingInBtn();
    }

    @Then("I should see the invalid credentials message")
    public void invalidCredentialsMessage(){
        String errorMsg = loginPage.getInvalidCrednetialsMessage();
        Assertions.assertEquals("We didn't recognize the username or password you entered. Please try again.", errorMsg);
    }

}
