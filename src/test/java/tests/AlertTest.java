package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTest
{
    AlertPage page;

    @BeforeMethod
    public void setup()
    {
        page = new AlertPage(driver);
        driver.findElement(By.xpath("//a[text()='Alert']")).click();
    }

    @Test(testName = "Increment number alert")
    public void US021()
    {
        // Assert.assertEquals(page.number.getText(),"0");
        page.assertEquals(page.getText(page.number), "0");
        System.out.println(page.number.getText());
        // page.incrementAddButton.click();
        page.click(page.incrementAddButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // Assert.assertEquals(page.number.getText(), "1");
        page.assertEquals(page.getText(page.number), "1");
        System.out.println(page.number.getText());

        page.addByNumberButton.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("3");
        alert1.accept();
        Assert.assertEquals(page.number.getText(), "4");
        System.out.println(page.number.getText());

    }
}
