package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    @DataProvider
    public Object[][] notNumData()
    {
        Object[][] data = new Object[3][3];
        data[0][0] = "F";
        data[0][1] = "4";
        data[0][2] = "a and b must be numeric!";
        data[1][0] = "5";
        data[1][1] = "K";
        data[1][2] = "a and b must be numeric!";
        data[2][0] = "5F";
        data[2][1] = "8K";
        data[2][2] = "a and b must be numeric!";


        return data;
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
    @Test(testName="US0102", description="Verify proper sum after enter values")
    public void testUS0102()
    {
        String a = "3";
        String b = "4";
        String total = "7";
        page.sendKeys(page.inputBoxA, a);
        page.sendKeys(page.inputBoxB, b);
        page.click(page.getTotalBtn);
        page.assertEquals(page.total.getText(), total);
    }
    @Test(testName="US0103", description="Verify alert text  after enter non numeric data",
            dataProvider="notNumData")
    public void testUS0103(String a, String b, String expectedAlertText)
    {
        String expectAlertText = "a and b must be numeric!";
        page.sendKeys(page.inputBoxA, a);
        page.sendKeys(page.inputBoxB, b);
        page.click(page.getTotalBtn);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        page.assertEquals(alertText, expectAlertText);
        alert.accept();
    }
}
