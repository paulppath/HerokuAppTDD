package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ActionPage;

public class ActionTest extends BaseTest
{
    ActionPage page;

    @BeforeMethod
    public void setup()
    {
        page = new ActionPage(driver);
        driver.findElement(By.xpath("//nav/a[text()='Action-class']")).click();
    }

    @Test(testName="Hover over buttion", description="To Verify text message pop up after hover over the button")
    public void US0401()
    {
        try{
            String popUpText;
            page.hoverOver(page.hoverOverForTipBtn);
            Thread.sleep(1000);
            popUpText = page.getText(page.popupText);
            System.out.println(popUpText);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
