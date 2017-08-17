package pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;

/**
 * Created by marcelodiaz on 4/8/17.
 */
public class CustomerSupportPage extends FluentWebDriverPage {

    private final String xpathButtonSupportForm = "//a[@href='#technical-support']/button";
    WebElement buttonSupportForm;
    /**
     * Method to create a new instance of HomePage
     * @param webDriverProvider
     */
    public CustomerSupportPage(WebDriverProvider webDriverProvider){
        super(webDriverProvider);
    }

    public boolean isLoad(){
        System.out.println("driver.getTitle(): '"+ getTitle()+"'");
        return buttonSupportForm.isDisplayed();
    }

    public void goToUrl(String url){
        get(url);
    }

    public String getTitle() {
        return getTitle();
    }

}
