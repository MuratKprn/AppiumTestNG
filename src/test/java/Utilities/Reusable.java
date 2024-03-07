package Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Reusable {

    public static String scrollToElement(String elementText){

        return "new UiScrollable" +
               "(new UiSelector().scrollable(true)." +
               "instance(0)).scrollIntoView(new UiSelector().text(\""+
               elementText+"\").instance(0))";
    }

    public static void scrollWithUiScrollableAndClick(String elementText){

        AndroidDriver driver = (AndroidDriver) Driver.getAndroidDriver();

        String element =  "new UiScrollable" +
                          "(new UiSelector().scrollable(true)." +
                          "instance(0)).scrollIntoView(new UiSelector().text(\""+
                           elementText+"\").instance(0))";

        driver.findElementByAndroidUIAutomator(element).click();
    }

    public static String GetAppPackage (){

        return ConfigReader.getProperty("AppPackage");
    }

    public static String GetAppActivity (){

        return ConfigReader.getProperty("AppActivity");
    }

    public static void coordinatePress(int x,int y,int ms,int z) throws InterruptedException {

        Thread.sleep(1000);

        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());

        for (int i = 1; i <= z ; i++) {
            action.press(PointOption.point(x,y))
                    .release()
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(ms)))
                    .perform();
        }
    }

    public static void scrollDown(int ms, int z) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        Thread.sleep(1000);
        for (int i = 1; i <= z; i++) {
            action.press(PointOption.point(480,1561))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(ms)))
                    .moveTo(PointOption.point(480,70))
                    .release()
                    .perform();

        }
    }

    public static void scrollUp(int ms, int z) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        Thread.sleep(1000);
        for (int i = 1; i <= z; i++) {
            action.press(PointOption.point(480,70))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(ms)))
                    .moveTo(PointOption.point(480,1561))
                    .release()
                    .perform();

        }
    }




}