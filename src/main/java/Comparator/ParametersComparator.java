package Comparator;

import JsonStructure.Parameters;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParametersComparator {

    static ArrayList<Node> formATable(Map<String,String> map1, Map<String, String> map2) {
        ArrayList<Node> arrayList = new ArrayList<>();
        String equal = "black";
        String diff = "goldenRod";
        String added = JsonV2Comparator.added;
        String deleted = JsonV2Comparator.deleted;

        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) {
                arrayList.add(new Element("tr").
                        appendChildren(new ArrayList<>(Arrays.asList(
                                new Element("th").appendText(key).attr("style", JsonV2Comparator.fistColumnWidth),
                                new Element("th").appendText(map1.get(key)).
                                        attr("style","color:" +
                                                (map1.get(key).equals(map2.get(key))?equal:diff)).attr("style", "width:42.5%"),
                                new Element("th").appendText(map2.get(key)).
                                        attr("style","color:" +
                                                (map1.get(key).equals(map2.get(key))?equal:diff))
                        ))));
            }
            else {
                arrayList.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText(key).attr("style", JsonV2Comparator.fistColumnWidth),
                        new Element("th").appendText(map1.get(key)).attr("style", "color:" + deleted)
                ))));
            }
        }
        for (String key: map2.keySet()) {
            if (!map1.containsKey(key)) {
                arrayList.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText(key).attr("style", JsonV2Comparator.fistColumnWidth),
                        new Element("th").appendText(""),
                        new Element("th").appendText(map2.get(key)).attr("style", "color:" + added)
                ))));
            }
        }
        return  arrayList;
    }

    static ArrayList<Node> formATable(Map<String, String> map, ChangeMode mode) {
        ArrayList<Node> result = new ArrayList<>();
        String color = mode.equals(ChangeMode.ADDED)?JsonV2Comparator.added: JsonV2Comparator.deleted;
        if (mode.equals(ChangeMode.ADDED)) {
            for (String key: map.keySet()) {
                result.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText(key).attr("style", JsonV2Comparator.fistColumnWidth),
                        new Element("th").appendText(""),
                        new Element("th").appendText(map.get(key)).attr("style", "color:" + color)
                ))));
            }
        }
        else if (mode.equals(ChangeMode.DELETED)) {
            for (String key: map.keySet()) {
                result.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText(key).attr("style", JsonV2Comparator.fistColumnWidth),
                        new Element("th").appendText(""),
                        new Element("th").appendText(map.get(key)).attr("style", "color:" + color)
                ))));
            }
        }
        return result;
    }

    public static String compare (Parameters p1, Parameters p2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table")
                .attr("style", JsonV2Comparator.width);
        document.body().selectFirst("table").appendElement("tr").appendElement("td").appendElement("p").appendElement("b")
                .appendText("Common");
        document.body().selectFirst("table").appendChildren(formATable(p1.getCommon().getParams(), p2.getCommon().getParams()));

        document.body().selectFirst("table").appendElement("tr").appendElement("td").appendText(" ").
                attr("style", "color: white").attr("style", "height: 20px");

        document.body().selectFirst("table").appendElement("tr").appendElement("td").appendText(" ").
                attr("style", "color: white").attr("style", "height: 20px");


        if (p1.getServices() == null) {
            if (p2.getServices() == null) {
                return document.outerHtml();
            }

            else {
                document.body().selectFirst("table").appendElement("tr").appendElement("td").appendElement("p").appendElement("b").
                        appendText("services");
                for (String key: p2.getServices().getSn().keySet()) {
                    document.body().selectFirst("table").
                            appendChildren(formATable(p2.getServices().getSn().get(key).getParams(), ChangeMode.ADDED));
                }
                return document.outerHtml();
            }
        }
        else {
            if (p2.getServices() == null) {
                document.body().selectFirst("table").appendElement("tr").appendElement("td").appendElement("p").appendElement("b").
                        appendText("services");
                for (String key: p1.getServices().getSn().keySet()) {
                    document.body().selectFirst("table").
                            appendChildren(formATable(p1.getServices().getSn().get(key).getParams(), ChangeMode.DELETED));
                }
                return document.outerHtml();
            }
        }
        document.body().selectFirst("table").appendElement("tr").appendElement("td").appendElement("p").appendElement("b").
                appendText("services");
        for (String key: p1.getServices().getSn().keySet()) {
            if (p2.getServices().getSn().containsKey(key)) {
                document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText(key);
                document.body().selectFirst("table").
                        appendChildren(formATable(p1.getServices().getSn().get(key).getParams(), p2.getServices().getSn().get(key).getParams()));
            }
            else {
                document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText(key);
                document.body().selectFirst("table").
                        appendChildren(formATable(p1.getServices().getSn().get(key).getParams(), ChangeMode.DELETED));
            }
        }
        for (String key: p2.getServices().getSn().keySet()) {
            if (! p1.getServices().getSn().containsKey(key)) {
                document.body().selectFirst("table").appendElement("tr").appendElement("th").appendText(key);
                document.body().selectFirst("table").
                        appendChildren(formATable(p2.getServices().getSn().get(key).getParams(), ChangeMode.ADDED));
            }
        }
        return document.outerHtml();
    }
}
