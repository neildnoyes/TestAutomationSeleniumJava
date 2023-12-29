package main.java.com.noyes.selenium_java.pages.QAPlayground;

import test.java.com.noyes.selenium_java.utils.PgBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PgVerifyAccount extends PgBase {

    public PgVerifyAccount(WebDriver driver){
        super(driver);
    }

    /**
     * Method: enterCode
     *
     * Gets the code from the span using method below,
     * Then inputs the code into the inputs and waits for success to be reached
     *
     */
    public void enterCode(){

        //get the input code for us to use
        String codeStr = getCode();

        //get the div containing all the inputs
        WebElement inputContainer = driver.findElement(By.xpath("//div[@class='code-container']"));

        //get all of the inputs
        List<WebElement> inputList = inputContainer.findElements(By.tagName("input"));

        //loop inputs and enter the code at that index of the string
        for (int i = 0; i < inputList.size(); i++){
            commonMethods.enterValueWhenVisible(inputList.get(i), String.valueOf(codeStr.charAt(i)), 5);
        }

        //wait for success
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[@class='info success']")));
    }

    /**
     * Method: getCode
     *
     * Gets the code embedded in the html
     *
     * @return String representing the digits in the given confirmation code
     *
     */
    private String getCode(){

        //find the small containing the code
        WebElement smallCode = driver.findElement(By.xpath("//small[@class='info']"));

        //return the code replacing all other characters but digits
        return smallCode.getText().replaceAll("[^0-9]", "");
    }

}
