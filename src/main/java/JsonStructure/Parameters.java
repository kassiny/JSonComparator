package JsonStructure;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Parameters {

    Common common;
    Services services;
    public class Common {
        @JsonProperty("map")
        Map<String, String> params = new HashMap<>();

        public Map<String, String> getParams() {
            return params;
        }
        @JsonAnySetter
        public void addParam (String key, String value) {
            params.put(key, value);
        }

        public void setParams (Map<String, String> params) {
            this.params = params;
        }

        @JsonCreator
        public Common(Map<String, String> params) {
            this.params = params;
        }

        public Common() {};

        @Override
        public String toString() {
            return "Common{" +
                    "params=" + params +
                    '}';
        }
    }

    public class Services {

        @JsonProperty("map")
        Map<String, Service_name> sn = new HashMap<>();

        public Map<String, Service_name> getSn() {
            return sn;
        }

        @JsonAnySetter
        public void addService(String key, Service_name serviceName) {
            sn.put(key, serviceName);
        }

        public void setSn(Map<String, Service_name> map) {
            this.sn = map;
        }

        @Override
        public String toString() {
            return "Services{" +
                    "sn=" + sn +
                    '}';
        }


        public Services() {}
    }

    public Common getCommon() {
        return common;
    }

    public void setCommon(Common common) {
        this.common = common;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "JsonStructure.Parameters{" +
                "common=" + common +
                ", services=" + services +
                '}';
    }
}
