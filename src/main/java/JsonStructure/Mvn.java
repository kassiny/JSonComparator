package JsonStructure;

import java.util.Optional;

public class Mvn {
    String groupId;
    String artifactId;
    String version;
    Optional<String> service_name;
    Optional<String> classifier;
    String mvn_type;
    String mvn_repository;
    Hashes hashes;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Optional<String> getService_name() {
        return service_name;
    }

    public void setService_name(Optional<String> service_name) {
        this.service_name = service_name;
    }

    public Optional<String> getClassifier() {
        return classifier;
    }

    public void setClassifier(Optional<String> classifier) {
        this.classifier = classifier;
    }

    public String getMvn_type() {
        return mvn_type;
    }

    public void setMvn_type(String mvn_type) {
        this.mvn_type = mvn_type;
    }

    public String getMvn_repository() {
        return mvn_repository;
    }

    public void setMvn_repository(String mvn_repository) {
        this.mvn_repository = mvn_repository;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    @Override
    public String toString() {
        return "JsonStructure.Mvn{" +
                "groupId='" + groupId + '\'' +
                ", arifactId='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                ", service_name=" + service_name +
                ", classifier=" + classifier +
                ", mvn_type='" + mvn_type + '\'' +
                ", mvn_repository='" + mvn_repository + '\'' +
                ", hashes=" + hashes +
                '}';
    }
}
