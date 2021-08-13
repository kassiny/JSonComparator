package JsonStructure;

public abstract class Artifact {
    String target_repository;

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
