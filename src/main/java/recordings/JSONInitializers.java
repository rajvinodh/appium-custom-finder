package recordings;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;

import java.io.*;

public class JSONInitializers {

        ObjectMapper objectMapper;
        public ElementRecordPOJO elementRecordPOJO;
        File jsonFile = new File("src/main/java/recordings/ImageRecordings/Login/login.json");

        public JSONInitializers() throws IOException {
            objectMapper = new ObjectMapper();
            elementRecordPOJO = objectMapper.readValue(jsonFile, ElementRecordPOJO.class);
        }

        public String writeRequest() throws IOException {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String request = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(elementRecordPOJO);
//            logger.info("Request Json : \n" + request);
            try{

                FileWriter fw = new FileWriter(jsonFile.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(request);
                bw.close();

                System.out.println("Done");
            }catch(IOException e){
                e.printStackTrace();
            }
            return request;
        }
}

