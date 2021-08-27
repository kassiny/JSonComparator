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

    static ArrayList<Node> formATable (Service service1, String color) {
        ArrayList<Node> res = new ArrayList<>();
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_short_name"),
                new Element("th").appendText(service1.getService_short_name()).attr("style", "color:" + color)))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("service_name"),
                new Element("th").appendText(service1.getService_name().toString()).attr("style", "color:" + color)))));

        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("artifact_type"),
                new Element("th").appendText(service1.getArtifact_type().toString()).attr("style", "color:" + color)))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_registry"),
                new Element("th").appendText(service1.getDocker_registry()).attr("style", "color:" + color)))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_image"),
                new Element("th").appendText(service1.getDocker_image_name()).attr("style", "color:" + color)))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("docker_tag"),
                new Element("th").appendText(service1.getDocker_tag()).attr("style", "color:" + color)))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("force"),
                new Element("th").appendText(service1.getForce().toString()).attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_repository"),
                new Element("th").appendText(service1.getGithub_repository().toString()).attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>( Arrays.asList(
                new Element("th").appendText("github_branch"),
                new Element("th").appendText(service1.getGithub_branch().toString()).attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendChildren( new ArrayList<>(Arrays.asList(
                new Element("th").appendText("github_hash"),
                new Element("th").appendText(service1.getGithub_hash().toString()).attr("style", "color:" + color)
        ))));

        res.add(new Element("tr").appendElement("th").appendText("hashes"));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha1"),
                new Element("th").appendText(service1.getHashes().getSha1()).attr("style", "color:" + color)
        ))));
        res.add(new Element("tr").appendChildren(new ArrayList<>(Arrays.asList(
                new Element("th").appendText("sha256"),
                new Element("th").appendText(service1.getHashes().getSha256())
        ))));

        return res;
    }
    public static String compare (Service[] s1, Service[] s2) {
         Document document = Jsoup.parse("");
         document.body().appendElement("table").appendElement("tr").appendElement("th").appendText("Services");

         for (Service ser1: s1) {
             for (Service ser2: s2) {
                 // Comparing services by keys
                if (ser1.getDocker_image_name().equals(ser2.getDocker_image_name())
                        && ser1.getDocker_tag().equals(ser2.getDocker_tag())) {
                    if (ser1.equals(ser2)) {
                        document.body().selectFirst("table").
                                appendElement("tr").appendElement("th").appendText("Service");
                        document.body().selectFirst("table").appendChildren(formATable(ser1,"black"));
                    }
                    else {
                        document.body().selectFirst("table").
                                appendElement("tr").appendElement("th").appendText("Service");
                        document.body().selectFirst("table").appendChildren(formATable(ser1,"GoldenRod"));
                    }
                }
             }
         }

         return document.outerHtml();
     }


}
