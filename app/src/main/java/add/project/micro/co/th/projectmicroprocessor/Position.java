package add.project.micro.co.th.projectmicroprocessor;
import java.util.HashMap;
import java.util.Map;

public class Position {

    private Integer latitude;
    private Double lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
