package pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by marcelodiaz on 4/8/17.
 */
public class ContactPage extends FluentWebDriverPage{
    WebDriverProvider webDriverProvider;
    WebElement titleContact, errorMsg;
    WebElement firstName, lastName, email, phone, jobTitle, school, district, state, zipCode, numStudents, submitButton;

    /**
     * Method to create a new instance of HomePage
     * @param webDriverProvider
     */
    public ContactPage(WebDriverProvider webDriverProvider)  {
        super(webDriverProvider);
        this.webDriverProvider= webDriverProvider;
        //PageFactory.initElements(driver, this);
        titleContact = findElement(By.xpath("//div[@class='container-fluid']//h1[contains(text(), 'Contact Us')]"));
        firstName=  findElement(By.name("firstname"));
        lastName =  findElement(By.name("lastname"));
        email =  findElement(By.name("email"));
        phone =  findElement(By.name("phone"));
        jobTitle=  findElement(By.name("title"));
        school=  findElement(By.name("companyname"));
        district= findElement(By.name("custentity89"));
        state =  findElement(By.name("state"));
        zipCode =  findElement(By.name("zipcode"));
        numStudents=  findElement(By.name("singleLineText3"));
        submitButton =  findElement(By.xpath("//input[@value='Submit']"));

    }

    public boolean isLoad(){
        return titleContact.isDisplayed();
    }

    public void goToUrl(String url){
         get(url);
    }

    public String getTitle(String pageName) {
        return this.getTitle();
    }
    public boolean incompleteForm(){
        firstName.sendKeys("Administrator");
        lastName.sendKeys("LastName");
        email.sendKeys("email@gmail.com");
        phone.sendKeys("158654789");
        jobTitle.sendKeys("Daddy");
        school.sendKeys("G. W. School");
        district.sendKeys("Phoenix Dist.");
        zipCode.sendKeys("85005");
        numStudents.sendKeys("2");

        submitButton.click();

        errorMsg =  findElement(By.xpath("//span[contains(text(), 'Please select your State')]"));
        return errorMsg.isDisplayed();
    }
}
