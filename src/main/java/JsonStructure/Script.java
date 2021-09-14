package JsonStructure;

        import JsonStructure.Hashes;
        import com.fasterxml.jackson.annotation.JsonProperty;

        import java.util.Optional;

public class Script {
    @JsonProperty("service-short-name")
    Optional<String> service_short_name;
    @JsonProperty("start-point")
    Optional<String> start_point;
    @JsonProperty("end-point")
    Optional<String> end_point;
    String script_name;
    Hashes hashes;
    String url;

    public Script() {
        service_short_name = Optional.empty();
        start_point = Optional.empty();
        end_point = Optional.empty();
    }

    public Optional<String> getService_short_name() {
        return service_short_name;
    }

    public void setService_short_name(Optional<String> service_short_name) {
        this.service_short_name = service_short_name;
    }

    public Optional<String> getStart_point() {
        return start_point;
    }

    public void setStart_point(Optional<String> start_point) {
        this.start_point = start_point;
    }

    public Optional<String> getEnd_point() {
        return end_point;
    }

    public void setEnd_point(Optional<String> end_point) {
        this.end_point = end_point;
    }

    public String getScript_name() {
        return script_name;
    }

    public void setScript_name(String script_name) {
        this.script_name = script_name;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "JsonStructure.Script{" +
                "service_short_name=" + service_short_name +
                ", start_point=" + start_point +
                ", end_point=" + end_point +
                ", script_name='" + script_name + '\'' +
                ", hashes=" + hashes +
                ", url='" + url + '\'' +
                '}';
    }
}
