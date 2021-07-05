package operations;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import operations.BaseElement;

public class HardElement implements BaseElement {
    MobileElement element;

    public HardElement(MobileElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public void setText(String value) {
        if (element instanceof IOSElement) {
            ((IOSElement) element).setValue(value);
        } else {
            element.sendKeys(value);
        }
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    public MobileElement getElement() {
        return element;
    }
}
