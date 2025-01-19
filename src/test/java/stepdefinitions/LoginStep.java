package stepdefinitions;

import com.microsoft.playwright.Page;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Login_Page;

public class LoginStep {
    private final Login_Page loginPage;
    private final Hooks hooks;

    public LoginStep(Hooks hooks) {
        this.hooks = hooks;
        this.loginPage = new Login_Page(hooks.getPage()); // Use the page from the Hooks class
    }

    @When("I click on the Sample App")
    public void iClickOnSampleApp() {
        loginPage.navigateToSampleApp();
    }

    @Then("the Sample App page is displayed")
    public void theSampleAppPageIsDisplayed() {
        Assert.assertTrue(loginPage.isSampleHeadingDisplayed(), "Sample Heading is not Displayed");
    }

    @When("I enter a random username in the {string} field")
    public void iEnterRandomUsernameInTheField(String text) {
        loginPage.fillUsername(text);
    }

    @And("I enter {string} in the Password field")
    public void iEnterPasswordInTheField(String password) {
        loginPage.filPassword(password);
    }

    @And("I click on the Login button")
    public void iClickOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("a success message is displayed at the top of the page")
    public void aSuccessMessageIsDisplayed() {
        Assert.assertTrue(loginPage.isSucesMsgDisplayed(), "Success Message is not Displayed");
    }
}
