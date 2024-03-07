package Tests;
import Utilities.Reusable;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_02_ArabamCom {

    AndroidDriver<AndroidElement>driver;

    @BeforeTest
    public void arabamSetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {

        // Verify that the app has been installed successfully.
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // Verify that the application has been opened successfully.
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

        // Click on the "ilan ara" button from the bottom menu.
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // "Otomobil" is selected as the category.
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // "Volkswagen" is chosen as the vehicle.
        String VolkswagenElement = Reusable.scrollToElement("Volkswagen");
        driver.findElementByAndroidUIAutomator(VolkswagenElement).click();

        // "Passat" is chosen as the vehicle brand.
        driver.findElementByXPath("//*[@text='Passat']").click();

        // "1.4 TSI BlueMotion" is selected
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // "Comfortline" package is selected
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Filtering is done by sorting from "Ucuzdan Pahalıya".
        driver.findElementById("com.dogan.arabam:id/textViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // It has been confirmed that the cheapest vehicle arriving is cheaper than "500,000 TL".
        String cheapestVehicle = driver.findElementById("com.dogan.arabam:id/tvPrice").getText();
        String purePrice = cheapestVehicle.replaceAll("\\D", "");

        Assert.assertTrue(Integer.parseInt(purePrice)<500000);
    }
}