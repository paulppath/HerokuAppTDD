package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BasePage
{
    public AlertPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/h1")
    public WebElement number;
    @FindBy(xpath = "//div/button[@class='btn btn-success m-2']")
    public WebElement incrementAddButton;
    @FindBy(xpath = "//div/button[@class='btn btn-outline-success']")
    public WebElement addByNumberButton;

}
