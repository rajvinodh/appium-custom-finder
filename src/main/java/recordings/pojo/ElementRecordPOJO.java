package recordings.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.*;


public class ElementRecordPOJO {
    String element_name;
    String screen_name;
    String strategy;
    List<Image_Recordings> image_recordings;

    @JsonCreator
    public ElementRecordPOJO(@JsonProperty("element_name") String element_name, @JsonProperty("screen_name") String screen_name, @JsonProperty("strategy") String strategy,
                             @JsonProperty("image_recordings") List<Image_Recordings> image_recordings){
        this.element_name = element_name;
        this.screen_name = screen_name;
        this.strategy = strategy;
        this.image_recordings = image_recordings;

    }

    @JsonProperty("element_name")
    public String getElement_name() {
        return element_name;
    }

    @JsonProperty("element_name")
    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

    @JsonProperty("screen_name")
    public String getScreen_name() {
        return screen_name;
    }

    @JsonProperty("screen_name")
    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    @JsonProperty("strategy")
    public String getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @JsonProperty("image_recordings")
    public List<Image_Recordings> getImage_recordings() {
        return image_recordings;
    }

    @JsonProperty("image_recordings")
    public void setImage_recordings(List<Image_Recordings> image_recordings) {
        this.image_recordings = image_recordings;
    }
}
