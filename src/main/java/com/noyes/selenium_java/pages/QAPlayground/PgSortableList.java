package main.java.com.noyes.selenium_java.pages.QAPlayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.com.noyes.selenium_java.utils.PgBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PgSortableList extends PgBase {

    public PgSortableList(WebDriver driver){
        super(driver);
    }

    String[] richestPeople = { "Jeff Bezos", "Bill Gates", "Warren Buffett", "Bernard Arnault",
                               "Carlos Slim Helu", "Amancio Ortega", "Larry Ellison", "Mark Zuckerberg",
                               "Michael Bloomberg", "Larry Page"};

    /**
     * Method: reorderNames
     *
     * Reorders the draggable list into the order of the richestPeople list defined above
     *
     */
    public void reorderNames(){


        //loop names
        for (int i = 0; i < richestPeople.length; i++){


            //get source element (richest person first in line)
            WebElement source = driver.findElement(By.xpath("//ul[@id='draggable-list']//li//p[text()='" +
                                                        richestPeople[i] + "']"));

            //get target element to drop onto (indexed li)
            WebElement target = driver.findElement(By.xpath("//ul[@id='draggable-list']//li[" + (i + 1) + "]"));

            //create actions instance
            Actions actions = new Actions(driver);

            //drag and drop
            actions.dragAndDrop(source, target).build().perform();

        }

    }

    /**
     * Method: checkOrder
     *
     * Checks the order of the names in the list and asserts the answers
     *
     */
    public void checkOrder(){

        //click check order button
        commonMethods.clickWhenVisible(driver.findElement(By.xpath("//button[@id='check']")));

        //get list of list items to check class name
        WebElement mainList = driver.findElement(By.className("draggable-list"));
        List<WebElement> listElements = mainList.findElements(By.tagName("li"));

        for (WebElement li : listElements){
            Assert.assertEquals(li.getAttribute("class"), "right");
        }

    }


}
