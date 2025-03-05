package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.*;

public class HomeTest extends BaseTest {
    HomePage page;

    @BeforeMethod
    public void setup() {
        page = new HomePage(driver);
    }

    @Test(testName = "US000 title name", description = "title is TLA Automation")
    public void test000()
    {
        String title = "TLA Automation";
        Assert.assertEquals(driver.getTitle(), title);
        System.out.println(driver.getTitle());
    }

    @Test(testName = "US001 Selenium Image", description = "Selenium Image is displayed")
    public void test001()
    {
        Assert.assertTrue(page.seleniumImage.isDisplayed());
    }

    @Test(testName = "US012 Selenium Image with preset methods")
    public void test012(){page.isDisplayed(page.seleniumImage); }

    @Test(testName = "US002 Selenium Header", description = "Header is the correct word")
    public void test002()
    {
        String expectHeader = "Automation with Selenium";
        // Assert.assertEquals(page.seleniumHeader.getText(), expectHeader);
        page.assertEquals(page.getText(page.seleniumHeader), expectHeader);
        System.out.println("Header is : " + page.seleniumHeader.getText());
    }

    @Test(testName = "US003 Footer links", description = "Footer links' name are correct")
    public void test003()
    {
        List<String> expectedLinksList = new ArrayList<>();
        expectedLinksList.add("PHP Travels");
        expectedLinksList.add("Mercury tours");
        expectedLinksList.add("Internet");
        expectedLinksList.add("E-commerce");
        expectedLinksList.add("Passion Tea Company");
        expectedLinksList.add("Saucedemo");
        expectedLinksList.add("Shopping Cart");

        for(int i = 0; i < expectedLinksList.size(); i++)
        {
            Assert.assertEquals(page.links.get(i).getText(),expectedLinksList.get(i));
        }
    }

    @Test(testName="Varify footlink title")
    public void test004()
    {
        List<String> expectedLinksTitle = new ArrayList<>();
        expectedLinksTitle.add("Book Your Free Demo Now - Phptravels");
        expectedLinksTitle.add("demoaut.com - demoaut Resources and Information.");
        expectedLinksTitle.add("Internet");
        expectedLinksTitle.add("E-commerce");
        expectedLinksTitle.add("Passion Tea Company");
        expectedLinksTitle.add("Saucedemo");
        expectedLinksTitle.add("Shopping Cart");
        String mainID = driver.getWindowHandle();
        System.out.println(mainID);

        System.out.println("links size is : " + page.links.size());

        for(int i = 0; i < page.links.size(); i++)
        {
            driver.switchTo().window(mainID);
            page.links.get(i).click();
            Set<String> allIDs = driver.getWindowHandles();
            System.out.println("allIDs size is : " + allIDs.size());

            Map<String, String> windowOpened = new HashMap<>();

            for(String eachID : allIDs)
            {
                if(!eachID.equals(mainID) && !windowOpened.containsKey(eachID))
                {
                    driver.switchTo().window(eachID);
                    windowOpened.put(eachID, driver.getTitle());
                }
            }
            System.out.println(driver.getTitle());
            System.out.println(windowOpened);
            Assert.assertEquals(expectedLinksTitle.get(i), driver.getTitle());

        }
    }

    @DataProvider(name="footerLink")
    public Object[] data0042()
    {
        Object[] data = new Object[7];

        data[0] = "PHP Travels";
        data[1] = "Mercury tours";
        data[2] = "Internet";
        data[3] = "E-commerce";
        data[4] = "Passion Tea Company";
        data[5] = "Saucedemo";
        data[6] = "Shopping Cart";

        return data;
    }

    @Test(testName="Verify footlink is enable", dataProvider="footerLink")
    public void test0042(String footerLink)
    {
        page.assertTrue(driver.findElement(By.xpath("//a[text()='" + footerLink + "']")).isEnabled());
    }

}
