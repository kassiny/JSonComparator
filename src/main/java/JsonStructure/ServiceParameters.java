package JsonStructure;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ServiceParameters {

    Map<String, String> params = new HashMap<>();


    public Map<String, String> getParams() {
        return params;
    }

    public ServiceParameters() {
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @JsonAnySetter
    public void addParam(String key, String value) {
        params.put(key, value);
    }

    @Override
    public String toString() {
        return "Service_name{" +
                "params=" + params +
                '}';
    }
}
