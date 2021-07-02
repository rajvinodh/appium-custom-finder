package finder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import operations.BaseElement;
import operations.HardElement;
import operations.SoftElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ElementFinder {
    AndroidDriver androidDriver;
    IOSDriver iosDriver;
    String locator;
    By mobileBy;
    ElementFindStrategy strategy;
    DriverType driverType;

    public ElementFinder(AppiumDriver driver, String locator, ElementFindStrategy strategy) {
        setPlatform(driver);
        mobileBy = findAppropriateBy(locator);
        this.locator = locator;
        this.strategy = strategy;
    }

    public ElementFinder(AppiumDriver driver, By mobileBy, ElementFindStrategy strategy) {
        setPlatform(driver);
        this.mobileBy = mobileBy;
        this.strategy = strategy;
    }

    public BaseElement load() {
        try {
            return new HardElement((MobileElement) getCurrentDriver().findElement(mobileBy));
        } catch (NoSuchElementException noSuchElementException) {
            if(strategy == ElementFindStrategy.SOFT) {
                return new SoftElement();
            } else {
                throw noSuchElementException;
            }
        }
    }

    public By findAppropriateBy(String selector) {
        if (selector.startsWith("//") || selector.startsWith("(")) {
            return By.xpath(selector);
        } else if (selector.contains("~")) {
            selector = selector.replace("~", "");
            return MobileBy.AccessibilityId(selector);
        } else {
            return MobileBy.id(selector);
        }
    }

    public void setPlatform(AppiumDriver driver) {
        if(driver instanceof AndroidDriver) {
            androidDriver = (AndroidDriver) driver;
            driverType = DriverType.ANDROID;
        } else {
            iosDriver = (IOSDriver) driver;
            driverType = DriverType.IOS;
        }
    }

    public AppiumDriver getCurrentDriver() {
        return (this.driverType == DriverType.ANDROID) ? androidDriver : iosDriver;
    }
}