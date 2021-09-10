package Comparator;

import JsonStructure.JsonV2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsonV2Comparator {
    public static String compare (JsonV2 json1, JsonV2 json2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table").attr("border", "1px solid balck");
        Document metaDataHtml = Jsoup.parse(MetaDataComparator.compare(json1.getMetadata(), json2.getMetadata()));
        //document.body().selectFirst("table").appendChildren(metaDataHtml.body().selectFirst("table").children());
        document.body().selectFirst("table").appendChild(metaDataHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText("services");
        Document servicesHtml = Jsoup.parse(ServicesComparator.compare(json1.getServices(), json2.getServices()));
        document.body().selectFirst("table").appendChild(servicesHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText("artifacts");
        Document artifactsHtml = Jsoup.parse(ArtifactComparator.compare(json1.getArtifacts(), json2.getArtifacts()));
        document.body().selectFirst("table").appendChild(artifactsHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText("script");
        Document scriptHtml = Jsoup.parse(ScriptComparator.compare(json1.getScript(), json2.getScript()));
        document.body().selectFirst("table").appendChild(scriptHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText("rpm");
        Document rpmHtml = Jsoup.parse(RpmComparator.compare(json1.getRpm(), json2.getRpm()));
        document.body().selectFirst("table").appendChild(rpmHtml.body().selectFirst("table"));

        document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText("parameters");
        Document parametersHtml = Jsoup.parse(ParametersComparator.compare(json1.getParameters(), json2.getParameters()));
        document.body().selectFirst("table").appendChild(parametersHtml.body().selectFirst("table"));

        return document.outerHtml();
    }
}
