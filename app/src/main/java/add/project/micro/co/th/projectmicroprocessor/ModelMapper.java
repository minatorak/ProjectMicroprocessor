package add.project.micro.co.th.projectmicroprocessor;

import java.util.HashMap;
import java.util.Map;

public class ModelMapper {

    private Log log;
    private Position position;
    private Status status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

