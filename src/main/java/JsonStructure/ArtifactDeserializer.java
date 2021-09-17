package JsonStructure;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ArtifactDeserializer extends StdDeserializer<Artifact> {

    public ArtifactDeserializer() {
        this(null);
    }

    public ArtifactDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Artifact deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        final JsonNode ArtifactNode = mapper.readTree(jsonParser);

        if (ArtifactNode.has("mvn")) {
            return mapper.treeToValue(ArtifactNode, ArtifactMvn.class);
        }
        else if (ArtifactNode.has("file")) {
            return mapper.treeToValue(ArtifactNode, ArtifactFile.class);
        }
        throw  new IllegalStateException("UnexepectedArtifactType : ");
        /*final ArtifactType artifactType = ArtifactType.fromValue(ArtifactNode.get("artifactType").asText());
        switch (artifactType) {
            case MVN:
                return mapper.treeToValue(ArtifactNode, ArtifactMvn.class);
            case FILE:
                return mapper.treeToValue(ArtifactNode,ArtifactFile.class);
            default:
                throw  new IllegalStateException("UnexepectedArtifactType : " + artifactType.toString());
        }*/
    }
}
