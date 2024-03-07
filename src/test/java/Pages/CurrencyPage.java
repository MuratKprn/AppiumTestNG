package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrencyPage {

    // com.smartwho.SmartAllCurrencyConverter
    // com.smartwho.SmartAllCurrencyConverter.CurrencyConverter

    public CurrencyPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public WebElement topText;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement firstSearchBox;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public WebElement firstResultArea;

    @FindBy(xpath = "//*[@text='1']")
    public WebElement number1;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement tryResult;

    @FindBy(xpath = "//*[@text='PLN']")
    public WebElement pln;

    @FindBy(xpath = "//*[@text='TRY']")
    public WebElement tl;


}
