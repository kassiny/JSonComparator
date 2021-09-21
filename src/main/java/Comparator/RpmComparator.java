package Comparator;

import JsonStructure.Rpm;
import JsonStructure.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class RpmComparator {

    static ArrayList<Node> formATable (Rpm rpm, ChangeMode mode) {
        ArrayList<Node> res = new ArrayList<>();
        String  color = (mode.equals(ChangeMode.DELETED)?JsonV2Comparator.deleted: JsonV2Comparator.added);
        if (mode.equals(ChangeMode.DELETED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("url").attr("style", JsonV2Comparator.fistColumnWidth),
                    new Element("th").appendText(rpm.getUrl()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("rpm repository name"),
                    new Element("th").appendText(rpm.getRpm_repository_name()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendElement("th").appendText("hashes"));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(rpm.getHashes().getSha1()).attr("style", "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha256"),
                    new Element("th").appendText(rpm.getHashes().getSha256()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name"),
                    new Element("th").appendText(rpm.getService_short_name().isPresent() ? rpm.getService_short_name().get() : "null").attr("style",
                            "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("url").attr("style", JsonV2Comparator.fistColumnWidth),
                    new Element("th").appendText(" "),
                    new Element("th").appendText(rpm.getUrl()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("rpm repository name"),
                    new Element("th").appendText(" "),
                    new Element("th").appendText(rpm.getRpm_repository_name()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendElement("th").appendText("hashes"));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(" "),
                    new Element("th").appendText(rpm.getHashes().getSha1()).attr("style", "color:" + color)
            ))));
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha256"),
                    new Element("th").appendText(" "),
                    new Element("th").appendText(rpm.getHashes().getSha256()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name"),
                    new Element("th").appendText(" "),
                    new Element("th").appendText(rpm.getService_short_name().isPresent() ? rpm.getService_short_name().get() : "null").attr("style",
                            "color:" + color)
            ))));
        }

        return res;
    }
    static ArrayList<Node> formATable (Rpm rpm1, Rpm rpm2) {
        ArrayList<Node> res = new ArrayList<>();
        String equal = "black";
        String diff = "GoldenRod";

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("url").attr("style", JsonV2Comparator.fistColumnWidth),
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

    public static String compare (Rpm[] rpm1, Rpm[] rpm2) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table")
                .attr("style", JsonV2Comparator.width);

        boolean [] foundInSecond = new boolean[rpm2.length];

        for (boolean b: foundInSecond
        ) {
            b = false;
        }

        for (Rpm r1: rpm1) {
            boolean foundchanged = false;
            for (int i = 0; i < rpm2.length; i++) {
                // Comparing services by keys
                if (r1.getRpm_repository_name().equals(rpm2[i].getRpm_repository_name())) {
                    foundchanged = true;
                    document.body().selectFirst("table").appendChildren(formATable(r1, rpm2[i]));
                    foundInSecond[i] = true;
                }
            }
            if (!foundchanged) {
                document.body().selectFirst("table").appendChildren(formATable(r1, ChangeMode.DELETED));
            }
        }

        for (int i = 0; i < rpm2.length; i ++) {
            if (!foundInSecond[i]) {
                document.body().selectFirst("table").appendChildren(formATable(rpm2[i], ChangeMode.ADDED));
            }
        }

        return document.outerHtml();
    }
}
