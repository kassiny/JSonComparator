import JsonStructure.Hashes;
import JsonStructure.MetaData;
import JsonStructure.V2;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;


import java.io.File;
import java.io.IOException;

public class JSonTest {
    public static void main(String[] args) {
        if (args.length<2) {
            System.out.println("Please, specify thhe metada files using DmetaData1 and Dmetadata2 commands");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        Hashes hashes;
        MetaData metaData1 = null;
        MetaData metaData2 = null;
        V2 finalJson = null;
        try {
            // metaData1 = objectMapper.readValue(new File(args[0]), MetaData.class);
            // metaData2 = objectMapper.readValue(new File(args[1]), MetaData.class);
            finalJson = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\v2_json_sample.json"), V2.class);
            // metaData1 = objectMapper.readValue(new File(System.getProperty("metaData1")), JsonStructure.MetaData.class);
            // metaData1 = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\MetaData1.json"), JsonStructure.MetaData.class);
            // System.out.println(metaData1);
           // System.out.println(metaData2);
            System.out.println(finalJson);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
