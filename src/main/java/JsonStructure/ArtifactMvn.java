package JsonStructure;

import java.util.Arrays;

public class ArtifactMvn extends Artifact {
    Mvn[] mvn;

    public Mvn[] getMvn() {
        return mvn;
    }

    public void setMvn(Mvn[] mvn) {
        this.mvn = mvn;
    }

    public String getTarget_repository() {
        return super.target_repository;
    }

    public void setTarget_repository(String target_repository) {
        super.target_repository = target_repository;
    }

    @Override
    public String toString() {
        return "JsonStructure.Artifact{" +
                "mvn=" + Arrays.toString(mvn) +
                ", target_repository='" + target_repository + '\'' +
                '}';
    }
}
