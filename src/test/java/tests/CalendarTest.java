package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarTest extends BaseTest
{
    CalendarPage page;

    @BeforeMethod
    public void setup()
    {
        page = new CalendarPage(driver);
        driver.findElement(By.xpath("//nav/a[text()='Calendar']")).click();
    }

    @Test(testName="Default date", description="Validate default date is display as today date.")
    public void US0201()
    {
        String today = todayDate();
        System.out.println(today);
        String displayedDate = page.displayedDate.getText();
        System.out.println(refineDate(displayedDate));
        displayedDate = refineDate(displayedDate);
        page.assertEquals(displayedDate, today);
    }

    @Test(testName="Validation of displayed date after clicking a date on the calendar")
    public void US0202()
    {
        String today = todayDate();
        page.d19.click();
        System.out.println("Today date: " + today);
        String expectedDate = setExpectedDate(today);
        System.out.println("Expected date: " + expectedDate);
        String displayedDate = page.displayedDate.getText();
        System.out.println(refineDate(displayedDate));
        displayedDate = refineDate(displayedDate);
        page.assertEquals(displayedDate, expectedDate);
    }


    public static String refineDate(String date)
    {
        String[] strs = date.split("/");
        if (strs[0].length() < 2) {
            strs[0] = "0" + strs[0];
        }
        if (strs[1].length() < 2) {
            strs[1] = "0" + strs[1];
        }
        return strs[0] + "/" + strs[1] + "/" + strs[2];
    }
    public static String setExpectedDate(String date)
    {
        String[] strs = date.split("/");
        strs[1] = "19";
        return strs[0] + "/" + strs[1] + "/" + strs[2];
    }
    public static String todayDate()
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate todayDate = LocalDate.now();
        String date = todayDate.format(f);
        return date;
    }
}
