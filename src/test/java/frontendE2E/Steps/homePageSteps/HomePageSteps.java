package frontendE2E.Steps.homePageSteps;

import frontendE2E.Steps.AbstractSteps;
import frontendE2E.Steps.InterfaceSteps;
import frontendE2E.pages.homePage.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class HomePageSteps extends AbstractSteps implements InterfaceSteps {

    private HomePage homePage = new HomePage();

    @Before
    public void openBrowserBeforeScenario() {
        openBrowser();
    }

    @After
    public void closeDriverAfterScenario() {
        closeDriver();
    }


    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        homePage.homePageIsVisible();
    }

}
