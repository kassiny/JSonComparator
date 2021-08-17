package JsonStructure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Optional;

public class ArtifactFile extends Artifact{
    @JsonProperty("service-short-name")
    Optional<String> service_short_name;
    Optional<String> service_name;
    Hashes hashes;
    String [] file;

    public Optional<String> getService_short_name() {
        return service_short_name;
    }

    public void setService_short_name(Optional<String> service_short_name) {
        this.service_short_name = service_short_name;
    }

    public Optional<String> getService_name() {
        return service_name;
    }

    public void setService_name(Optional<String> service_name) {
        this.service_name = service_name;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    public String[] getFile() {
        return file;
    }

    public void setFile(String[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "ArtifactFile{" +
                "target_repository='" + target_repository + '\'' +
                ", service_short_name=" + service_short_name +
                ", service_name=" + service_name +
                ", hashes=" + hashes +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
