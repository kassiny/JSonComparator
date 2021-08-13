package JsonStructure;

public class Description {
    int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "JsonStructure.Description{" +
                "version=" + version +
                '}';
    }
}
