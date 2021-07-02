package screenshotUtil;

import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;

public class ElementScreenshot {

    public ElementScreenshot() {
    }

    public String take(MobileElement element, String name, String path) {
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        name = name + ".png";
        String finalPath = new File(path).getAbsolutePath() + File.separator + name;
        File screenShotPath = new File(finalPath);
        try {
            FileUtils.copyFile(scrFile, screenShotPath);
            System.out.println(String.format("Successfully element screenshot created by name %s at path %s", name, finalPath));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't write file %s, are permissions OK?", path), e);
        }
        return finalPath;
    }
}
