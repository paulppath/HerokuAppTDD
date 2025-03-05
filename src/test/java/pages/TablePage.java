package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage extends BasePage
{
    public TablePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[6]")
    public List<WebElement> emails;
    @FindBy(xpath = "//tr[3]")
    public List<WebElement> roll3Data;
    @FindBy(xpath = "//tr[5]")
    public List<WebElement> roll5Data;
}
