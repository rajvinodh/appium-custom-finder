import org.testng.*;
import org.testng.annotations.*;
import recordings.*;

import java.io.*;

public class TestJsonInitializerPojo {

    @Test
    public void testJsonInitializer() throws IOException {
        File jsonFile = new File("src/main/java/recordings/Image_Recordings/Sample/sample.json");
        JSONInitializers jsonInitializers = new JSONInitializers(jsonFile);

        System.out.println("verify if pojo is initialised with element name : continue_button");
        Assert.assertEquals(jsonInitializers.elementRecordPOJO.getElement_name(),"continue_button","Element name is not initialized as expected");
    }

    @Test
    public void testJsonUpdate() throws IOException {
        File jsonFile = new File("src/main/java/recordings/Image_Recordings/Sample/sample.json");
        JSONInitializers jsonInitializers = new JSONInitializers(jsonFile);

        System.out.println("verify if pojo is initialised with strategy value : DEFAULT");
        Assert.assertEquals(jsonInitializers.elementRecordPOJO.getStrategy(),"DEFAULT","strategy is not initialized as expected");

        System.out.println("set strategy value as CUSTOM");
        jsonInitializers.elementRecordPOJO.setStrategy("CUSTOM");

        System.out.println("verify if pojo is initialised with element name : continue_button");
        Assert.assertEquals(jsonInitializers.elementRecordPOJO.getStrategy(),"CUSTOM","strategy is not initialized as expected");

        System.out.println("set strategy value as DEFAULT");
        jsonInitializers.elementRecordPOJO.setStrategy("DEFAULT");
    }
}
