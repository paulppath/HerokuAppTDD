package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IFramePage extends BasePage
{
    public IFramePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@class='note-title'] ")
    public WebElement noteTitle;
    @FindBy(xpath="//textarea[@class='note-textarea'] ")
    public WebElement textArea;
    @FindBy(xpath="//i[@class='fas fa-save text-light save-note']")
    public WebElement saveButton;
    @FindBy(xpath="//li[@class='list-group-item']/span")
    public List<WebElement> notes;
    @FindBy(xpath="//i[@class='fas fa-pen text-light new-note']")
    public WebElement newNote;

}
