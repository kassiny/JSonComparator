package Comparator;

import JsonStructure.Rpm;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class RpmComparator {

    static ArrayList<Node> formATable (Rpm rpm1, Rpm rpm2) {
        ArrayList<Node> res = new ArrayList<>();
        String equal = "black";
        String diff = "GoldenRod";

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("url"),
                new Element("th").appendText(rpm1.getUrl()).attr("style", "color:" +
                        (rpm1.getUrl().equals(rpm2.getUrl())?equal:diff)),
                new Element("th").appendText(rpm2.getUrl()).attr("style", "color:" +
                        (rpm1.getUrl().equals(rpm2.getUrl())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("rpm repository name"),
                new Element("th").appendText(rpm1.getRpm_repository_name()).attr("style", "color:" +
                        (rpm1.getRpm_repository_name().equals(rpm2.getRpm_repository_name())?equal:diff)),
                new Element("th").appendText(rpm2.getRpm_repository_name()).attr("style", "color:" +
                        (rpm1.getRpm_repository_name().equals(rpm2.getRpm_repository_name())?equal:diff))
        ))));

        res.add(new Element("tr").appendElement("th").appendText("hashes"));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(rpm1.getHashes().getSha1()).attr("style", "color:" +
                        (rpm1.getHashes().getSha1().equals(rpm2.getHashes().getSha1())?equal:diff)),
                new Element("th").appendText(rpm2.getHashes().getSha1()).attr("style", "color:" +
                        (rpm1.getHashes().getSha1().equals(rpm2.getHashes().getSha1())?equal:diff))
        ))));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha256"),
                new Element("th").appendText(rpm1.getHashes().getSha256()).attr("style", "color:" +
                        (rpm1.getHashes().getSha256().equals(rpm2.getHashes().getSha256())?equal:diff)),
                new Element("th").appendText(rpm2.getHashes().getSha256()).attr("style", "color:" +
                        (rpm1.getHashes().getSha256().equals(rpm2.getHashes().getSha256())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service short name"),
                new Element("th").appendText(rpm1.getService_short_name().isPresent()? rpm1.getService_short_name().get(): "null").attr("style",
                        "color:" + (rpm1.getService_short_name().equals(rpm2.getService_short_name())?equal: diff)),
                new Element("th").appendText(rpm2.getService_short_name().isPresent()? rpm2.getService_short_name().get(): "null").attr("style",
                        "color:" + (rpm1.getService_short_name().equals(rpm2.getService_short_name())?equal: diff))
        ))));

        return res;
    }

    public static String compare (Rpm rpm1, Rpm rpm2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table").appendChildren(formATable(rpm1,rpm2));
        return document.outerHtml();
    }
}
