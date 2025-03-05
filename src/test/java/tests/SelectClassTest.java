package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelectClassPage;

import java.util.ArrayList;
import java.util.List;

public class SelectClassTest extends BaseTest
{
    SelectClassPage page;



    @BeforeMethod
    public void setup()
    {
        page = new SelectClassPage(driver);
        driver.findElement(By.xpath("//a[text()='Select-class']")).click();
    }

    @Test(testName = "Select number", description = "Verify number shown is the same number that is selected")
    public void testU011()
    {
        Select select = new Select(page.selectNumber);
        String expectedNumber1 = "One";
        String expectedNumber5 = "Five";
        select.selectByVisibleText("One");
        //System.out.println(page.numberSelected.getText());
        Assert.assertEquals(page.numberSelected.getText(), expectedNumber1);


        select.selectByIndex(4);
        //System.out.println(page.numberSelected.getText());
        Assert.assertEquals(page.numberSelected.getText(), expectedNumber5);

        List<String> expectedOptions = new ArrayList<>();
        expectedOptions.add("One");
        expectedOptions.add("Two");
        expectedOptions.add("Three");
        expectedOptions.add("Four");
        expectedOptions.add("Five");
        expectedOptions.add("Six");
        expectedOptions.add("Seven");
        expectedOptions.add("Eight");
        expectedOptions.add("Nine");
        expectedOptions.add("Ten");

        List<WebElement> allOptions = select.getOptions();
        int i = 0;
        for(String each : expectedOptions)
        {
            System.out.println(allOptions.get(i).getText());
            Assert.assertEquals(allOptions.get(i).getText(), each);
            i++;
        }
    }
}
