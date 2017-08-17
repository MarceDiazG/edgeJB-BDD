package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by marcelodiaz on 1/8/17.
 */
public class EnvironmentData {
    int env = 1;
    String[] listOperSystem = {"Windows", "Mac", "Linux"};
    //According to each environment, must be set 0=Win, 1=Mac, 2=Linux
    String currentSO = listOperSystem[env];
    Properties data;


    public EnvironmentData(){
        setProperties();
    }
public Properties getProperties(){
        return this.data;
}
    public void setProperties(){
        data = new Properties();
        try{
            if (currentSO.equals("Windows")) {
                data.load(new FileInputStream("C:\\w\\JBehaveOK\\src\\main\\resources\\data.properties"));

            } else if (currentSO.equals("Mac")) {
                data.load(new FileInputStream("/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/resources/data.properties"));
            } else  {
                data.load(new FileInputStream("/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/resources/data.properties"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public WebDriver createDriver(){
        //System.setProperty("webdriver.edge.driver", "C:\\w\\FunctTest\\MicrosoftWebDriver.exe");
        //DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
        //driver = new EdgeDriver(capabilities);
        //doCreateWebDriver("chrome"); //new InternetExplorerDriver();
        //EdgeDriver();
        //OperaDriver(); //  //a[@href="/customer-support/"]
        //driver = new FirefoxDriver();
        return new ChromeDriver();
    }

    public WebDriver doCreateWebDriver() {
        String driverName = data.getProperty("defaultBrowser").toLowerCase();
        WebDriver driver;
        if (driverName != null) {

            if (driverName.equals("chrome")) {
                driver= new ChromeDriver();
            } else if (driverName.equals("edge")) {
                driver= new EdgeDriver();
            } else if (driverName.equals("firefox")) {
                driver= new FirefoxDriver();
            } else if (driverName.equals("htmlunit")) {
                driver= new HtmlUnitDriver();
            } else if (driverName.equals("internetexplorer") || driverName.equals("ie")) {
                driver= new InternetExplorerDriver();
            } else if (driverName.equals("opera")) {
                driver= new OperaDriver();
            } else if (driverName.equals("phantomjs")) {
                driver= new PhantomJSDriver();
            } else if (driverName.equals("safari")) {
                driver= new SafariDriver();
            } else if (driverName.equals("htmlunit")) {
                driver= new HtmlUnitDriver();
            } else { driver=new ChromeDriver();}
        } else { driver=new ChromeDriver();}
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

}
