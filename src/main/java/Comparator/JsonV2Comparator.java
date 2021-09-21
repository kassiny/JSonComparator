package Comparator;

import JsonStructure.JsonV2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsonV2Comparator {
    public static final String width = "width: 90%";
    public static final String added = "LimeGreen";
    public static final String deleted = "red";
    public static final String fistColumnWidth = "width: 15%";
    public static final String fontSize = "font-size:30px";

    public static String compare (JsonV2 json1, JsonV2 json2, String filename1, String filename2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table").
                attr("style", "width: 100%, font-size: 150%");

        document.body().selectFirst("table").appendElement("tr").
                appendElement("th").appendText("attribute name").attr("style",fistColumnWidth).
                appendElement("th").appendText(filename1).
                appendElement("th").appendText(filename2);

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendElement("p").appendElement("b").appendText("MetaData")
                .attr("style", fontSize);
        Document metaDataHtml = Jsoup.parse(MetaDataComparator.compare(json1.getMetadata(), json2.getMetadata()));
        //document.body().selectFirst("table").appendChildren(metaDataHtml.body().selectFirst("table").children());
        document.body().selectFirst("table").appendChild(metaDataHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendElement("p").appendElement("b").appendText("Services")
                .attr("style", fontSize);
        Document servicesHtml = Jsoup.parse(ServicesComparator.compare(json1.getServices(), json2.getServices()));
        document.body().selectFirst("table").appendChild(servicesHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendElement("p").
                appendElement("b").appendText("Artifacts").attr("style", fontSize);
        Document artifactsHtml = Jsoup.parse(ArtifactComparator.compare(json1.getArtifacts(), json2.getArtifacts()));
        document.body().selectFirst("table").appendChild(artifactsHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendElement("p").appendElement("b").
                appendText("Script").attr("style", fontSize);
        Document scriptHtml = Jsoup.parse(ScriptComparator.compare(json1.getScript(), json2.getScript()));
        document.body().selectFirst("table").appendChild(scriptHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendElement("p").
                appendElement("b").appendText("Rpm").attr("style", fontSize);
        Document rpmHtml = Jsoup.parse(RpmComparator.compare(json1.getRpm(), json2.getRpm()));
        document.body().selectFirst("table").appendChild(rpmHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendElement("p").appendElement("b").
                appendText("Parameters").attr("style", fontSize);
        Document parametersHtml = Jsoup.parse(ParametersComparator.compare(json1.getParameters(), json2.getParameters()));
        document.body().selectFirst("table").appendChild(parametersHtml.body().selectFirst("table"));

        return document.outerHtml();
    }
}