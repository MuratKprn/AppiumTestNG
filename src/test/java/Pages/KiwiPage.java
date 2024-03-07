package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiwiPage {

    // com.skypicker.main
    // com.kiwi.android.feature.splash.impl.ui.SplashActivity

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement asAGuestButton;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement tripTypeButton;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement departureCity;

    @FindBy(xpath = "//*[@content-desc='Clear All']")
    public WebElement clearAll;

    @FindBy(xpath = "(//*[@class='android.view.View'])[4]")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public WebElement destinationCity;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement toArea;

    @FindBy(xpath = "//*[@text='Set date'")
    public WebElement SetDateButton;

    @FindBy(xpath = "//*[@text='Search'")
    public WebElement searchButton;







}