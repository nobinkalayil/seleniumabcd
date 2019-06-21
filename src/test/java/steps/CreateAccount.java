package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class CreateAccount extends DriverManager {
    @Given("^I am in sign in page$")
    public void i_am_in_sign_in_page() throws Throwable {
        driver.findElement(By.id("cn_membership-signin--toplink")).click();
    }

    @When("^I click on create button$")

    public void i_click_on_create_button() throws Throwable {
        sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(), 'Create an account')]")).click();

    }

    @And("^It should ask me \"([^\"]*)\"$")
    public void it_should_ask_me(String arg1) throws Throwable {
        String actual = driver.findElement(By.xpath("//h1[contains(text(), 'Do you have a')]")).getText();
        System.out.println(actual);
        assertThat(actual, is("Do you have a Co‑op card or key fob?"));


    }

    @And("^I select no$")
    public void i_select_no() throws Throwable {
        driver.findElement(By.id("member-has-card-no")).click();
        driver.findElement(By.id("register-check-card-button")).click();

    }

    @And("^I should see registration page$")
    public void i_should_see_registration_page() throws Throwable {
        String actual = driver.findElement(By.xpath("//h1[contains(text(), 'Join Co‑op for £1')]")).getText();
        assertThat(actual, is("Join Co‑op for £1"));

    }


    @And("^a customer enter all valid details in the registration form$")
    public void a_customer_enter_all_valid_details_in_the_registration_form() throws Throwable {
        sleep(5000);
        driver.findElement(By.id("member-first-name")).sendKeys("cat");
        driver.findElement(By.id("member-last-name")).sendKeys("dog");
        sleep(3000);

        WebElement pleaseSelect = driver.findElement(By.cssSelector("#member-title"));

        Select select = new Select(pleaseSelect);
        select.selectByIndex(1);
        System.out.println(select);

        driver.findElement(By.id("member-day-of-birth")).sendKeys("28");
        driver.findElement(By.id("member-month-of-birth")).sendKeys("08");
        driver.findElement(By.id("member-year-of-birth")).sendKeys("1984");
        driver.findElement(By.id("postcode")).sendKeys("SS16 5EE");
        driver.findElement(By.id("find-address-current")).click();
        List<WebElement> postcodeList = driver.findElements(By.xpath("//ul[@class='current-address-list']/li"));
        int allpostcodeList = postcodeList.size();
        //System.out.println(allpostcodeList);
        //WebElement postcode = driver.findElement(By.xpath("//ul[@class='current-address-list']/li"));
        //String postcodetext= postcode.getText();
        Actions actions = new Actions(driver);
        actions.click(postcodeList.get(1)).build().perform();
        driver.findElement(By.id("member-email")).sendKeys("nobin123@gmail.com");
        driver.findElement(By.id("member-confirm-email")).sendKeys("nobin123@gmail.com");
        driver.findElement(By.id("member-password")).sendKeys("N4ass165ee");
        driver.findElement(By.id("member-confirm-password")).sendKeys("N4ass165ee   A");


    }

    @And("^select marketing preference$")
    public void select_marketing_preference() throws Throwable {
        driver.findElement(By.id("marketing-opt-in-email")).click();

    }

    @And("^click in continue proceed$")
    public void click_in_continue_proceed() throws Throwable {
        driver.findElement(By.id("register-button")).click();

    }

    @Then("^custemer should see payment page$")
    public void custemer_should_see_payment_page() throws Throwable {

    }

}
