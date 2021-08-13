package JsonStructure;

import JsonStructure.Hashes;

import java.util.Optional;

public class Rpm {
    String url;
    String rpm_repository_name;
    Hashes hashes;
    Optional<String> service_short_name;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRpm_repository_name() {
        return rpm_repository_name;
    }

    public void setRpm_repository_name(String rpm_repository_name) {
        this.rpm_repository_name = rpm_repository_name;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    public Optional<String> getService_short_name() {
        return service_short_name;
    }

    public void setService_short_name(Optional<String> service_short_name) {
        this.service_short_name = service_short_name;
    }

    @Override
    public String toString() {
        return "JsonStructure.rpm{" +
                "url='" + url + '\'' +
                ", rpm_repository_name='" + rpm_repository_name + '\'' +
                ", hashes=" + hashes +
                ", service_short_name=" + service_short_name +
                '}';
    }
}
