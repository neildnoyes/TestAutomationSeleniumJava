package test.java.com.noyes.selenium_java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {

    protected WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method: clickWhenVisible
     *
     * @param locator - locator for web element
     * @param timeout - integer representing timeout time
     *
     * Waits for element to become visible and clicks it within timeout
     *
     */
    public void clickWhenVisible(By locator, int timeout){

        try{
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.click();
        }
        catch(TimeoutException e){
            System.out.println("Element with locator " + locator + " was not visible within the specified timeout.");
        }

    }

    /**
     * Method: clickWhenVisible
     *
     * @param locator - locator for web element
     *
     * Waits for element to become visible and clicks it
     *
     */
    public void clickWhenVisible(By locator){

        try{
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.click();
        }
        catch(TimeoutException e){
            System.out.println("Element with locator " + locator + " was not visible.");
        }

    }

    /**
     * Method: enterValueWhenVisible
     *
     * @param locator - locator for web element
     * @param value - string representing the value to enter
     * @param timeout - integer representing timeout time
     *
     * Waits for element to become visible and enters value into it within timeout
     *
     */
    public void enterValueWhenVisible(By locator, String value, int timeout){

        try{
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.sendKeys(value);
        }
        catch(TimeoutException e){
            System.out.println("Element with locator " + locator + " was not visible.");
        }

    }

    /**
     * Method: enterValueWhenVisible
     *
     * @param locator - locator for web element
     * @param value - string representing the value to enter
     *
     * Waits for element to become visible and enters value into it
     *
     */
    public void enterValueWhenVisible(By locator, String value){

        try{
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.sendKeys(value);
        }
        catch(TimeoutException e){
            System.out.println("Element with locator " + locator + " was not visible.");
        }

    }

    /**
     * Method: clickWhenVisible
     *
     * @param element - web element
     * @param timeout - integer representing timeout time
     *
     * Waits for element to become visible and clicks it within timeout
     *
     */
    public void clickWhenVisible(WebElement element, int timeout){

        try{
            element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOf(element));

            element.click();
        }
        catch(TimeoutException e){
            System.out.println("Element " + element + " was not visible within the specified timeout.");
        }

    }

    /**
     * Method: clickWhenVisible
     *
     * @param element - web element
     *
     * Waits for element to become visible and clicks it
     *
     */
    public void clickWhenVisible(WebElement element){

        try{
            element = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(element));

            element.click();
        }
        catch(TimeoutException e){
            System.out.println("Element with locator " + element + " was not visible.");
        }

    }

    /**
     * Method: enterValueWhenVisible
     *
     * @param element - web element
     * @param value - string representing the value to enter
     * @param timeout - integer representing timeout time
     *
     * Waits for element to become visible and enters value into it within timeout
     *
     */
    public void enterValueWhenVisible(WebElement element, String value, int timeout){

        try{
            element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOf(element));

            element.sendKeys(value);
        }
        catch(TimeoutException e){
            System.out.println("Element " + element + " was not visible.");
        }

    }

    /**
     * Method: enterValueWhenVisible
     *
     * @param element - web element
     * @param value - string representing the value to enter
     *
     * Waits for element to become visible and enters value into it
     *
     */
    public void enterValueWhenVisible(WebElement element, String value){

        try{
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(element));

            element.sendKeys(value);
        }
        catch(TimeoutException e){
            System.out.println("Element " + element + " was not visible.");
        }

    }

}
