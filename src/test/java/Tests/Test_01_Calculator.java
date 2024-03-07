package Tests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test_01_Calculator {

    AndroidDriver<AndroidElement>driver;

    @Test
    public void calculatorTest() throws MalformedURLException, InterruptedException {

        // Build the necessary setup.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\murat\\IdeaProjects\\Appium\\Apps\\Calculator_8.4.apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Verify that the app is installed.
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // Verify that the application is opened.
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());

        // Verify on the calculator that 7 times 200 is 1400
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();

        driver.findElementByAccessibilityId("multiply").click();

        driver.findElementByAccessibilityId("7").click();

        driver.findElementByAccessibilityId("equals").click();

        String result = driver.findElementById("com.google.android.calculator:id/result_final").getText();

        Assert.assertEquals(Integer.parseInt(result),1400);

        Thread.sleep(3000);
        driver.quit();
    }
}