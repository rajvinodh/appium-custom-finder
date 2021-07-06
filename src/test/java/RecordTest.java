import execute.ExecuteMobileCommand;
import finder.ElementFindStrategy;
import finder.ElementFinder;
import io.appium.java_client.MobileElement;
import operations.BaseElement;
import operations.HardElement;
import org.testng.annotations.Test;
import screenshotUtil.ElementScreenshot;
import screenshotUtil.ImageConverter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class RecordTest extends BaseTest {

    String announcementsElement = "//android.widget.TextView[@text=\"Announcements\"]";
    ElementScreenshot elementScreenshot;
    ExecuteMobileCommand executeMobileCommand;

    @Test
    void recordAndTest () throws IOException, URISyntaxException, InterruptedException {
        String fileName = "test";
        String folderName = "./testFolder";
        String fullPath = new File(folderName + File.separator + fileName + ".png").getAbsolutePath();
        elementScreenshot = new ElementScreenshot();
        executeMobileCommand = new ExecuteMobileCommand(appiumDriver);

        Map<String, String> deviceInfo = (Map<String, String>) executeMobileCommand.execute(ExecuteMobileCommand.MobileComamnd.DEVICE_INFO);
        String realDisplaySize = deviceInfo.get("realDisplaySize");
        System.out.println(String.format("Display size: %s" , realDisplaySize));

        HardElement announcementElement = (HardElement) new ElementFinder(appiumDriver, announcementsElement, ElementFindStrategy.HARD).load();
        String path = elementScreenshot.take(announcementElement.getElement(), fileName, folderName);

        MobileElement element = (MobileElement) appiumDriver.findElementByImage(new ImageConverter().getReferenceImageB64(fullPath));
        element.click();

        Thread.sleep(15000);
    }
}
