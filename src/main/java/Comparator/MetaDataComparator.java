package Comparator;

import JsonStructure.*;

public class MetaDataComparator {
    MetaData metaData1;
    MetaData metaData2;

    public MetaDataComparator(MetaData metaData1, MetaData metaData2) {
        this.metaData1 = metaData1;
        this.metaData2 = metaData2;
    }



    public static String compare (MetaData m1, MetaData m2) {
        StringBuilder result = new StringBuilder();
        result.append("MetaData: { \n" +
                "Description: { \n");
        if (m1.getDescription().getVersion() == m2.getDescription().getVersion()) {
            result.append("version wasn't changed. Current version: ");
            result.append(m1.getDescription().getVersion());
            result.append('\n');
        }
        else {
            result.append("version was changed. Previous version: ");
            result.append(m1.getDescription().getVersion());
            result.append("\nCurrent version: ");
            result.append(m2.getDescription().getVersion());
        }
        result.append("}\n");
        result.append("Application: {\n");
        if (m1.getApplication().getName().equals(m2.getApplication().getName())) {
            result.append("Name wasn't changed. Current name: ");
            result.append(m1.getApplication().getName());
            result.append('\n');
        }
        else {
            result.append("Name was changed. Previous name: ");
            result.append(m1.getApplication().getName());
            result.append("\n Current name: ");
            result.append(m2.getApplication().getName());
        }
        result.append("} \n }\n");
        return result.toString();
    }

    public String compare () {
        return compare(metaData1, metaData2);
    }

}
