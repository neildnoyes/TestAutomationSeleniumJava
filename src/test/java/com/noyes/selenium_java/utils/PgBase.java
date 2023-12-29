package test.java.com.noyes.selenium_java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.com.noyes.selenium_java.utils.CommonMethods;

public class PgBase {

    protected CommonMethods commonMethods;
    protected WebDriver driver;

    public PgBase(WebDriver driver){

        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        PageFactory.initElements(driver, this);

    }

}
