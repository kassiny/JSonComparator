package Comparator;

import JsonStructure.Hashes;
import JsonStructure.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class ServicesComparator {

     ArrayList<Service> services;


    public ServicesComparator(ArrayList<Service> services) {
        this.services = services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    static ArrayList<Node> formATable(Service service, ChangeMode mode) {
        ArrayList<Node> res = new ArrayList<>();

        //res.add(new Element("tr").appendElement("th").appendText("Service"));
        String color;

        if (service.getService_name() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("service name is missing!!!").attr("style", "color: red")));
            service.setService_name(" ");
        }
        if (service.getHashes() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes is missing!!!").attr("style", "color: red")));
            service.setHashes(new Hashes());
            service.getHashes().setSha1(" ");
            service.getHashes().setSha256(" ");
        }
        if (service.getHashes().getSha1() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes sha1 is missing!!!").attr("style", "color: red")));
            service.getHashes().setSha1(" ");
        }
        if (service.getHashes().getSha256() == null) {
            res.add(new Element("tr").appendChild(new Element("th").
                    appendText("hashes sha256 is missing!!!").attr("style", "color: red")));
            service.getHashes().setSha256(" ");
        }
        if (service.getDocker_registry() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("docker_registry is missing!!!").attr("style", "color: red")));
            service.setDocker_registry(" ");
        }

        switch (mode) {
            case DELETED: color = JsonV2Comparator.deleted; break;
            case ADDED: color = JsonV2Comparator.added; break;
            default: color = "black";
        }

        if (mode.equals(ChangeMode.DELETED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service_short_name").attr("style", JsonV2Comparator.fistColumnWidth),
                    new Element("th").appendText(service.getService_short_name().isPresent()? service.getService_short_name().get(): "null").
                            attr("style",
                                    "color: " + color)

            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service_short_name"),
                    new Element("th").appendText(" "),
                    new Element("th").appendText(service.getService_short_name().isPresent()? service.getService_short_name().get():"null").
                            attr("style",
                                    "color: " + color)

            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service_name"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getService_name()).
                            attr("style", "color:" + color)

            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("service_name"),
                    new Element("th").appendText(service.getService_name()).
                            attr("style", "color:" + color)

            ))));
        }
        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("artifact_type"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getArtifact_type().isPresent()? service.getArtifact_type().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("artifact_type"),
                    new Element("th").appendText(service.getArtifact_type().isPresent()? service.getArtifact_type().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("docker_registry"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getDocker_registry()).
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("docker_registry"),
                    new Element("th").appendText(service.getDocker_registry()).
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("docker_image"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getDocker_image_name()).
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("docker_image"),
                    new Element("th").appendText(service.getDocker_image_name()).
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("docker_tag"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getDocker_tag()).
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("docker_tag"),
                    new Element("th").appendText(service.getDocker_tag()).
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("force"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getForce().isPresent()?service.getForce().get().toString(): "null").
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("force"),
                    new Element("th").appendText(service.getForce().isPresent()?service.getForce().get().toString(): "null").
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("github_repository"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getGithub_repository().isPresent()? service.getGithub_repository().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("github_repository"),
                    new Element("th").appendText(service.getGithub_repository().isPresent()? service.getGithub_repository().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }
        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("github_branch"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getGithub_branch().isPresent()? service.getGithub_branch().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("github_branch"),

                    new Element("th").appendText(service.getGithub_hash().isPresent()? service.getGithub_branch().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("github_hash"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getGithub_hash().isPresent()? service.getGithub_hash().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("github_hash"),

                    new Element("th").appendText(service.getGithub_hash().isPresent()? service.getGithub_hash().get(): "null").
                            attr("style", "color:" + color)
            ))));
        }

        res.add(new Element("tr").appendElement("th").appendText("hashes"));

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getHashes().getSha1()).
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha1"),
                    new Element("th").appendText(service.getHashes().getSha1()).
                            attr("style", "color:" + color)
            ))));
        }

        if (mode.equals(ChangeMode.ADDED)) {
            res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha256"),
                    new Element("th").appendText(""),
                    new Element("th").appendText(service.getHashes().getSha256()).
                            attr("style", "color:" + color)
            ))));
        }
        else {
            res.add(new Element("tr").attr("margin-bottom", "60px").appendChildren(new ArrayList<>(Arrays.asList(
                    new Element("th").appendText("sha256"),
                    new Element("th").appendText(service.getHashes().getSha256()).
                            attr("style", "color:" + color).
                            attr("margin-bottom", "60px")
            ))));
        }

        res.add(new Element("tr").appendElement("td").appendText("--------").attr("style", "color:white").
                appendElement("td").appendText("--------").attr("style", "color:white").
                appendElement("td").appendText("--------").attr("style", "color:white"));

        return res;
    }

    static ArrayList<Node> formATable (Service service1, Service service2) {
        ArrayList<Node> res = new ArrayList<>();

        //res.add(new Element("tr").appendElement("th").appendText("Service"));
        if (service1.getService_name() == null) {
            res.add(new Element("tr").appendChild(new Element("th").
                    appendText("service name is missing!!!").attr("style", "color: red")));
            service1.setService_name(" ");
        }
        if (service1.getHashes() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes is missing!!!").attr("style", "color: red")));
            service1.setHashes(new Hashes());
            service1.getHashes().setSha1(" ");
            service1.getHashes().setSha256(" ");
        }
        if (service1.getHashes().getSha1() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes sha1 is missing!!!").attr("style", "color: red")));
            service1.getHashes().setSha1(" ");
        }
        if (service1.getHashes().getSha256() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes sha256 is missing!!!").attr("style", "color: red")));
            service1.getHashes().setSha256(" ");
        }

        if (service1.getDocker_registry() == null) {
            res.add(new Element("tr").appendChild(new Element("th").
                    appendText("docker_registry is missing!!!").attr("style", "color: red")));
            service1.setDocker_registry(" ");
        }
        //----------
        if (service2.getService_name() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("service name is missing!!!").attr("style", "color: red")));
            service2.setService_name(" ");
        }
        if (service2.getHashes() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes is missing!!!").attr("style", "color: red")));
            service2.setHashes(new Hashes());
            service2.getHashes().setSha1(" ");
            service2.getHashes().setSha256(" ");
        }
        if (service2.getHashes().getSha1() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("hashes sha1 is missing!!!").attr("style", "color: red")));
            service2.getHashes().setSha1(" ");
        }
        if (service2.getHashes().getSha256() == null) {
            res.add(new Element("tr").appendChild(new Element("th").
                    appendText("hashes sha256 is missing!!!").attr("style", "color: red")));
            service2.getHashes().setSha256(" ");
        }
        if (service2.getDocker_registry() == null) {
            res.add(new Element("tr").appendChild( new Element("th").
                    appendText("docker_registry is missing!!!").attr("style", "color: red")));
            service2.setDocker_registry(" ");
        }

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_short_name").attr("style", JsonV2Comparator.fistColumnWidth),
                new Element("th").appendText(service1.getService_short_name().isPresent()? service1.getService_short_name().get():"null").
                        attr("style",
                                "color: " + (service1.getService_short_name().equals(service2.getService_short_name())? "black":"GoldenRod")),
                new Element("th").appendText(service2.getService_short_name().isPresent()? service2.getService_short_name().get(): "null").
                        attr("style",
                                "color:" + (service1.getService_short_name().equals(service2.getService_short_name())? "black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_name"),
                new Element("th").appendText(service1.getService_name()).
                        attr("style", "color:" +
                                        (service1.getService_name().equals(service2.getService_name())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getService_name()).
                        attr("style", "color:" +
                                (service1.getService_name().equals(service2.getService_name())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("artifact_type"),
                new Element("th").appendText(service1.getArtifact_type().isPresent()? service1.getArtifact_type().get(): "null").
                        attr("style", "color:" +
                                (service1.getArtifact_type().equals(service2.getArtifact_type())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getArtifact_type().isPresent()? service2.getArtifact_type().get():"null").
                        attr("style", "color:" +
                                (service1.getArtifact_type().equals(service2.getArtifact_type())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_registry"),
                new Element("th").appendText(service1.getDocker_registry()).
                        attr("style", "color:" +
                                (service1.getDocker_registry().equals(service2.getDocker_registry())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getDocker_registry()).
                        attr("style", "color:" +
                                (service1.getDocker_registry().equals(service2.getDocker_registry())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_image"),
                new Element("th").appendText(service1.getDocker_image_name()).
                        attr("style", "color:" +
                                (service1.getDocker_image_name().equals(service2.getDocker_image_name())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getDocker_image_name()).
                        attr("style", "color:" +
                                (service1.getDocker_image_name().equals(service2.getDocker_image_name())?"black":"GoldenRod"))))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_tag"),
                new Element("th").appendText(service1.getDocker_tag()).
                        attr("style", "color:" +
                                (service1.getDocker_tag().equals(service2.getDocker_tag())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getDocker_tag()).
                        attr("style", "color:" +
                                (service1.getDocker_tag().equals(service2.getDocker_tag())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("force"),
                new Element("th").appendText(service1.getForce().isPresent()? service1.getForce().get().toString(): "null").
                        attr("style", "color:" +
                                (service1.getForce().equals(service2.getForce())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getForce().isPresent()? service2.getForce().get().toString(): "null").
                        attr("style", "color:" +
                                (service1.getForce().equals(service2.getForce())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_repository"),
                new Element("th").appendText(service1.getGithub_repository().isPresent()? service1.getGithub_repository().get(): "null").
                        attr("style", "color:" +
                                (service1.getGithub_repository().equals(service2.getGithub_repository())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getGithub_repository().isPresent()? service2.getGithub_repository().get(): "null").
                        attr("style", "color:" +
                                (service1.getGithub_repository().equals(service2.getGithub_repository())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>( Arrays.asList(
                new Element("th").appendText("github_branch"),
                new Element("th").appendText(service1.getGithub_branch().isPresent()? service1.getGithub_branch().get(): "null").
                        attr("style", "color:" +
                                (service1.getGithub_branch().equals(service2.getGithub_branch())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getGithub_branch().isPresent()? service2.getGithub_branch().get(): "null").
                        attr("style", "color:" +
                                (service1.getGithub_branch().equals(service2.getGithub_branch())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_hash"),
                new Element("th").appendText(service1.getGithub_hash().isPresent()? service1.getGithub_hash().get(): "null").
                        attr("style", "color:" +
                                (service1.getGithub_hash().equals(service2.getGithub_hash())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getGithub_hash().isPresent()? service2.getGithub_hash().get(): "null").
                        attr("style", "color:" +
                                (service1.getGithub_hash().equals(service2.getGithub_hash())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendElement("th").appendText("hashes"));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(service1.getHashes().getSha1()).
                        attr("style", "color:" +
                                (service1.getHashes().getSha1().equals(service2.getHashes().getSha1())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getHashes().getSha1()).
                        attr("style", "color:" +
                                (service1.getHashes().getSha1().equals(service2.getHashes().getSha1())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr"). attr("margin-bottom", "60px").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha256"),
                new Element("th").appendText(service1.getHashes().getSha256()).
                        attr("style", "color:" +
                                (service1.getHashes().getSha256().equals(service2.getHashes().getSha256())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getHashes().getSha256()).
                        attr("style", "color:" +
                                (service1.getHashes().getSha256().equals(service2.getHashes().getSha256())?"black":"GoldenRod")).
                        attr("margin-bottom" , "60px")
        ))));

        res.add(new Element("tr").appendElement("td").appendText("--------").attr("style", "color:white").
                appendElement("td").appendText("--------").attr("style", "color:white").
                appendElement("td").appendText("-------- <br>").attr("style", "color:white"));

        return res;
    }
    public static String compare (Service[] s1, Service[] s2) {
         Document document = Jsoup.parse("");
         document.body().appendElement("table").attr("style", JsonV2Comparator.width).appendElement("tr").appendElement("th").appendText("Services");
         document.body().selectFirst("table");
         boolean [] foundInSecond = new boolean[s2.length] ;
         for (boolean b: foundInSecond
              ) {
             b = false;
         }

         for (Service ser1: s1) {
             boolean foundChanged = false;
             for (int i = 0; i < s2.length; i++) {
                 // Comparing services by keys
                if (ser1.getDocker_image_name().equals(s2[i].getDocker_image_name())
                        && ser1.getDocker_tag().equals(s2[i].getDocker_tag())) {
                    foundChanged = true;
                    document.body().selectFirst("table").appendChildren(formATable(ser1, s2[i]));
                    foundInSecond[i] = true;
                }
             }
             if (!foundChanged) {
                 document.body().selectFirst("table").appendChildren(formATable(ser1, ChangeMode.DELETED));
             }
         }

         for (int i = 0; i < s2.length; i ++) {
             if (!foundInSecond[i]) {
                 document.body().selectFirst("table").appendChildren(formATable(s2[i], ChangeMode.ADDED));
             }
         }

         return document.outerHtml();
     }
}
