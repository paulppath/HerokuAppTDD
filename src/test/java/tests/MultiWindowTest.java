package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MultiWindowPage;
import util.BrowserUtil;

public class MultiWindowTest extends BaseTest
{
    MultiWindowPage page;

    @BeforeMethod
    public void setup()
    {
        page = new MultiWindowPage(driver);
        driver.findElement(By.xpath("//nav/a[text()='Multiple-window']")).click();
    }

    @Test(testName = "Launch TLA window")
    public void testU031()
    {
        String expectTitle = "Coding Boot-camp | Tech Lead Academy";
        //page.launchTLABtn.click();
        page.click(page.launchTLABtn);
        BrowserUtil.switchToNewWindow(driver);
        String actualTitle = driver.getTitle();
        System.out.println("The new window title is : "+ actualTitle);
        // Assert.assertEquals(actualTitle, expectTitle);
        page.assertEquals(actualTitle, expectTitle);
    }
}
