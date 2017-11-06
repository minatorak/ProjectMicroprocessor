package add.project.micro.co.th.projectmicroprocessor;

import java.util.HashMap;
import java.util.Map;

public class Status {

    private Integer running;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getRunning() {
        return running;
    }

    public void setRunning(Integer running) {
        this.running = running;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}