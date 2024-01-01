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

public class PgMultilevelDropdown extends PgBase {

    //Expected List of Animals & Settings
    String[] animalList = { "Kangaroo", "Frog", "Horse", "Hedgehog" };
    String[] settingsList = { "HTML", "CSS", "JavaScript", "Awesome!" };

    public PgMultilevelDropdown(WebDriver driver){
        super(driver);
    }

    /**
     * Method: openMenus
     *
     * Opens the dropdown menus from the navbar
     *
     */
    private void toggleMenus(){

        //find navbar list
        WebElement navbarList = driver.findElement(By.xpath("//nav/ul"));
        List<WebElement> navbarListItems = navbarList.findElements(By.tagName("li"));

        //click the last one
        commonMethods.clickWhenVisible(By.xpath("//nav/ul/li[" + navbarListItems.size() + "]/a"));

    }

    /**
     * Method: verifySettings
     *
     * Opens the settings dropdown submenu and verifies against the master list
     *
     * Expects main menu div to be visible
     *
     */
    public void verifySettings(){

        //open menu
        toggleMenus();

        //click settings submenu link
        commonMethods.clickWhenVisible(By.cssSelector("a[href='#settings'"), 20);

        //wait for submenu to appear
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Tutorial']")));

        //get div for the settings submenu
        WebElement settingsDiv = driver.findElement(By.xpath("//nav/ul/li/div/div"));

        //get all elements from submenu
        List<WebElement> settings = settingsDiv.findElements(By.tagName("a"));

        //loop through settings to match with master list
        for (int i = 1; i < settings.size(); i++){
            Assert.assertEquals(settings.get(i).getText(), settingsList[i-1]);
        }

        //close menu
        toggleMenus();
    }

    /**
     * Method: verifyAnimals
     *
     * Opens the animals dropdown submenu and verifies against the master list
     *
     * Expects main menu div to be visible
     *
     */
    public void verifyAnimals(){

        //open menu
        toggleMenus();

        //click settings submenu link
        commonMethods.clickWhenVisible(By.cssSelector("a[href='#animals'"), 20);

        //wait for submenu to appear
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Animals']")));

        //get div for the animals submenu
        WebElement animalsDiv = driver.findElement(By.xpath("//nav/ul/li/div/div"));

        //get all elements from submenu
        List<WebElement> animals = animalsDiv.findElements(By.tagName("a"));

        //loop through animal to match with master list
        for (int i = 1; i < animals.size(); i++){
            Assert.assertEquals(animals.get(i).getText().replaceAll("[^a-zA-Z]", ""), animalList[i-1]);
        }

        //close menu
        toggleMenus();
    }


}
