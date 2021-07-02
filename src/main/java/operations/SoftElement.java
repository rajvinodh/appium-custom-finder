package operations;

import operations.BaseElement;

public class SoftElement implements BaseElement {

    public SoftElement() {
        System.err.println("WARNING : operations.SoftElement instance is created, which indicates potential Bug.");
    }

    @Override
    public void click() {
        System.err.println("ATTENTION!!! Soft Element missing, So unable to click");
    }

    @Override
    public void clear() {
        System.err.println("ATTENTION!!! Soft Element missing, So unable to clear text field");
    }

    @Override
    public void setText(String value) {
        System.err.println("ATTENTION!!! Soft Element missing, So unable to enter the text");
    }

    @Override
    public String getAttribute(String name) {
        return "";
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public String getText() {
        return "";
    }
}
