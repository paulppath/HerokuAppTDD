package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TablePage;

import java.util.ArrayList;
import java.util.List;

public class TableTest extends BaseTest
{
    TablePage page;

    @BeforeMethod
    public void setUp()
    {
        page = new TablePage(driver);
        driver.findElement(By.xpath("//a[text()=\"Tables\"]")).click();
    }

    @DataProvider(name="expectedEmail")
    public Object[] data01()
    {
        Object[] data = new Object[1];

        List<String> data1 = new ArrayList<>();
        data1.add("olko@no.eg");
        data1.add("nomzo@cilipu.qa");
        data1.add("muvji@uf.mu");
        data1.add("wiuk@koufhep.fk");
        data1.add("jipum@uf.bz");
        data1.add("sef@oza.tl");
        data1.add("vu@ih.ec");
        data1.add("hulitogi@unu.bh");
        data1.add("golsowka@lid.ai");
        data1.add("mewepiz@ev.bv");

        data[0] = data1;

        return data;
    }
    @DataProvider(name="EachRollData")
    public Object[] data02()
    {
        Object[][] data2 = new Object[2][7];
        data2[0][0] = "Cedric";
        data2[0][1] = "Kim";
        data2[0][2] = "Female";
        data2[0][3] = "57";
        data2[0][4] = "11552";
        data2[0][5] = "muvji@uf.mu";
        data2[0][6] = "3";

        data2[1][0] = "Aiko";
        data2[1][1] = "Crabtree";
        data2[1][2] = "Male";
        data2[1][3] = "29";
        data2[1][4] = "50310";
        data2[1][5] = "jipum@uf.bz";
        data2[1][6] = "5";

        return data2;
    }


    @Test(testName="Test all email", dataProvider="expectedEmail")
    public void US500(List<String> expectedEmails)
    {
        for (int i = 0; i < expectedEmails.size(); i++)
        {
            page.assertEquals(page.emails.get(i).getText(), expectedEmails.get(i));
            System.out.println("Actual: " + page.emails.get(i).getText() + " , Expected; " + expectedEmails.get(i));
        }
    }

    @Test(testName="Test rolls of data", dataProvider="EachRollData")
    public void US5001(String firstName, String lastName, String gender, String age, String zip, String email, String roll)
    {
        List<WebElement> actualData = driver.findElements(By.xpath("//tr[" + roll + "]/*"));
        for(WebElement e : actualData)
        {
            System.out.println(e.getText());
        }

        page.assertEquals(actualData.get(0).getText(), firstName);
        page.assertEquals(actualData.get(1).getText(), lastName);
        page.assertEquals(actualData.get(2).getText(), gender);
        page.assertEquals(actualData.get(3).getText(),age);
        page.assertEquals(actualData.get(4).getText(), zip);
        page.assertEquals(actualData.get(5).getText(), email);
    }
}
