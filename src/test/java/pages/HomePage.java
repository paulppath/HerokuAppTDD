package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/img[contains(@src,\'selenium\') and contains(@src,\'.png\')]")
    public WebElement seleniumImage;

    @FindBy(xpath="//h1[@id='title']")
    public WebElement seleniumHeader;

    @FindBy(xpath="//a[starts-with(@href,\"http\")]")
    public List<WebElement> links;

}
