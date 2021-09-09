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
        String added = "Green";
        String deleted = "red";

        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) {
                arrayList.add(new Element("tr").
                        appendChildren(new ArrayList<>(Arrays.asList(
                                new Element("th").appendText(key),
                                new Element("th").appendText(map1.get(key)).
                                        attr("style","color:" +
                                                (map1.get(key).equals(map1.get(key))?equal:diff)),
                                new Element("th").appendText(map2.get(key)).
                                        attr("style","color:" +
                                                (map1.get(key).equals(map2.get(key))?equal:diff))
                        ))));
            }
            else {
                arrayList.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText(key),
                        new Element("th").appendText(map1.get(key)).attr("style", "color:" + deleted)
                ))));
            }
        }
        for (String key: map2.keySet()) {
            if (!map1.containsKey(key)) {
                arrayList.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText(key),
                        new Element("th").appendText(""),
                        new Element("th").appendText(map2.get(key)).attr("style", "color:" + added)
                ))));
            }
        }
        return  arrayList;
    }

    public static String compare (Parameters p1, Parameters p2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table").attr("border", "1px solid black");
        document.body().selectFirst("table").appendChildren(formATable(p1.getCommon().getParams(), p2.getCommon().getParams()));

        for (String key: p1.getServices().getSn().keySet()) {
            if (p2.getServices().getSn().containsKey(key)) {
                formATable(p1.getServices().getSn().get(key).getParams(), p2.getServices().getSn().get(key).getParams());
            }
            //!!!
        }

        // !!!!!
        return document.outerHtml();
    }
}
