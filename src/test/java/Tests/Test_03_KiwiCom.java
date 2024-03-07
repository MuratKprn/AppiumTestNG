package Tests;

import Pages.KiwiPage;
import Utilities.Driver;
import Utilities.Reusable;
import Utilities.Reusable.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_03_KiwiCom {

    AndroidDriver<AndroidElement>driver = Driver.getAndroidDriver();

    KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void kiwiTest() throws InterruptedException {

        // Verify that the app has been installed successfully.
        Assert.assertTrue(driver.isAppInstalled(Reusable.GetAppPackage()));

        // Verify that the application has been opened successfully.
        Assert.assertTrue(kiwiPage.asAGuestButton.isDisplayed());

        // "Continue as guest" is clicked.
        kiwiPage.asAGuestButton.click();

        // Continue in the next 3 steps by pressing the green button.
        TouchAction action = new TouchAction(driver);

        Thread.sleep(1000);

        Reusable.coordinatePress(532,2058,800,3);

        // Trip type is selected as one way.
        kiwiPage.tripTypeButton.click();
        kiwiPage.oneWayButton.click();

        // click on the departure country option and the default country is removed.
        kiwiPage.departureCity.click();

        kiwiPage.clearAll.click();

        // Enter the country/city(Istanbul) from which you will depart and click on select.
        Reusable.coordinatePress(253,283,800,1);

        Actions actions = new Actions(driver);
        actions.sendKeys("Istanbul").perform();
        Thread.sleep(1000);
        Reusable.coordinatePress(266,410,800,1);

        kiwiPage.chooseButton.click();

        // click on the destination country option and enter the country(Madrid).
        kiwiPage.toArea.click();

        actions.sendKeys("Madrid").perform();

        Reusable.coordinatePress(305,410,800,1);

        kiwiPage.chooseButton.click();

        // Select the departure date as the 21st of September and click on set date.
        Reusable.coordinatePress(244,1177,800,1);
        Thread.sleep(1000);
        Reusable.scrollDown(800,5);
        Thread.sleep(1000);
        Reusable.coordinatePress(963,536,800,1);
        Thread.sleep(1000);
        Reusable.coordinatePress(689,2075,800,1);
        Thread.sleep(1000);

        //click on the search button
        kiwiPage.searchButton.click();

        //cheapest and non-transfer filtering is done
        Reusable.coordinatePress(153,379,800,1);
        Reusable.coordinatePress(200,650,800,1);
        Thread.sleep(1000);
        Reusable.coordinatePress(423,375,800,1);
        Reusable.coordinatePress(170,1810,800,1);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    }
}