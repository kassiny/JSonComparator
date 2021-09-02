package Comparator;

import JsonStructure.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class ServicesComparator {
    // create an empty html document
     //Document result = Jsoup.parse("");


     ArrayList<Service> services;


    public ServicesComparator(ArrayList<Service> services) {
        this.services = services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    static ArrayList<Node> formATable(Service service, String color) {
        ArrayList<Node> res = new ArrayList<>();

        res.add(new Element("tr").appendElement("th").appendText("Service"));

        //if (change == ColorChange.YELLOW)
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_short_name"),
                new Element("th").appendText(service.getService_short_name()).
                        attr("style",
                                "color: " + color)

        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_name"),
                new Element("th").appendText(service.getService_name().get()).
                        attr("style", "color:" +color)
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("artifact_type"),
                new Element("th").appendText(service.getArtifact_type().get()).
                        attr("style", "color:" +color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_registry"),
                new Element("th").appendText(service.getDocker_registry()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_image"),
                new Element("th").appendText(service.getDocker_image_name()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_tag"),
                new Element("th").appendText(service.getDocker_tag()).
                        attr("style", "color:" +color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("force"),
                new Element("th").appendText(service.getForce().get().toString()).
                        attr("style", "color:" +color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_repository"),
                new Element("th").appendText(service.getGithub_repository().get()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>( Arrays.asList(
                new Element("th").appendText("github_branch"),
                new Element("th").appendText(service.getGithub_branch().get()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_hash"),
                new Element("th").appendText(service.getGithub_hash().get()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendElement("th").appendText("hashes"));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(service.getHashes().getSha1()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha256"),
                new Element("th").appendText(service.getHashes().getSha256()).
                        attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendText("  "));

        return res;
    }

    static ArrayList<Node> formATable (Service service1, Service service2) {
        ArrayList<Node> res = new ArrayList<>();

        res.add(new Element("tr").appendElement("th").appendText("Service"));

        //if (change == ColorChange.YELLOW)
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_short_name"),
                new Element("th").appendText(service1.getService_short_name()).
                        attr("style",
                                "color: " + (service1.getService_short_name().equals(service2.getService_short_name())? "black":"GoldenRod")),
                new Element("th").appendText(service2.getService_short_name()).
                        attr("style",
                                "color:" + (service1.getService_short_name().equals(service2.getService_short_name())? "black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_name"),
                new Element("th").appendText(service1.getService_name().get()).
                        attr("style", "color:" +
                                        (service1.getService_name().equals(service2.getService_name())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getService_name().get()).
                        attr("style", "color:" +
                                (service1.getService_name().equals(service2.getService_name())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("artifact_type"),
                new Element("th").appendText(service1.getArtifact_type().get()).
                        attr("style", "color:" +
                                (service1.getArtifact_type().equals(service2.getArtifact_type())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getArtifact_type().get()).
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
                new Element("th").appendText(service1.getForce().get().toString()).
                        attr("style", "color:" +
                                (service1.getForce().equals(service2.getForce())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getForce().get().toString()).
                        attr("style", "color:" +
                                (service1.getForce().equals(service2.getForce())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_repository"),
                new Element("th").appendText(service1.getGithub_repository().get()).
                        attr("style", "color:" +
                                (service1.getGithub_repository().equals(service2.getGithub_repository())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getGithub_repository().get()).
                        attr("style", "color:" +
                                (service1.getGithub_repository().equals(service2.getGithub_repository())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>( Arrays.asList(
                new Element("th").appendText("github_branch"),
                new Element("th").appendText(service1.getGithub_branch().get()).
                        attr("style", "color:" +
                                (service1.getGithub_branch().equals(service2.getGithub_branch())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getGithub_branch().get()).
                        attr("style", "color:" +
                                (service1.getGithub_branch().equals(service2.getGithub_branch())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_hash"),
                new Element("th").appendText(service1.getGithub_hash().get()).
                        attr("style", "color:" +
                                (service1.getGithub_hash().equals(service2.getGithub_hash())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getGithub_hash().get()).
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

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha256"),
                new Element("th").appendText(service1.getHashes().getSha256()).
                        attr("style", "color:" +
                                (service1.getHashes().getSha256().equals(service2.getHashes().getSha256())?"black":"GoldenRod")),
                new Element("th").appendText(service2.getHashes().getSha256()).
                        attr("style", "color:" +
                                (service1.getHashes().getSha256().equals(service2.getHashes().getSha256())?"black":"GoldenRod"))
        ))));

        res.add(new Element("tr").appendText("  "));

        return res;
    }
    public static String compare (Service[] s1, Service[] s2) {
         Document document = Jsoup.parse("");
         document.body().appendElement("table").appendElement("tr").appendElement("th").appendText("Services");
         document.body().selectFirst("table").attr("border", "1px solid black");

         boolean [] foundInSecond = new boolean[s2.length] ;
        for (boolean b: foundInSecond
             ) {
            b = false;
        }

         for (Service ser1: s1) {
             boolean foundchanged = false;
             for (int i = 0; i < s2.length; i++) {
                 // Comparing services by keys
                if (ser1.getDocker_image_name().equals(s2[i].getDocker_image_name())
                        && ser1.getDocker_tag().equals(s2[i].getDocker_tag())) {
                    foundchanged = true;
                    document.body().selectFirst("table").appendChildren(formATable(ser1, s2[i]));
                    foundInSecond[i] = true;
                }
             }
             if (!foundchanged) {
                 document.body().selectFirst("table").appendChildren(formATable(ser1, "Red"));
             }
         }

         for (int i = 0; i < s2.length; i ++) {
             if (!foundInSecond[i]) {
                 document.body().selectFirst("table").appendChildren(formATable(s2[i], "DarkGreen"));
             }
         }

         return document.outerHtml();
     }


}
