package main.java.com.noyes.selenium_java.pages.QAPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.com.noyes.selenium_java.utils.PgBase;

import java.time.Duration;
import java.util.List;

public class PgTagInputs extends PgBase {

    public PgTagInputs(WebDriver driver){
        super(driver);
    }

    /**
     * Method: getRemainingTags
     *
     * Gets the number of remaining tags able to be embedded in the html
     *
     * @return Int representing the amount of remaining tags
     *
     */
    public int getRemainingTags(){

        //find the span containing the remaining input number
        WebElement tags = driver.findElement(By.xpath("//div[@class='details']/p/span"));

        //return the remaining, replacing all other characters but digits
        return Integer.parseInt(tags.getText().replaceAll("[^0-9]", ""));
    }

    /**
     * Method: removeAllTags
     *
     * Clicks the Remove All button on the page to remove all tags
     *
     */
    public void removeAllTags(){

        //find remove all button
        WebElement removeAll = driver.findElement(By.xpath("//button[text()='Remove All']"));

        //click remove all button
        commonMethods.clickWhenVisible(removeAll, 20);

        //assert 0 remaining
        Assert.assertEquals(getRemainingTags(), 10);
    }

    /**
     * Method: addTag
     *
     * Enters a tag in the input box on the page
     *
     */
    public void addTag(String tagText) throws InterruptedException {

        //get remaining tags
        int remaining = getRemainingTags();

        if (remaining > 0){

            //find text input
            WebElement input = driver.findElement(By.xpath("//input[@type='text']"));

            //add tag with given text
            commonMethods.enterValueWhenVisible(input, tagText, 20);

            //hit enter to finalize tag addition
            input.sendKeys(Keys.RETURN);
        }
        else {
            System.out.println("No remaining space for tags...\n");
        }
    }

    /**
     * Method: removeTag
     *
     * Removes a tag in the input box on the page containing the given text
     *
     */
    public void removeTag(String tagText){

        //find text input
        WebElement input = driver.findElement(By.xpath("//li[text()='" + tagText + " ']"));

        if (input != null) {

            //click the corresponding delete icon
            commonMethods.clickWhenVisible(input.findElement(By.tagName("i")), 20);

        }else {
            System.out.println("No tag with text " + tagText + " found...\n");
        }
    }

}
