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
        }
        catch (JsonMappingException e) {
            System.out.println("wrong data structure in file " + e.getPath());
        }
        catch (JsonParseException e) {
            System.out.println("provided file is not json " + jsonv1.getPath());
        }
        catch (IOException e) {
            System.out.println("can't open file 1 ");
        }

        try {

            finalJson2 = objectMapper.readValue(jsonv2, JsonV2.class);

            //System.out.println(finalJson1);

            FileOutputStream script = new FileOutputStream("Script.html");
            script.write(ScriptComparator.compare(finalJson1.getScript(), finalJson2.getScript()).getBytes());
            FileOutputStream finalRes = new FileOutputStream("finalResult.html");
            finalRes.write(JsonV2Comparator.compare(finalJson1, finalJson2).getBytes());
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
            System.out.println("A mandatory field is absent");
        }
    }


}
