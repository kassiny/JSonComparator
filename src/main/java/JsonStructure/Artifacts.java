package JsonStructure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Artifacts {
    @JsonProperty("artifacts")
    ArtifactMvn[] artifactMvn;
    @JsonProperty("artifacts")
    ArtifactFile[] artifactFiles;

    public ArtifactMvn[] getArtifactMvn() {
        return artifactMvn;
    }

    public void setArtifactMvn(ArtifactMvn[] artifactMvn) {
        this.artifactMvn = artifactMvn;
    }

    public ArtifactFile[] getArtifactFiles() {
        return artifactFiles;
    }

    public void setArtifactFiles(ArtifactFile[] artifactFiles) {
        this.artifactFiles = artifactFiles;
    }

    @Override
    public String toString() {
        return "Artifacts{" +
                "artifactMvn=" + Arrays.toString(artifactMvn) +
                ", artifactFiles=" + Arrays.toString(artifactFiles) +
                '}';
    }
}
