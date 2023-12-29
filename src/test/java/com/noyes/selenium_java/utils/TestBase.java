package test.java.com.noyes.selenium_java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected WebDriver driver;
    protected String baseUrl;
    protected CommonMethods commonMethods;

    /**
     * Method: setup
     *
     * @param browser - string representing browser name
     * @param baseUrl - string representing base url
     *
     * Loads the config file and sets a new instance of a driver
     */
    @Parameters({"browser", "baseUrl"})
    @BeforeClass
    public void setup(String browser, @Optional("https://www.google.com") String baseUrl) throws IOException {

        System.out.println("Beginning TestBase Setup");

        //load config.properties file
        loadConfig();

        //set our driver
        setDriver(browser);

        //setup common methods
        this.commonMethods = new CommonMethods(driver);

    }

    /**
     * Method: loadConfig
     *
     * Loads the configuration file config.properties
     */
    private void loadConfig() throws IOException {

        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("./config.properties")) {

            properties.load(fileInputStream);

            setBaseUrl(properties.getProperty("baseUrl"));

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * Method: setBaseUrl
     *
     * @param baseUrl - string representing a URL
     *
     * Sets our local baseUrl to param baseUrl
     *
     */
    private void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

    /**
     * Method: setDriver
     *
     * @param browser - string representing browser name
     *
     * Sets our local driver to a new instance of a driver
     *
     */
    private void setDriver(String browser){

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else{
            System.out.println("Only chrome driver valid currently...");
        }

    }

    /**
     * Method: getDriver
     *
     * @return WebDriver - returns current driver or null if none
     */
    public WebDriver getDriver() {

        try{
            return this.driver;
        }
        catch (Error e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method: tearDown
     *
     * Closes webdriver if there is an active instance
     *
     */
    @AfterClass
    public void tearDown() {
        System.out.println("Performing cleanup tasks in TestBase...");

        // Close the WebDriver and release resources
        if (driver != null) {
            driver.quit();
        }
    }

}
