package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InputPage;

public class InputTest extends BaseTest
{
    InputPage page;
    @BeforeMethod
    public void setup()
    {
        page = new InputPage(driver);
        driver.findElement(By.xpath("//nav/a[text()='Inputs']")).click();
    }

    @Test(testName="US0101", description="Verify a word with 240 characters")
    public void testUS0101()
    {
        String data = "aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuuvvvvvwwwwwxxxxxyyyyyzzzzz";
        page.sendKeys(page.messageBox, data);
        page.click(page.showMessageBtn);
        String actualText = page.getText(page.message);
        page.assertEquals(actualText, data);
        driver.findElement(By.xpath("//div/span[@name='message1']")).isDisplayed();
        page.isDisplayed(page.message);
    }
}
