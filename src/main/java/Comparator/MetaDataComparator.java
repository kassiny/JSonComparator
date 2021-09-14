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
        Document document = Jsoup.parse("");

        document.body().appendElement("table").attr("border", "1px solid black").
                attr("style", JsonV2Comparator.width);
        document.body().selectFirst("table").appendElement("tr").append("<th style = width:15%>Element</th><th>Previous</th><th>Current</th>");
        document.body().selectFirst("table").appendElement("tr").appendElement("th").
                appendText("MetaData").attr("text-align","center");
        document.body().selectFirst("table").appendElement("tr").appendElement("th").
                appendText("Description").attr("text-align","center");

        if (m1.getDescription().getVersion() == m2.getDescription().getVersion()) {
            document.body().selectFirst("table").appendElement("tr").append("<th>version</th><th>" +
                    String.valueOf(m1.getDescription().getVersion()) + "</th><th>"+
                    String.valueOf(m2.getDescription().getVersion()) + "</th>");

        }
        else {

            document.body().selectFirst("table").appendElement("tr").
                    appendChildren(new ArrayList<Node>(Arrays.asList(
                            new Element("th").appendText("version"),
                            new Element("th").appendText(String.valueOf(m1.getDescription().getVersion())).attr("style","color:GoldenRod"),
                            new Element("th").appendText(String.valueOf(m2.getDescription().getVersion())).attr("style","color:GoldenRod"))));
        }
        document.body().selectFirst("table").appendElement("tr").appendElement("th").
                appendText("Application").attr("text-align","center");

        if (m1.getApplication().getName().equals(m2.getApplication().getName())) {
            document.body().selectFirst("table").appendElement("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("name"),
                    new Element("th").appendText(m1.getApplication().getName()),
                    new Element("th").appendText(m1.getApplication().getName())
            )));
        }
        else {
            document.body().selectFirst("table").appendElement("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("name"),
                    new Element("th").appendText(m1.getApplication().getName()).attr("style", "color: GoldenROd"),
                    new Element("th").appendText(m2.getApplication().getName()).attr("style", "color: GoldenROd")
            )));
        }
        return  document.outerHtml();
    }
    public String compare () {
        return compare(metaData1, metaData2);
    }
}
