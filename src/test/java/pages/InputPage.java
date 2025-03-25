package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputPage extends BasePage
{
    public InputPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//nav/a[text()='Inputs']")
    public WebElement inputsNavBtn;
    @FindBy(xpath="//form/input[@class='form-control'][@id='message']")
    public WebElement messageBox;
    @FindBy(xpath="//form/button[@name='button1']")
    public WebElement showMessageBtn;
    @FindBy(xpath="//div/span[@name='message1']")
    public WebElement message;
    @FindBy(xpath="//input[@id='a']")
    public WebElement inputBoxA;
    @FindBy(xpath="//input[@id='b']")
    public WebElement inputBoxB;
    @FindBy(xpath="//button[@name='button2']")
    public WebElement getTotalBtn;
    @FindBy(xpath="//span[@name='answer2']")
    public WebElement total;

}
