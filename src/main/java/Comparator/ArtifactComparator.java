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

    static  ArrayList<Node> mnvNodes(Mvn mvn, ChangeMode mode) {
        ArrayList<Node> res = new ArrayList<>();
        String color;
        switch (mode) {
            case ADDED: color = JsonV2Comparator.added; break;
            case DELETED: color = "Red"; break;
            default: color = "black";
        }

        if (mode.equals(ChangeMode.DELETED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("GroupID").attr("style", JsonV2Comparator.fistColumnWidth),
                    new Element("th").appendText(mvn.getGroupId()).attr("style", "color:" + color)
                            .attr("padding-left", "1px")
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("ArtifactId"),
                    new Element("th").appendText(mvn.getArtifactId()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("version"),
                    new Element("th").appendText(mvn.getVersion()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("Service name"),
                    new Element("th").appendText(
                            mvn.getService_name().isPresent()? mvn.getService_name().get(): "null").
                                attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("classifier"),
                    new Element("th").appendText(
                            mvn.getClassifier().isPresent()? mvn.getClassifier().get(): "null").
                                attr("style", "color: " + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("mvn type"),
                    new Element("th").appendText(mvn.getMvn_type()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(Arrays.asList(
                    new Element("th").appendText("mvn repository"),
                    new Element("th").appendText(mvn.getMvn_repository()).attr("style", "color:" + color)
            )));

            res.add(new Element("tr").appendElement("th").appendText("hashes"));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(mvn.getHashes().getSha1()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(mvn.getHashes().getSha256()).attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("GroupID").attr("style", JsonV2Comparator.fistColumnWidth),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getGroupId()).attr("style", "color:" + color)
                            .attr("padding-left", "1px")
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("ArtifactId"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getArtifactId()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("version"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getVersion()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("Service name"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getService_name().isPresent()?mvn.getService_name().get():"null").attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("classifier"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getClassifier().isPresent()?mvn.getClassifier().get():"null").
                            attr("style", "color: " + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("mvn type"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getMvn_type()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(Arrays.asList(
                    new Element("th").appendText("mvn repository"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getMvn_repository()).attr("style", "color:" + color)
            )));

            res.add(new Element("tr").appendElement("th").appendText("hashes"));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getHashes().getSha1()).attr("style", "color:" + color)
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(mvn.getHashes().getSha256()).attr("style", "color:" + color)
            ))));
        }

        res.add(new Element("tr").appendElement("td").appendText("--------").attr("style", "color: white"));
        return res;
    }

    static  ArrayList<Node> mnvNodes(Mvn mvn1, Mvn mvn2) {
        ArrayList<Node> res = new ArrayList<>();
        String equal = "black";
        String diff = "GoldenRod";
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("GroupID").attr("style", JsonV2Comparator.fistColumnWidth),
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
                new Element("th").appendText(mvn1.getService_name().isPresent()?mvn1.getService_name().get():"null").
                        attr("style", "color:" +
                            (mvn1.getService_name().equals(mvn2.getService_name())?equal:diff)),
                new Element("th").appendText(mvn2.getService_name().isPresent()?mvn2.getService_name().get():"null").
                        attr("style", "color:" +
                            (mvn1.getService_name().equals(mvn2.getService_name())?equal:diff))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("classifier"),
                new Element("th").appendText(mvn1.getClassifier().isPresent()? mvn1.getClassifier().get(): "null").
                        attr("style", "color: " +
                            (mvn1.getClassifier().equals(mvn2.getClassifier())?equal:diff)),
                new Element("th").appendText(mvn2.getClassifier().isPresent()?mvn2.getClassifier().get():"null").
                        attr("style", "color: " +
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
        res.add(new Element("tr").appendElement("td").appendText("--------").attr("style", "color: white"));

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
                    new Element("th").appendText(ar1.getService_name().isPresent()? ar1.getService_name().get(): "null").
                        attr("style","color:" +
                            (ar1.getService_name().equals(ar2.getService_name())?equal: diff)),
                    new Element("th").appendText((ar2.getService_name().isPresent()? ar2.getService_name().get(): "null")).
                            attr("style","color:" +
                                (ar1.getService_name().equals(ar2.getService_name())?equal: diff))
            ))));

            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service short name"),
                    new Element("th").appendText(
                           ar1.getService_short_name().isPresent()? ar1.getService_short_name().get(): "null").
                                attr("style","color:" +
                                    (ar1.getService_short_name().equals(ar2.getService_short_name())?equal:diff)),

                    new Element("th").appendText(
                            ar2.getService_short_name().isPresent()? ar2.getService_short_name().get(): "null").attr("style","color:" +
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

            boolean[] foundInMvn2 = new boolean[ar2.getMvn().length];
            for (boolean b: foundInMvn2) {
                b = false;
            }

            for (Mvn m1: ar1.getMvn()) {
                boolean found = false;
                for (int i = 0; i < ar2.getMvn().length; i ++) {
                    if (m1.getGroupId().equals(ar2.getMvn()[i].getGroupId()) &&
                            m1.getVersion().equals(ar2.getMvn()[i].getVersion()) &&
                                    m1.getMvn_type().equals(ar2.getMvn()[i].getMvn_type())) {
                        found = true;
                        foundInMvn2[i] = true;
                        res.add(new Element("tr").appendElement("td").appendChildren(mnvNodes(m1, ar2.getMvn()[i])));
                        // res.addAll(mnvNodes(m1, ar2.getMvn()[i]));
                    }
                }
                if (!found) {
                    res.addAll(mnvNodes(m1, ChangeMode.DELETED));
                }
            }
            for (int i = 0; i <foundInMvn2.length; i++) {
                if (!foundInMvn2[i]) {
                    res.addAll(mnvNodes(ar2.getMvn()[i],ChangeMode.ADDED));
                }
            }
        }
        res.add(new Element("tr").appendElement("td").appendText(" ").attr("style", "color: white").attr("style", "height: 60px"));
        return res;
    }

    static ArrayList<Node> formATable (Artifact artifact, ChangeMode mode) {
         ArrayList<Node> res = new ArrayList<>();
         String color = mode.equals(ChangeMode.ADDED)?JsonV2Comparator.added:"Red";

         if (artifact.getArtifactType().equals(ArtifactType.FILE.value) ) {
            ArtifactFile ar = (ArtifactFile) artifact;
            if (mode.equals(ChangeMode.DELETED)) {
                res.add(new Element("tr").appendChildren(new ArrayList<Node>(Arrays.asList(
                        new Element("th").appendText("Service name"),
                        new Element("th").appendText(ar.getService_name().isPresent() ? ar.getService_name().get() : "null").
                                attr("style", "color:" + color)
                ))));

                res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText("service short name"),
                        new Element("th").appendText(
                                        ar.getService_short_name().isPresent() ? ar.getService_short_name().get() : "null").
                                attr("style", "color:" + color)
                ))));

                res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText("artifact type"),
                        new Element("th").appendText(ar.getArtifactType()).attr("style", "color:" + color)
                ))));
            }
            else {
                res.add(new Element("tr").appendChildren(new ArrayList<Node>(Arrays.asList(
                        new Element("th").appendText("Service name"),
                        new Element("th").appendText(""),
                        new Element("th").appendText(ar.getService_name().isPresent() ? ar.getService_name().get() : "null").
                                attr("style", "color:" + color)
                ))));

                res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText("service short name"),
                        new Element("th").appendText(""),
                        new Element("th").appendText(
                                        ar.getService_short_name().isPresent() ? ar.getService_short_name().get() : "null").
                                attr("style", "color:" + color)
                ))));

                res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText("artifact type"),
                        new Element("th").appendText(""),
                        new Element("th").appendText(ar.getArtifactType()).attr("style", "color:" + color)
                ))));
            }
        }
        else if (artifact.getArtifactType().equals(ArtifactType.MVN.toString())) {
            ArtifactMvn ar1 = (ArtifactMvn) artifact;
            if (mode.equals(ChangeMode.DELETED)) {
                res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText("target repository"),
                        new Element("th").appendText(ar1.getTarget_repository())
                ))));
            }
            else {
                res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                        new Element("th").appendText("target repository"),
                        new Element("th").appendText(""),
                        new Element("th").appendText(ar1.getTarget_repository())
                ))));
            }

            res.add(new Element("tr").appendChild( new Element("th").appendText("mvn")));
            for (Mvn m: ar1.getMvn()) {
                res.add(new Element("tr").appendElement("td").appendChildren(mnvNodes(m, mode)));
            }

        }
        res.add(new Element("tr").appendElement("td").appendText(" ").attr("style", "color: white").attr("style", "height: 60px"));
        return res;
    }

    public static String compare (Artifact[] artifacts1, Artifact[] artifacts2 ) {
        Document document = Jsoup.parse("");
        document.body().appendElement("table").attr("style", " border: 1px solid black")
                .attr("style", JsonV2Comparator.width);

        boolean[] foundIn2 = new boolean[artifacts2.length];
        for (boolean b: foundIn2) {
            b = false;
        }

        for (Artifact ar1: artifacts1) {
            boolean found = false;
            for (int i = 0; i < artifacts2.length; i ++) {
                if (ar1.getArtifactType().equals(artifacts2[i].getArtifactType())) {
                    if (ar1.getArtifactType().equals(ArtifactType.FILE.value) ) {
                        ArtifactFile arfile1 = (ArtifactFile) ar1;
                        ArtifactFile arfile2 = (ArtifactFile) artifacts2[i];
                        if (Arrays.equals(arfile1.getFile(), arfile2.getFile())) {
                            found = true;
                            foundIn2[i] = true;
                            document.body().selectFirst("table").appendChildren(formATable(arfile1, arfile2));
                        }
                    }
                    else  if ( ar1.getArtifactType().equals(ArtifactType.MVN.value)) {
                        found = true;
                        foundIn2[i] = true;
                        ArtifactMvn artifactMvn1 = (ArtifactMvn) ar1;
                        ArtifactMvn artifactMvn2 = (ArtifactMvn) artifacts2[i];
                        document.body().selectFirst("table").appendChildren(formATable(artifactMvn1, artifactMvn2));
                    }
                }
            }
            if (!found) {
                document.body().selectFirst("table").appendChildren(formATable(ar1, ChangeMode.DELETED));
            }
        }

        for (int i = 0 ; i <artifacts2.length; i ++) {
            if (!foundIn2[i]) {
                document.body().appendChildren(formATable(artifacts2[i],ChangeMode.ADDED));
            }
        }
        return  document.outerHtml();
    }
}