package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectClassPage extends BasePage
{
    public SelectClassPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@class='custom-select']")
    public WebElement selectNumber;

    @FindBy(xpath = "//div[@id='select1-selected-value']/span")
    public WebElement numberSelected;
}
