package screenshotUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ImageConverter {

    public String getReferenceImageB64(String imgPath) throws URISyntaxException, IOException {
//        URL refImgUrl = getClass().getClassLoader().getResource(imgPath);
        File refImgFile = new File(imgPath);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }
}
