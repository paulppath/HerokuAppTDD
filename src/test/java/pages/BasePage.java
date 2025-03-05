package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;
import util.ConfigReader;

import static java.lang.Thread.sleep;

public class BasePage extends BaseTest
{
    WebDriver driver;
    public BasePage(WebDriver driver){this.driver = driver;}
    public void highlightElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 2; i++)
        {
            try {
                if (i % 2 == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                    if (ConfigReader.readProperty("config.properties", "takeScreenshots").equalsIgnoreCase("true"))
                        BaseTest.reportManager.logScreenshot();
                } else {
                    sleep(600);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void sendKeys(WebElement element, String inputText)
    {
        scrollIntoView(element, driver);
        BaseTest.reportManager.logLocatorInfo("Entered text: " + inputText + " ", element);
        element.sendKeys(inputText);
        highlightElement(element);
    }
    public String getText (WebElement element)
    {
        BaseTest.reportManager.logLocatorInfo("Retrieved TEXT: ", element);
        highlightElement(element);
        return element.getText();
    }
    public void click(WebElement element)
    {
        scrollIntoView(element, driver);
        BaseTest.reportManager.logLocatorInfo("Clicked on a BUTTON: ", element);
        highlightElement(element);
        waitForClickAbility(element);
        element.click();
    }
    public void assertEquals(String actual, String expected)
    {
        BaseTest.reportManager.logInfo("Expected: " + expected);
        BaseTest.reportManager.logInfo("Actual: " + actual);
        Assert.assertEquals(actual, expected);
    }
    public void assertTrue(boolean condition)
    {
        BaseTest.reportManager.logInfo("Condition: " + condition);
        Assert.assertTrue(condition);
    }
    public void isDisplayed(WebElement element)
    {
        scrollIntoView(element, driver);
        BaseTest.reportManager.logLocatorInfo("Displayed at: ", element);
        highlightElement(element);
        Assert.assertTrue(element.isDisplayed());
    }
    public void waitForClickAbility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollIntoView(WebElement element, WebDriver driver)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

}
