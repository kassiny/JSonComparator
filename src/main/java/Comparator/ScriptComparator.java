package Comparator;

import JsonStructure.Script;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class ScriptComparator {

    static ArrayList<Node> formATable(Script script, ChangeMode mode) {
        ArrayList<Node> res = new ArrayList<>();
        String color = mode.equals(ChangeMode.DELETED)?"Red":"LimeGreen";

        if (mode.equals(ChangeMode.DELETED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name").attr("style", JsonV2Comparator.fistColumnWidth),
                    new Element("th").appendText(script.getService_short_name().isPresent() ?
                            script.getService_short_name().get() : "null").attr("style", "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("start point"),
                    new Element("th").appendText(script.getStart_point().isPresent() ? script.getStart_point().get() : "null").
                            attr("style", "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("end point"),
                    new Element("th").appendText(script.getEnd_point().isPresent() ? script.getEnd_point().get() : "null").attr("style",
                            "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("script name"),
                    new Element("th").appendText(script.getScript_name()).attr("style",
                            "color:" + color)
            ))));

            res.add(new Element("tr").appendElement("th").appendText("hashes"));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(script.getHashes().getSha1()).attr("style",
                            "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha256"),
                    new Element("th").appendText(script.getHashes().getSha256()).attr("style",
                            "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("url"),
                    new Element("th").appendText(script.getUrl()).attr("style",
                            "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getService_short_name().isPresent() ?
                            script.getService_short_name().get() : "null").attr("style", "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("start point"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getStart_point().isPresent() ? script.getStart_point().get() : "null").
                            attr("style", "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("end point"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getEnd_point().isPresent() ? script.getEnd_point().get() : "null").attr("style",
                            "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("script name"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getScript_name()).attr("style",
                            "color:" + color)
            ))));

            res.add(new Element("tr").appendElement("th").appendText("hashes"));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getHashes().getSha1()).attr("style",
                            "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha256"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getHashes().getSha256()).attr("style",
                            "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("url"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(script.getUrl()).attr("style",
                            "color:" + color)
            ))));
        }
        res.add(new Element("tr").appendElement("td").appendText(" ").attr("style", "color: white").attr("style", "height: 60px"));
        return  res;
    }

    static ArrayList<Node> formATable(Script script1, Script script2) {
        ArrayList<Node> res = new ArrayList<>();
        String eq = "black";
        String diff = "GoldenRod";

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service short name").attr("style", JsonV2Comparator.fistColumnWidth),
                new Element("th").appendText(script1.getService_short_name().isPresent()?
                        script1.getService_short_name().get():"null").attr("style","color:" +
                        (script1.getService_short_name().equals(script2.getService_short_name())?eq:diff)),
                new Element("th").appendText(script2.getService_short_name().isPresent()? script2.getService_short_name().get():"null").attr("style","color:" +
                        (script1.getService_short_name().equals(script2.getService_short_name())?eq:diff))
        ))));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("start point"),
                new Element("th").appendText(script1.getStart_point().isPresent()? script1.getStart_point().get(): "null").attr("style",
                        "color:" + (script1.getStart_point().equals(script2.getStart_point())?eq:diff)),
                new Element("th").appendText(script2.getStart_point().isPresent()? script2.getStart_point().get(): "null").attr("style",
                        "color:" +(script1.getStart_point().equals(script2.getStart_point())?eq:diff))
        ))));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("end point"),
                new Element("th").appendText(script1.getEnd_point().isPresent()? script1.getEnd_point().get():"null").attr("style",
                        "color:"+ (script1.getEnd_point().equals(script2.getEnd_point())?eq:diff)),
                new Element("th").appendText(script2.getEnd_point().isPresent()? script2.getEnd_point().get():"null").attr("style",
                        "color:"+ (script1.getEnd_point().equals(script2.getEnd_point())?eq:diff))
        ))));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("script name"),
                new Element("th").appendText(script1.getScript_name()).attr("style",
                        "color:" + (script1.getScript_name().equals(script2.getScript_name())?eq:diff)),
                new Element("th").appendText(script2.getScript_name()).attr("style",
                        "color:" + (script1.getScript_name().equals(script2.getScript_name())?eq:diff))
        ))));

        res.add(new Element("tr").appendElement("th").appendText("hashes"));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(script1.getHashes().getSha1()).attr("style",
                        "color:" + (script1.getHashes().getSha1().equals(script2.getHashes().getSha1())?eq:diff)),
                new Element("th").appendText(script2.getHashes().getSha1()).attr("style",
                        "color:" + (script1.getHashes().getSha1().equals(script2.getHashes().getSha1())?eq:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha256"),
                new Element("th").appendText(script1.getHashes().getSha256()).attr("style",
                        "color:" + (script1.getHashes().getSha256().equals(script2.getHashes().getSha256())?eq:diff)),
                new Element("th").appendText(script2.getHashes().getSha256()).attr("style",
                        "color:" + (script1.getHashes().getSha256().equals(script2.getHashes().getSha256())?eq:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("url"),
                new Element("th").appendText(script1.getUrl()).attr("style",
                        "color:" + (script1.getUrl().equals(script2.getUrl())?eq: diff)),
                new Element("th").appendText(script2.getUrl()).attr("style",
                        "color:" + (script1.getUrl().equals(script2.getUrl())?eq: diff))
        ))));
        res.add(new Element("tr").appendElement("td").appendText(" ").attr("style", "color: white").attr("style", "height: 60px"));
        return  res;
    }
    public static String compare (Script[] s1, Script[] s2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table")
                .attr("style", JsonV2Comparator.width);

        boolean[] foundIn2 = new boolean[s2.length];
        for(boolean b: foundIn2) {
            b = false;
        }
        for (Script s: s1) {
            boolean found = false;
            for (int i =0; i < s2.length; i ++) {
                if (s.getScript_name().equals(s2[i].getScript_name())){
                    found = true;
                    foundIn2[i] = true;
                    document.body().selectFirst("table").appendChildren(formATable(s, s2[i]));
                }
            }
            if (!found) {
                document.body().selectFirst("table").appendChildren(formATable(s, ChangeMode.DELETED));
            }
        }
        for (int i = 0; i < s2.length; i ++) {
            if (!foundIn2[i]) {
                document.body().selectFirst("table").appendChildren(formATable(s2[i], ChangeMode.ADDED));
            }
        }
        return document.outerHtml();
    }
}
