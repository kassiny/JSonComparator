package Comparator;

import JsonStructure.*;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class MetaDataComparator {
    MetaData metaData1;
    MetaData metaData2;


    public MetaDataComparator(MetaData metaData1, MetaData metaData2) {
        this.metaData1 = metaData1;
        this.metaData2 = metaData2;

    }

    public static String compare (MetaData m1, MetaData m2) {

        StringBuilder result = new StringBuilder();

        Document document = Jsoup.parse("");

        document.body().appendText("MetaData: { \n\t Description: {\n\t");
        document.body().appendElement("p");


        result.append("MetaData: { \n" +
                "Description: { \n");
        if (m1.getDescription().getVersion() == m2.getDescription().getVersion()) {
            document.body().selectFirst("p").attr("style","color:DarkGreen");
            document.body().selectFirst("p").appendText("version: " + String.valueOf(m1.getDescription().getVersion()));

            result.append("version wasn't changed. Current version: ");
            result.append(m1.getDescription().getVersion());
            result.append('\n');
        }
        else {
            document.body().selectFirst("p").attr("style","color:GoldenRod");
            document.body().selectFirst("p").appendText("version: " + String.valueOf(m2.getDescription().getVersion()));

            result.append("version was changed. Previous version: ");
            result.append(m1.getDescription().getVersion());
            result.append("\nCurrent version: ");
            result.append(m2.getDescription().getVersion());
        }

        document.body().appendText("}\n\tApplication: {\n\t");

        result.append("}\n");
        result.append("Application: {\n");


        if (m1.getApplication().getName().equals(m2.getApplication().getName())) {
            result.append("Name wasn't changed. Current name: ");
            document.body().appendElement("p2").attr("style", "color: DarkGreen").
                    appendElement("name: " +  m1.getApplication().getName() );

            result.append(m1.getApplication().getName());
            result.append('\n');
        }
        else {
            document.body().appendElement("p").attr("style", "color: GoldenROd").
                    appendText("name: " +  m1.getApplication().getName() );

            result.append("Name was changed. Previous name: ");
            result.append(m1.getApplication().getName());
            result.append("\n Current name: ");
            result.append(m2.getApplication().getName());
        }

        document.body().appendText("}\n");

        result.append("} \n }\n");
        //return result.toString();
        return  document.outerHtml();
    }

    public String compare () {
        return compare(metaData1, metaData2);
    }

}
