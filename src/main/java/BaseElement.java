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
