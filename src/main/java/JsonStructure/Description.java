package JsonStructure;

public class Description {
    Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "JsonStructure.Description{" +
                "version=" + version +
                '}';
    }
}
