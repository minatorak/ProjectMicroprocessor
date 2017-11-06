package add.project.micro.co.th.projectmicroprocessor;

import java.util.HashMap;
import java.util.Map;

public class Log {

    private Integer huminity;
    private Integer count;
    private Double dateStart;
    private Integer tempCelcius;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getHuminity() {
        return huminity;
    }

    public void setHuminity(Integer huminity) {
        this.huminity = huminity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getDateStart() {
        return dateStart;
    }

    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    public Integer getTempCelcius() {
        return tempCelcius;
    }

    public void setTempCelcius(Integer tempCelcius) {
        this.tempCelcius = tempCelcius;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}