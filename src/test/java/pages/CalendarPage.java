package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage
{
    public CalendarPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h1")
    public WebElement displayedDate;
    @FindBy(xpath="//abbr[contains(@aria-label, '19')]")
    public WebElement d19;
}
