package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IFramePage;

public class IFrameTest extends BaseTest
{
    IFramePage page;

    @BeforeMethod
    public void setUp()
    {
        page = new IFramePage(driver);
        driver.findElement(By.xpath("//nav/a[text()='iFrames']")).click();
    }

    @Test(testName="US601 Note iFrames", description="Verify note is successfully save")
    public void test601()
    {
        String expectedTitle = "Shopping List";
        String expectedNote = "Milk";
        String expectedTitle2 = "To Do List";
        String expectedNote2 = "Shopping";

        try {
            driver.switchTo().frame("note");
            enterNote(expectedTitle, expectedNote);
            Thread.sleep(500);
            page.assertEquals(page.notes.get(0).getText(), expectedTitle);

            enterNote(expectedTitle2, expectedNote2);
            Thread.sleep(500);
            for (WebElement e : page.notes) {
                System.out.println(e.getText());
            }

            page.assertEquals(page.notes.get(1).getText(), expectedTitle2);
        }catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    public void enterNote(String title, String note)
    {
        page.newNote.click();
        page.noteTitle.sendKeys(title);
        page.textArea.sendKeys(note);
        page.saveButton.click();
    }
}
