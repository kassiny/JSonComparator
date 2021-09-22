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

        document.body().appendElement("table").
                attr("style", JsonV2Comparator.width);

        document.body().selectFirst("table").attr("style", JsonV2Comparator.width).appendElement("tr").appendElement("th").
                appendText("Description").attr("text-align","center").attr("style", JsonV2Comparator.fistColumnWidth);

        if (m1.getDescription() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Description is missing!!!").attr("style", "color:" + "red" );
            m1.setDescription(new Description());
            m1.getDescription().setVersion(0);
        }

        if (m2.getDescription() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Description is missing!!!").attr("style", "color:" + "red" );
            m2.setDescription(new Description());
            m2.getDescription().setVersion(0);
        }

        if (m1.getDescription().getVersion() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Description version is missing, replaced with 0!!!").attr("style", "color:" + "red" );
            m1.getDescription().setVersion(0);
        }
        if (m2.getDescription().getVersion() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Description version is missing, replaced with 0!!!").attr("style", "color:" + "red" );
            m2.getDescription().setVersion(0);
        }
        if (m1.getApplication() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Application is missing!!!").attr("style", "color:" + "red" );
            m1.setApplication(new Application());
            m1.getApplication().setName(" ");
        }

        if (m2.getApplication() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Application is missing!!!").attr("style", "color:" + "red" );
            m2.setApplication(new Application());
            m2.getApplication().setName(" ");
        }

        if (m1.getApplication().getName() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Application name is missing!!!").attr("style", "color:" + "red" );
            m1.getApplication().setName(" ");
        }
        if (m2.getApplication().getName() == null) {
            document.body().selectFirst("table").appendElement("tr").appendElement("th").
                    appendText("Application name is missing!!!").attr("style", "color:" + "red" );
            m2.getApplication().setName(" ");
        }

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
                    new Element("th").appendText(m1.getApplication().getName()).
                            attr("style", "color: GoldenROd").attr("style", "width:42.5%"),
                    new Element("th").appendText(m2.getApplication().getName()).attr("style", "color: GoldenROd")
            )));
        }
        return  document.outerHtml();
    }
    public String compare () {
        return compare(metaData1, metaData2);
    }
}
