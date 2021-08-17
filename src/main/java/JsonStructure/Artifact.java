package JsonStructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Artifact {
    @JsonProperty("target_repository")
    String target_repository;

    String artifactType;

    public String getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(String artifactType) {
        this.artifactType = artifactType;
    }

    public String getTarget_repository() {
        return target_repository;
    }

    public void setTarget_repository(String target_repository) {
        this.target_repository = target_repository;
    }

    @Override
    public String toString() {
        return "Artifact{" +
                "target_repository='" + target_repository + '\'' +
                '}';
    }
}
