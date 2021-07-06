import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    AppiumDriver appiumDriver;
    SoftAssert softAssert;

    @BeforeMethod
    void launch() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.toddle.student");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.toddle.student.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        if (true) {
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else {
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        appiumDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @AfterMethod
    void quit() {
        appiumDriver.quit();
    }

}