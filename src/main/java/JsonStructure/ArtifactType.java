package JsonStructure;

public enum ArtifactType {
    MVN("MVN"), FILE("FILE");
    public  final  String value;

    ArtifactType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ArtifactType fromValue(String val) {
        for (ArtifactType type: ArtifactType.values()) {
            if (val.equals(type.value)) {
                return type;
            }
        }
        return null;
    }
}
