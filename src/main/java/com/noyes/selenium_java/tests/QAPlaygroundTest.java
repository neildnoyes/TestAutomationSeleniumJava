package main.java.com.noyes.selenium_java.tests;
import main.java.com.noyes.selenium_java.pages.QAPlayground.PgDynamicTable;
import main.java.com.noyes.selenium_java.pages.QAPlayground.PgVerifyAccount;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.com.noyes.selenium_java.utils.TestBase;

public class QAPlaygroundTest extends TestBase {

    @Parameters({"browser", "baseUrl"})
    @Test
    public void testDynamicTable(String browser, String baseUrl) {

        String pageUrl = "apps/dynamic-table/";

        //define page classes
        PgDynamicTable dynamicTable = new PgDynamicTable(driver);

        //load page in driver
        driver.get(baseUrl + pageUrl);

        //find spiderman
        dynamicTable.findHero("Spider-Man", "Peter Parker");

    }

    @Parameters({"browser", "baseUrl"})
    @Test
    public void testVerifyAccount(String browser, String baseUrl) {

        String pageUrl = "apps/verify-account/";

        //define page classes
        PgVerifyAccount verifyAccount = new PgVerifyAccount(driver);

        //load page in driver
        driver.get(baseUrl + pageUrl);

        //enter code
        verifyAccount.enterCode();

    }

    @Parameters({"browser", "baseUrl"})
    @Test
    public void testTagInputs(String browser, String baseUrl) {

        String pageUrl = "apps/tags-input-box/";

        //define page classes

        //load page in driver
        driver.get(baseUrl + pageUrl);

        //Add and remove tags and assert tag's presence and count

    }

}
