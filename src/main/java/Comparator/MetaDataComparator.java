package Comparator;

import JsonStructure.*;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.Arrays;


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

        document.body().appendElement("table");
        document.body().selectFirst("table").appendElement("tr").append("<th>Element</th><th>Previous</th><th>Current</th>");


        result.append("MetaData: { \n" +
                "Description: { \n");
        
        if (m1.getDescription().getVersion() == m2.getDescription().getVersion()) {
            document.body().selectFirst("table").appendElement("tr").append("<th>version</th><th>" +
                    String.valueOf(m1.getDescription().getVersion()) + "</th><th>"+
                    String.valueOf(m2.getDescription().getVersion()) + "</th>");

            result.append("version wasn't changed. Current version: ");
            result.append(m1.getDescription().getVersion());
            result.append('\n');
        }
        else {

            document.body().selectFirst("table").appendElement("tr").
                    appendChildren(new ArrayList<Node>(Arrays.asList(
                            new Element("th").appendText("version"),
                            new Element("th").appendText(String.valueOf(m1.getDescription().getVersion())).attr("style","color:GoldenRod"),
                            new Element("th").appendText(String.valueOf(m2.getDescription().getVersion())).attr("style","color:GoldenRod"))));

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
            document.body().selectFirst("table").appendElement("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("name"),
                    new Element("th").appendText(m1.getApplication().getName()),
                    new Element("th").appendText(m1.getApplication().getName())
            )));

            result.append(m1.getApplication().getName());
            result.append('\n');
        }
        else {
            document.body().selectFirst("table").appendElement("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("name"),
                    new Element("th").appendText(m1.getApplication().getName()).attr("style", "color: GoldenROd"),
                    new Element("th").appendText(m2.getApplication().getName()).attr("style", "color: GoldenROd")
            )));


            result.append("Name was changed. Previous name: ");
            result.append(m1.getApplication().getName());
            result.append("\n Current name: ");
            result.append(m2.getApplication().getName());
        }

        result.append("} \n }\n");
        //return result.toString();
        return  document.outerHtml();
    }

    public String compare () {
        return compare(metaData1, metaData2);
    }

}
