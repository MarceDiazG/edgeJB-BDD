package steps;

import org.jbehave.core.annotations.*;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;
import pages.CustomerSupportPage;
import pages.HomePage;
import pages.PageFactory;

import java.util.Properties;

import static org.junit.Assert.assertTrue;

/**
 * Created by mdd_1 on 25/7/2017.
 */
public class commonSteps{

    private EnvironmentData env;
    Properties data;
    //ExtentReports extent;
    //ExtentHtmlReporter htmlReporter;
    PageFactory pageFactory;
    private HomePage homePage;
    CustomerSupportPage customerSupportPage;
    ContactPage contactPage;

    public commonSteps(PageFactory pageFactory){
        env= new EnvironmentData();
//        driver= env.doCreateWebDriver();
        data= env.getProperties();
        homePage = pageFactory.newHome();
        //htmlReporter = new ExtentHtmlReporter("extent.html");
        //extent = new ExtentReports();
    }

    @Given("an user that visit our landing page")
    public void goToHomePage() {

        String baseURL= data.getProperty("primaryURL");
        System.out.print(" >>>> This is the Given!, and we'll load: '"+baseURL+"'");
        this.homePage.goToUrl(baseURL);

        System.out.println("***> End of GIVEN");
    }

    @When("the user clicks on contact link")
    public void goToContactPage() {

        System.out.println(" >>>> This is the When !!!!");
        this.homePage.goToContactPage();
        contactPage= pageFactory.newContactPage();
        System.out.print(" >>>> ContactPage is Loaded? :" + contactPage.isLoad());

    }

    @When("the user clicks on support button")
    public void goToCustomerSupportPage() {

        System.out.println(" >>>> This is the When !!!!");
        this.homePage.goToSuppotPage();
        customerSupportPage= pageFactory.newCustomerSupportPage();

    }
    @Then("the support page is displayed successfully")
    public void isTheCorrectPage() {

        assertTrue("This is not Support Page!",
                "Edgenuity Inc. | Contact Us".equalsIgnoreCase(customerSupportPage.getTitle()));
        System.out.println(" >>>> This is the Then !!!!");
    }

    @Then("filling with incomplete data Contact Page form, error message is displayed")
    public void checkTitle(String pageName) {

        System.out.print(" >>>> Checking Title of the Page!!!!");

        assertTrue("This is not Contact Page!",
            "Edgenuity Inc. | Contact Us".equalsIgnoreCase(contactPage.getTitle(pageName)));
        assertTrue("The State validation is not working !!!",
            contactPage.incompleteForm());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" ");
        System.out.println("******* TC Successfully executed *********");
        System.out.println(" ");
    }

    @Then("the $title appears on the page")
    public void checkProduct(String title) {
        System.out.println(" >>>> This is the AND of the Then!!!!");
    }

    @BeforeScenario
    public void scenarioSetup() {
        System.out.println(" >>>> This is the Before !!!!");
        // initialize ExtentReports and attach the HtmlReporter
    }
/*
    @After
    void quitDriverScenario() {
        if (!(driver==null)) {
            driver.manage().deleteAllCookies();
            driver.close();
        }
        // attaching only HtmlReporter
        //extent.attachReporter(htmlReporter);
    }*/
    @AfterStory
    public void tearDown(){
        //extent.attachReporter(htmlReporter);
        /*if (!(driver==null)) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }*/
    }

}
