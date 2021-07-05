package recordings;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import recordings.pojo.*;

import java.io.*;

public class JSONInitializers {

        ObjectMapper objectMapper;
        public ElementRecordPOJO elementRecordPOJO;
        File jsonFile;

        public JSONInitializers(File jsonFile) throws IOException {
            objectMapper = new ObjectMapper();
            this.jsonFile = jsonFile;
            elementRecordPOJO = objectMapper.readValue(jsonFile, ElementRecordPOJO.class);
        }

        public String writeRequest() throws IOException {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String request = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(elementRecordPOJO);
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

