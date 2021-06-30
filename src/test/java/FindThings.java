import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FindThings {
    AppiumDriver appiumDriver;
    SoftAssert softAssert;

    String wrongLocator = "//android.widget.TextView[@text=\"Announcementss\"]";
    String correctLocator = "//android.widget.TextView[@text=\"Announcements\"]";

    @BeforeMethod
    void launch() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.toddle.student");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.toddle.student.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        if(true) {
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else {
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void softWrongTest() {
        softAssert = new SoftAssert();

        System.out.println("Soft Wrong Test");
        BaseElement testElement = new ElementFinder(appiumDriver, wrongLocator, ElementFindStrategy.SOFT).load();
        softAssert.assertTrue(testElement.isDisplayed());

        testElement = new ElementFinder(appiumDriver, By.xpath(wrongLocator), ElementFindStrategy.SOFT).load();
        softAssert.assertTrue(testElement.isDisplayed());

        softAssert.assertAll();
    }


    @Test
    public void softCorrectTest() {
        softAssert = new SoftAssert();
        System.out.println("Soft Correct Test");
        BaseElement testElement = new ElementFinder(appiumDriver, correctLocator, ElementFindStrategy.SOFT).load();
        softAssert.assertTrue(testElement.isDisplayed());

        testElement = new ElementFinder(appiumDriver, By.xpath(correctLocator), ElementFindStrategy.SOFT).load();
        softAssert.assertTrue(testElement.isDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void hardCorrectTest() {
        softAssert = new SoftAssert();

        System.out.println("Hard Correct Test");
        BaseElement testElement = new ElementFinder(appiumDriver, correctLocator, ElementFindStrategy.HARD).load();
        softAssert.assertTrue(testElement.isDisplayed());

        testElement = new ElementFinder(appiumDriver, By.xpath(correctLocator), ElementFindStrategy.HARD).load();
        softAssert.assertTrue(testElement.isDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void hardWrongTest()  {
        softAssert = new SoftAssert();

        System.out.println("Hard Wrong Test");
        BaseElement testElement = new ElementFinder(appiumDriver, wrongLocator, ElementFindStrategy.HARD).load();
        softAssert.assertTrue(testElement.isDisplayed());

        testElement = new ElementFinder(appiumDriver, By.xpath(wrongLocator), ElementFindStrategy.HARD).load();
        softAssert.assertTrue(testElement.isDisplayed());

        softAssert.assertAll();
    }

    @AfterMethod
    void quit() {
        appiumDriver.quit();
    }

}
