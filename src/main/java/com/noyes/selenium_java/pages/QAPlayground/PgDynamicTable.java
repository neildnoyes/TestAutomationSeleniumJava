package main.java.com.noyes.selenium_java.pages.QAPlayground;

import test.java.com.noyes.selenium_java.utils.PgBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PgDynamicTable extends PgBase {

    public PgDynamicTable(WebDriver driver){
        super(driver);
    }

    /**
     * Method: FindHero
     *
     * @param heroName - String representing the name of the superhero we want to find
     *
     */
    public void findHero(String heroName, String expectedRealName){

        //find table
        WebElement table = driver.findElement(By.xpath("//table/tbody"));

        //get all the rows from the table dynamically
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        //loop rows
        for (int i = 1; i < rows.size(); i++){

            String hero_dynamic_xpath = "//table/tbody/tr[" + i + "]/td/div/div[2]/div[1]";
            String real_dynamic_xpath = "//table/tbody/tr[" + i + "]/td[3]/span";

            WebElement rowHeroName = driver.findElement(By.xpath(hero_dynamic_xpath));
            WebElement rowRealName = driver.findElement(By.xpath(real_dynamic_xpath));

            if (rowHeroName.getText().equalsIgnoreCase(heroName)){

                System.out.println("Hero Name: " + heroName);
                System.out.println("Expected Name: " + expectedRealName);

                Assert.assertEquals(rowRealName.getText(), expectedRealName);
            }

        }

    }

}
