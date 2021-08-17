package JsonStructure;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class V2 {
    MetaData metadata;
    Service[] services;
    // Object[] artifacts;
    // Map<ArtifactMvn, ArtifactFile[]> artifacts;
    Artifact[] artifacts;
    Script[] script;
    Rpm rpm;
    Parameters parameters;

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public Artifact[] getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(Artifact[] artifacts) {
        this.artifacts = artifacts;
    }

    public Script[] getScript() {
        return script;
    }

    public void setScript(Script[] script) {
        this.script = script;
    }

    public Rpm getRpm() {
        return rpm;
    }

    public void setRpm(Rpm rpm) {
        this.rpm = rpm;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "V2{" +
                "metaData=" + metadata +
                ", services=" + Arrays.toString(services) +
                ", artifacts=" + artifacts +
                ", script=" + Arrays.toString(script) +
                ", rpm=" + rpm +
                ", parameters=" + parameters +
                '}';
    }
}
