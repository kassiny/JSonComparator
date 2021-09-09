package Comparator;

import JsonStructure.Parameters;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ParametersComparator {
    public static String compare (Parameters p1, Parameters p2) {
        Document document = Jsoup.parse("");
        document.appendElement("table").attr("border", "1px solid black");
        String equal = "black";
        String diff = "GoldenRod";
        String added = "DarkGreen";
        String deleted = "red";
        for (String key: p1.getCommon().getParams().keySet()) {
            if (p2.getCommon().getParams().containsKey(key)) {
                Objects.requireNonNull(document.body().selectFirst("table")).appendElement("tr").
                        appendChildren(new ArrayList<>(Arrays.asList(
                                new Element("th").appendText(key),
                                new Element("th").appendText(p1.getCommon().getParams().get(key)).
                                        attr("style","color:" +
                                                (p1.getCommon().getParams().get(key).equals(p2.getCommon().getParams().get(key))?equal:diff)),
                                new Element("th").appendText(p2.getCommon().getParams().get(key)).
                                        attr("style","color:" +
                                                (p1.getCommon().getParams().get(key).equals(p2.getCommon().getParams().get(key))?equal:diff))
                        )));
            }
            else {
                document.body().selectFirst("table").appendElement("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText(key),
                    new Element("")
                )));
            }
        }
        return document.outerHtml();
    }

}
