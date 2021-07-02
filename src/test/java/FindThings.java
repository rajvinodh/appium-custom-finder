import finder.ElementFindStrategy;
import finder.ElementFinder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import operations.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FindThings extends BaseTest {

    String wrongLocator = "//android.widget.TextView[@text=\"Announcementss\"]";
    String correctLocator = "//android.widget.TextView[@text=\"Announcements\"]";

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
}
