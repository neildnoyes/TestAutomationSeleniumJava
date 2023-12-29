package main.java.com.noyes.selenium_java.tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.com.noyes.selenium_java.utils.TestBase;

public class BasicTest extends TestBase {

    @Test
    public void testMethod() {

        System.out.println("Base URL is: " + baseUrl);

        //define page classes

        //functionality

    }

    @Parameters({"browser", "baseUrl"})
    @Test
    public void testMethodWithParams(String browser, String baseUrl) {

    }

}
