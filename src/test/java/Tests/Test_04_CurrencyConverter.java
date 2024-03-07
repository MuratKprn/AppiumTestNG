package Tests;

import Pages.CurrencyPage;
import Utilities.Driver;
import Utilities.Reusable;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.FileAssert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Test_04_CurrencyConverter {

    AndroidDriver<AndroidElement>driver = Driver.getAndroidDriver();
    CurrencyPage currencyPage = new CurrencyPage();

    @Test
    public void currencyConverterTest01 () throws InterruptedException, IOException {

        // Verify that the app has been installed successfully.
        Assert.assertTrue(driver.isAppInstalled(Reusable.GetAppPackage()));

        // Verify that the application has been opened successfully.
        currencyPage.topText.isDisplayed();

        // The currency to be converted must be selected as Zloty.
        Thread.sleep(1000);
        Reusable.coordinatePress(83,471,600,1);
        Thread.sleep(1000);
        Reusable.coordinatePress(253,488,600,1);
        Thread.sleep(1000);

        if (!driver.isKeyboardShown()){
            currencyPage.firstSearchBox.sendKeys("Zloty");
        } else {
            driver.getKeyboard().pressKey("Zloty");
        }

        currencyPage.firstResultArea.click();

        // The converted currency must be selected as TRY.
        Thread.sleep(1000);
        Reusable.coordinatePress(83,663,600,1);
        Thread.sleep(1000);
        Reusable.coordinatePress(222,484,600,1);
        Thread.sleep(1000);

        if (!driver.isKeyboardShown()){
            currencyPage.firstSearchBox.sendKeys("TRY");
        } else {
            driver.getKeyboard().pressKey("TRY");
        }

        currencyPage.firstResultArea.click();


        currencyPage.number1.click();

        // Converted amount is saved as screenshot.
        File screenshot =driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\murat\\IdeaProjects\\Appium\\Screenshots\\cc.png");
        FileUtils.copyFile(screenshot,destFile);

        // TRY value of Zloty is saved
        String tryResult = currencyPage.tryResult.getText();

        System.out.println(tryResult);

        // User is notified via SMS.
        driver.sendSMS("55555555555555","1 ZLOTY = " + tryResult + "TRY");
    }

    @Test
    public void currencyConverterTest02 () throws IOException, InterruptedException {

        // Verify that the app has been installed successfully.
        Assert.assertTrue(driver.isAppInstalled(Reusable.GetAppPackage()));

        // Verify that the application has been opened successfully.
        currencyPage.topText.isDisplayed();

        // The currency to be converted must be selected as Zloty.
        TouchAction action = new TouchAction<>(driver);

        Reusable.coordinatePress(205,475,600,1);

        for (int i = 0; i < 3; i++) {

            action.press(PointOption.point(290,388))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(290,1945))
                    .release()
                    .perform();
        }
        Thread.sleep(1000);

        currencyPage.pln.click();

        // The converted currency must be selected as TRY.
        Reusable.coordinatePress(177,657,600,1);

        for (int i = 0; i < 8; i++) {

            action.press(PointOption.point(250,1945))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(290,388))
                    .release()
                    .perform();
        }
        Thread.sleep(1000);

        currencyPage.tl.click();

        currencyPage.number1.click();

        // Converted amount is saved as screenshot.
        File screenshot =driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\murat\\IdeaProjects\\Appium\\Screenshots\\cc.png");
        FileUtils.copyFile(screenshot,destFile);

        // TRY value of Zloty is saved
        String tryResult = currencyPage.tryResult.getText();

        System.out.println(tryResult);

        // User is notified via SMS.
        driver.sendSMS("55555555555555","1 ZLOTY = " + tryResult + "TRY");
    }

    @Test
    public void currencyConverterTest03 () throws IOException, InterruptedException {

        // Verify that the app has been installed successfully.
        Assert.assertTrue(driver.isAppInstalled(Reusable.GetAppPackage()));

        // Verify that the application has been opened successfully.
        currencyPage.topText.isDisplayed();

        // The currency to be converted must be selected as Zloty.
        Reusable.coordinatePress(205,475,600,1);

        String pln = Reusable.scrollToElement("PLN");
        driver.findElementByAndroidUIAutomator(pln).click();

        // The converted currency must be selected as TRY.
        Reusable.coordinatePress(177,657,600,1);

        String tl = Reusable.scrollToElement("TRY");
        driver.findElementByAndroidUIAutomator(tl).click();

        currencyPage.number1.click();

        // Converted amount is saved as screenshot.
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\murat\\IdeaProjects\\Appium\\Screenshots\\cc.png");
        FileUtils.copyFile(screenshot,destFile);

        // TRY value of Zloty is saved
        String tryResult = currencyPage.tryResult.getText();

        System.out.println(tryResult);

        // User is notified via SMS.
        driver.sendSMS("55555555555555","1 ZLOTY = " + tryResult + "TRY");
    }

    @Test
    public void currencyConverterTest04 () throws IOException, InterruptedException {

        // Verify that the app has been installed successfully.
        Assert.assertTrue(driver.isAppInstalled(Reusable.GetAppPackage()));

        // Verify that the application has been opened successfully.
        currencyPage.topText.isDisplayed();

        // The currency to be converted must be selected as Zloty.
        Reusable.coordinatePress(205,475,600,1);


    }


}