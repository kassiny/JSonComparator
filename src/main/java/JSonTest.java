import JsonStructure.*;
import Comparator.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class JSonTest {

    private static String keyMessage(String fieldName) {
        return fieldName + " is a mandatory key field, can't be missing " + fieldName + " is absent";
    }

    private static boolean checkForNullKeys (JsonV2 json) {
        boolean result = false;

        if (json.getMetadata() == null) {
            System.out.println(keyMessage("Metadata"));
            result = true;
        }
        if (json.getServices() == null) {
            System.out.println(keyMessage("Services"));
            return  true;
        }
        if (json.getScript() == null) {
            System.out.println(keyMessage("script"));
            return true;
        }
        if (json.getArtifacts() == null) {
            System.out.println(keyMessage("artifacts"));
            return true;
        }
        if (json.getRpm() == null) {
            System.out.println(keyMessage("rpm"));
            return true;
        }
        if (json.getParameters() == null) {
            System.out.println(keyMessage("parameters"));
            return true;
        }

        for (Script s: json.getScript()) {
            if (s.getScript_name() == null) {
                System.out.println(keyMessage("script_name"));
                result = true;
            }
        }
        for (Service s: json.getServices()) {
            if (s.getDocker_image_name() == null) {
                System.out.println(keyMessage("docker_image_name"));
                result = true;
            }
            if (s.getDocker_tag() == null) {
                System.out.println(keyMessage("docker_tag"));
                result = true;
            }
        }

        for (Artifact ar: json.getArtifacts()) {
            if (ar.getArtifactType().equals(ArtifactType.MVN.value)) {
                ArtifactMvn artifactMvn = (ArtifactMvn) ar;
                if (artifactMvn.getMvn() == null) {
                    System.out.println(keyMessage("MVN"));
                    return true;
                }
                for (Mvn m: artifactMvn.getMvn()) {
                    if (m.getVersion() == null) {
                        System.out.println(keyMessage("mvn version"));
                        result = true;
                    }
                    if (m.getArtifactId() == null) {
                        System.out.println(keyMessage("artifactId"));
                        result = true;
                    }
                    if (m.getGroupId() == null) {
                        System.out.println(keyMessage("GroupID"));
                        result = true;
                    }
                }
            }
            if (ar.getArtifactType().equals(ArtifactType.FILE.value)) {
                ArtifactFile artifactFile = (ArtifactFile)ar;
                if (artifactFile.getFile() == null) {
                    System.out.println(keyMessage("file"));
                    result = true;
                }
            }
        }
        for (Rpm rpm: json.getRpm()) {
            if (rpm.getUrl() == null) {
                System.out.println(keyMessage("rpm url"));
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length<2) {
            System.out.println("Please, specify the json files");
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Artifact.class, new ArtifactDeserializer());

        objectMapper.registerModule(module);
        objectMapper.registerSubtypes(new NamedType(ArtifactMvn.class, "ArtifactMvn"));
        objectMapper.registerSubtypes(new NamedType(ArtifactFile.class, "ArtifactFile"));

        Hashes hashes;
        MetaData metaData1 = null;
        MetaData metaData2 = null;
        JsonV2 finalJson1 = null;
        JsonV2 finalJson2 = null;
        File jsonv1 = new File(args[0]);
        File jsonv2 = new File(args[1]);
        try {
//            File jsonv1 = new File(args[0]);
            finalJson1 = objectMapper.readValue(jsonv1, JsonV2.class);
            if (checkForNullKeys(finalJson1)) {
                return;
            }
        }
        catch (JsonMappingException e) {
            System.out.println("wrong data structure in file " + e.getPath());
            return;
        }
        catch (JsonParseException e) {
            System.out.println("provided file is not json " + jsonv1.getPath());
            return;
        }
        catch (IOException e) {
            System.out.println("can't open file 1 ");
            return;
        }

        try {

            finalJson2 = objectMapper.readValue(jsonv2, JsonV2.class);
            if (checkForNullKeys(finalJson2)) {
                return;
            }
            //System.out.println(finalJson1);

            FileOutputStream script = new FileOutputStream("Script.html");
            script.write(ScriptComparator.compare(finalJson1.getScript(), finalJson2.getScript()).getBytes());
            FileOutputStream finalRes = new FileOutputStream("finalResult.html");
            finalRes.write(JsonV2Comparator.compare(finalJson1, finalJson2, jsonv1.getPath(), jsonv2.getPath()).getBytes());
            finalRes.close();

            System.out.println("the comparison result is in finalResult.html");

        }
        catch (JsonMappingException e) {
            System.out.println("Wrong data structure " + e.getPath());
            //System.out.println(e.getLocalizedMessage());
        }
        catch (JsonParseException e) {
            System.out.println("provided file is not json " + jsonv2.getPath());
        }
        catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            System.out.println("A mandatory field is absent " + e.getMessage());
            e.printStackTrace();
        }
    }


}
