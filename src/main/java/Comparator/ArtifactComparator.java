package Comparator;

import JsonStructure.Artifact;
import JsonStructure.ArtifactFile;
import JsonStructure.ArtifactMvn;
import JsonStructure.ArtifactType;
import JsonStructure.*;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class ArtifactComparator {

    static  ArrayList<Node> mnvNodes(Mvn mvn1, Mvn mvn2) {
        ArrayList<Node> res = new ArrayList<>();
        String equal = "black";
        String diff = "GoldenRod";
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("GroupID"),
                new Element("th").appendText(mvn1.getGroupId()).attr("style", "color:" +
                        (mvn1.getGroupId().equals(mvn2.getGroupId())?equal:diff)),
                new Element("th").appendText(mvn2.getGroupId()).attr("style", "color" +
                        (mvn1.getGroupId().equals(mvn2.getGroupId())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("ArtifactId"),
                new Element("th").appendText(mvn1.getArtifactId()).attr("style", "color:" +
                        (mvn1.getArtifactId().equals(mvn2.getArtifactId())?equal:diff)),
                new Element("th").appendText(mvn2.getArtifactId()).attr("style", "color:" +
                        (mvn1.getArtifactId().equals(mvn2.getArtifactId())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("version"),
                new Element("th").appendText(mvn1.getVersion()).attr("style", "color:" +
                        (mvn1.getVersion().equals(mvn2.getVersion())?equal:diff)),
                new Element("th").appendText(mvn2.getVersion()).attr("style", "color:" +
                        (mvn1.getVersion().equals(mvn2.getVersion())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("Service name"),
                new Element("th").appendText(mvn1.getService_name().get()).attr("style", "color:" +
                        (mvn1.getService_name().equals(mvn2.getService_name())?equal:diff)),
                new Element("th").appendText(mvn2.getService_name().get()).attr("style", "color:" +
                        (mvn1.getService_name().equals(mvn2.getService_name())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("classifier"),
                new Element("th").appendText(mvn1.getClassifier().get()).attr("style", "color: " +
                        (mvn1.getClassifier().equals(mvn2.getClassifier())?equal:diff)),
                new Element("th").appendText(mvn2.getClassifier().get()).attr("style", "color: " +
                        (mvn1.getClassifier().equals(mvn2.getClassifier())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("mvn type"),
                new Element("th").appendText(mvn1.getMvn_type()).attr("style", "color:" +
                        (mvn1.getMvn_type().equals(mvn2.getMvn_type())?equal:diff)),
                new Element("th").appendText(mvn2.getMvn_type()).attr("style", "color:" +
                        (mvn1.getMvn_type().equals(mvn2.getMvn_type())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(Arrays.asList(
                new Element("th").appendText("mvn repository"),
                new Element("th").appendText(mvn1.getMvn_repository()).attr("style", "color:" +
                        (mvn1.getMvn_repository().equals(mvn2.getMvn_repository())?equal:diff)),
                new Element("th").appendText(mvn2.getMvn_repository()).attr("style", "color:" +
                        (mvn1.getMvn_repository().equals(mvn2.getMvn_repository())?equal:diff))
        )));

        res.add(new Element("tr").appendElement("th").appendText("hashes"));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(mvn1.getHashes().getSha1()).attr("style", "color:" +
                        (mvn1.getHashes().getSha1().equals(mvn2.getHashes().getSha1())?equal:diff)),
                new Element("th").appendText(mvn2.getHashes().getSha1()).attr("style", "color:" +
                        (mvn1.getHashes().getSha1().equals(mvn2.getHashes().getSha1())?equal:diff))
        ))));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(mvn1.getHashes().getSha256()).attr("style", "color:" +
                        (mvn1.getHashes().getSha256().equals(mvn2.getHashes().getSha256())?equal:diff)),
                new Element("th").appendText(mvn2.getHashes().getSha256()).attr("style", "color:" +
                        (mvn1.getHashes().getSha256().equals(mvn2.getHashes().getSha256())?equal:diff))
        ))));

        return res;
    }
    static ArrayList<Node> formATable (Artifact artifact1, Artifact artifact2) {
        ArrayList<Node> res = new ArrayList<>();
        if (!artifact1.getArtifactType().equals(artifact2.getArtifactType())) {
            return res;
        }
        else if (artifact1.getArtifactType().equals(ArtifactType.FILE.toString()) ) {
            ArtifactFile ar1 = (ArtifactFile) artifact1;
            ArtifactFile ar2 = (ArtifactFile) artifact2;

            String equal = "black";
            String diff = "GoldenRod";

            res.add( new Element("tr").appendChildren(new ArrayList<Node>( Arrays.asList(
                    new Element("th").appendText("Service name"),
                    new Element("th").appendText((ar1.getService_name().get())).attr("style","color:" +
                            (ar1.getService_name().equals(ar2.getService_name())?equal: diff)),
                    new Element("th").appendText((ar2.getService_name().get())).attr("style","color:" +
                            (ar1.getService_name().equals(ar2.getService_name())?equal: diff))
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name"),
                    new Element("th").appendText(ar1.getService_short_name().get()).attr("style","color:" +
                            (ar1.getService_short_name().equals(ar2.getService_short_name())?equal:diff)),
                    new Element("th").appendText(ar2.getService_short_name().get()).attr("style","color:" +
                            (ar1.getService_short_name().equals(ar2.getService_short_name())?equal:diff))
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("artifact type"),
                    new Element("th").appendText(ar1.getArtifactType()).attr("style", "color:" +
                            (ar1.getArtifactType().equals(ar2.getArtifactType())?equal:diff)),
                    new Element("th").appendText(ar2.getArtifactType()).attr("style", "color:" +
                            (ar1.getArtifactType().equals(ar2.getArtifactType())?equal:diff))
            ))));


        }
        else if (artifact1.getArtifactType().equals(ArtifactType.MVN.toString())) {
            ArtifactMvn ar1 = (ArtifactMvn) artifact1;
            ArtifactMvn ar2 = (ArtifactMvn) artifact2;
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("target repository"),
                    new Element("th").appendText(ar1.getTarget_repository()),
                    new Element("th").appendText(ar2.getTarget_repository())
            ))));

            res.add(new Element("tr").appendChild( new Element("th").appendText("mvn")));
            for (Mvn m1: ar1.getMvn()) {
                for (int i = 0; i < ar2.getMvn().length; i ++) {
                    if (m1.getGroupId().equals(ar2.getMvn()[i].getGroupId()) &&
                            m1.getVersion().equals(ar2.getMvn()[i].getVersion()) &&
                                    m1.getMvn_type().equals(ar2.getMvn()[i].getMvn_type())) {
                        res.addAll(mnvNodes(m1, ar2.getMvn()[i]));
                    }
                }
            }
        }
        return res;
    }


    public static String compare (Artifact[] artifacts1, Artifact[] artifacts2 ) {
        Document document = Jsoup.parse("");

        return  document.outerHtml();
    }
}
