package util;

import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class BrowserUtil extends BaseTest
{
    public static void switchToNewWindow(WebDriver driver)
    {
        for(String eachId : driver.getWindowHandles())
        {
            driver.switchTo().window(driver.getWindowHandle()); // necessary?
            if(!eachId.equals(driver.getWindowHandle()))
                driver.switchTo().window(eachId);
        }
    }
}
