package JsonStructure;

import JsonStructure.Hashes;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class Service {
    @JsonProperty("service-short-name")
    String service_short_name;
    Optional<String> service_name;
    Optional<String> artifact_type;
    String docker_registry;
    String docker_image_name;
    String docker_tag;
    Optional<Boolean> force;
    Optional<String> github_repository;
    Optional<String> github_branch;
    Optional<String> github_hash;
    Hashes hashes;

    public void setService_name(Optional<String> service_name) {
        this.service_name = service_name;
    }

    public void setArtifact_type(Optional<String> artifact_type) {
        this.artifact_type = artifact_type;
    }

    public Optional<Boolean> getForce() {
        return force;
    }

    public void setForce(Optional<Boolean> force) {
        this.force = force;
    }

    public void setGithub_repository(Optional<String> github_repository) {
        this.github_repository = github_repository;
    }

    public void setGithub_branch(Optional<String> github_branch) {
        this.github_branch = github_branch;
    }

    public void setGithub_hash(Optional<String> github_hash) {
        this.github_hash = github_hash;
    }

    public String getService_short_name() {
        return service_short_name;
    }

    public void setService_short_name(String service_short_name) {
        this.service_short_name = service_short_name;
    }

    public String getDocker_registry() {
        return docker_registry;
    }

    public void setDocker_registry(String docker_registry) {
        this.docker_registry = docker_registry;
    }

    public String getDocker_image_name() {
        return docker_image_name;
    }

    public void setDocker_image_name(String docker_image_name) {
        this.docker_image_name = docker_image_name;
    }

    public String getDocker_tag() {
        return docker_tag;
    }

    public void setDocker_tag(String docker_tag) {
        this.docker_tag = docker_tag;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    @Override
    public String toString() {
        return "JsonStructure.Service{" +
                "service_short_name='" + service_short_name + '\'' +
                ", service_name='" + service_name + '\'' +
                ", artifact_type='" + artifact_type + '\'' +
                ", docker_registry='" + docker_registry + '\'' +
                ", docker_image_name='" + docker_image_name + '\'' +
                ", docker_tag='" + docker_tag + '\'' +
                ", force=" + force +
                ", github_repository='" + github_repository + '\'' +
                ", github_branch='" + github_branch + '\'' +
                ", github_hash='" + github_hash + '\'' +
                ", hashes=" + hashes +
                '}';
    }
}
