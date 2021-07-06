package operations;

import finder.ElementFindStrategy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public interface BaseElement {

    void click();

    void clear();

    void setText(String value);

    String getAttribute(String name);

    boolean isSelected();

    boolean isEnabled();

    boolean isDisplayed();

    String getText();
}
