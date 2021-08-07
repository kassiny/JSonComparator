import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson. core.*;

import java.io.File;
import java.io.IOException;

public class JSonTest {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        MetaData metaData;
        try {
            metaData = objectMapper.readValue(new File("C:\\Users\\telega\\IdeaProjects\\Github\\JsonComparator\\MetaData1.json"), MetaData.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
