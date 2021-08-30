package Comparator;

import JsonStructure.Artifact;
import JsonStructure.ArtifactFile;
import JsonStructure.ArtifactType;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class ArtifactComparator {
    static ArrayList<Node> formATable (Artifact artifact1, Artifact artifact2, String color) {
        ArrayList<Node> res = new ArrayList<>();
        if (!artifact1.getArtifactType().equals(artifact2.getArtifactType())) {
            return res;
        }
        else if (artifact1.getArtifactType().equals(ArtifactType.FILE.toString()) ) {
            ArtifactFile ar1 = (ArtifactFile) artifact1;
            ArtifactFile ar2 = (ArtifactFile) artifact2;

            res.add( new Element("tr").appendChildren(new ArrayList<Node>( Arrays.asList(
                    new Element("th").appendText("Service name"),
                    new Element("th").appendText((ar1.getService_name().toString())).attr("style","color:" + color),
                    new Element("th").appendText((ar2.getService_name().toString())).attr("style","color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name"),
                    new Element("th").appendText(ar1.getService_short_name().toString()).attr("style","color:" + color),
                    new Element("th").appendText(ar2.getService_short_name().toString()).attr("style","color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("artifact type"),
                    new Element("th").appendText(ar1.getArtifactType()).attr("style", "color:" + color),
                    new Element("th").appendText(ar2.getArtifactType()).attr("style", "color:" + color)
            ))));


        }
        else if (artifact1.getArtifactType().equals(ArtifactType.MVN.toString())) {

        }
        return res;
    }


    public static String compare (Artifact[] artifacts1, Artifact[] artifacts2 ) {
        Document document = Jsoup.parse("");

        return  document.outerHtml();
    }
}
