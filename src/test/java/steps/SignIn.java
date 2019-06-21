package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverManager;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;


public class SignIn extends DriverManager {

    @Given("^I am on homepage$")
    public void i_am_on_homepage() throws Throwable {


    }

    @When("^I click sign in box$")
    public void i_click_sign_in_box() throws Throwable {
        driver.findElement(By.id("cn_membership-signin--toplink")).click();

    }

    @When("^I enter all valid details$")
    public void i_enter_all_valid_details() throws Throwable {
        driver.findElement(By.cssSelector("#member-email")).sendKeys("nobinkalayil84@gmail.com");
        driver.findElement(By.cssSelector(".member-password-input")).sendKeys("N4ass165ee");
        driver.findElement(By.cssSelector(".btn-primary")).click();

    }

    @Then("^then I should be see a message that I successfully registerd\\.$")
    public void then_I_should_be_see_a_message_that_I_successfully_registerd() throws Throwable {
        String actual = driver.findElement(By.cssSelector(".sign-in-js-errors.errors-serverside")).getText();
        System.out.println(actual);
        assertThat(actual, is("There's a problem\n" +
                "Your email or password aren't correct. Check you've typed them correctly and try again."));


    }


}
