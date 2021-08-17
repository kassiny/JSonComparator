package JsonStructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameters {

    Common common;
    Services services;
    public class Common {
        @JsonProperty("some-param")
        String some_param;
        @JsonProperty("some-other-param")
        String some_other_param;

        @Override
        public String toString() {
            return "common{" +
                    "some_param='" + some_param + '\'' +
                    ", some_other_param='" + some_other_param + '\'' +
                    '}';
        }

        public String getSome_param() {
            return some_param;
        }

        public void setSome_param(String some_param) {
            this.some_param = some_param;
        }

        public String getSome_other_param() {
            return some_other_param;
        }

        public void setSome_other_param(String some_other_param) {
            this.some_other_param = some_other_param;
        }
    }

    public class Services {
        @JsonProperty("service_name")
        Service_name_1 service_name_1;
        Service_name_2 service_name_2;

        public class  Service_name_1 {
            @JsonProperty("some-third-param")
            String some_third_param;

            public String getSome_third_param() {
                return some_third_param;
            }

            public void setSome_third_param(String some_third_param) {
                this.some_third_param = some_third_param;
            }

            @Override
            public String toString() {
                return "Service_name1{" +
                        "some_third_param='" + some_third_param + '\'' +
                        '}';
            }
        }
        public class Service_name_2 {
            @JsonProperty("some-third-param")
            public String some_third_param_2;

            public String getSome_third_param_2() {
                return some_third_param_2;
            }

            public void setSome_third_param_2(String some_third_param_2) {
                this.some_third_param_2 = some_third_param_2;
            }

            @Override
            public String toString() {
                return "Service_name_2{" +
                        "some_third_param_2='" + some_third_param_2 + '\'' +
                        '}';
            }
        }

        public Service_name_1 getService_name_1() {
            return service_name_1;
        }

        public void setService_name_1(Service_name_1 service_name_1) {
            this.service_name_1 = service_name_1;
        }

        public Service_name_2 getService_name_2() {
            return service_name_2;
        }

        public void setService_name_2(Service_name_2 service_name_2) {
            this.service_name_2 = service_name_2;
        }

        @Override
        public String toString() {
            return "Services{" +
                    "service_name_1=" + service_name_1 +
                    ", service_name_2=" + service_name_2 +
                    '}';
        }
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
