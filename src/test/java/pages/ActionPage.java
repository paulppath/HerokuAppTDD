package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionPage extends BasePage
{
    public ActionPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//nav/a[text()='Action-class']")
    public WebElement actionNavBtn;
    @FindBy(xpath="//div/button[@class='btn btn-success btn-lg m-2']")
    public WebElement hoverOverForTipBtn;
    @FindBy(xpath="//div/div[@data-id='tooltip']")
    public WebElement popupText;
}
