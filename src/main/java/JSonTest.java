import JsonStructure.*;
import Comparator.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JSonTest {
    public static void main(String[] args) {
        if (args.length<2) {
            System.out.println("Please, specify the metada files using DmetaData1 and Dmetadata2 commands");
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
        V2 finalJson1 = null;
        V2 finalJson2 = null;
        try {
            // metaData1 = objectMapper.readValue(new File(args[0]), MetaData.class);
            // metaData2 = objectMapper.readValue(new File(args[1]), MetaData.class);
            finalJson1 = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\v2_json_sample.json"), V2.class);
            finalJson2 = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\v2_json_sample2.json"), V2.class);
            // metaData1 = objectMapper.readValue(new File(System.getProperty("metaData1")), JsonStructure.MetaData.class);
             metaData1 = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\MetaData1.json"), JsonStructure.MetaData.class);
            metaData2 = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\MetaData2.json"), JsonStructure.MetaData.class);
            // System.out.println(metaData1);
           // System.out.println(metaData2);
            System.out.println(finalJson1);
            System.out.println(MetaDataComparator.compare(metaData1, metaData2));

            FileOutputStream comResult = new FileOutputStream("resultMetaData.html");
            comResult.write(MetaDataComparator.compare(metaData1, metaData2).getBytes());
            comResult.close();

            FileOutputStream serRes = new FileOutputStream("resultServices.html");
            serRes.write(ServicesComparator.compare(finalJson1.getServices(), finalJson2.getServices()).getBytes());
            serRes.close();

            FileOutputStream artRes = new FileOutputStream("sefultArtifacts.html");
            artRes.write(ArtifactComparator.compare(finalJson1.getArtifacts(), finalJson2.getArtifacts()).getBytes());

            FileOutputStream scrpt = new FileOutputStream("ScriptResult.html");
            scrpt.write(ScriptComparator.compare(finalJson1.getScript(), finalJson2.getScript()).getBytes());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
