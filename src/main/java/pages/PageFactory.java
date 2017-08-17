package pages;

import org.jbehave.web.selenium.WebDriverProvider;
/**
 * Created by marcelodiaz on 17/8/17.
 */


public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public HomePage newHome() {
        return new HomePage(webDriverProvider);
    }
    public CustomerSupportPage newCustomerSupportPage() { return new CustomerSupportPage(webDriverProvider);}
    public ContactPage newContactPage() { return new ContactPage(webDriverProvider);     }

}
