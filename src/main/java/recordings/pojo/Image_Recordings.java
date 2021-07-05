package recordings.pojo;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "device_name",
        "os_version",
        "screen_resolution",
        "image_url"
})
public class Image_Recordings {
    @JsonProperty("device_name")
    private String device_name;
    @JsonProperty("os_version")
    private String os_version;
    @JsonProperty("screen_resolution")
    private String screen_resolution;
    @JsonProperty("image_url")
    private String image_url;


    @JsonProperty("device_name")
    public String getDevice_name() {
        return device_name;
    }

    @JsonProperty("device_name")
    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    @JsonProperty("os_version")
    public String getOs_version() {
        return os_version;
    }

    @JsonProperty("os_version")
    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    @JsonProperty("screen_resolution")
    public String getScreen_resolution() {
        return screen_resolution;
    }

    @JsonProperty("screen_resolution")
    public void setScreen_resolution(String screen_resolution) {
        this.screen_resolution = screen_resolution;
    }

    @JsonProperty("image_url")
    public String getImage_url() {
        return image_url;
    }

    @JsonProperty("image_url")
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
