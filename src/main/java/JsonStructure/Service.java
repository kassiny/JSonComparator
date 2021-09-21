package JsonStructure;

import JsonStructure.Hashes;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

public class Service {
    @JsonProperty("service-short-name")
    Optional<String> service_short_name;
    String service_name;

    Optional<String> artifact_type;
    String docker_registry;
    String docker_image_name;
    String docker_tag;
    Optional<Boolean> force;
    Optional<String> github_repository;
    Optional<String> github_branch;
    Optional<String> github_hash;
    Hashes hashes;

    public String getService_name() {
        return service_name;
    }

    public Optional<String> getArtifact_type() {
        return artifact_type;
    }

    public Optional<String> getGithub_repository() {
        return github_repository;
    }

    public Optional<String> getGithub_branch() {
        return github_branch;
    }

    public Optional<String> getGithub_hash() {
        return github_hash;
    }

    public void setService_name(String service_name) {
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

    public Optional<String> getService_short_name() {
        return service_short_name;
    }

    public void setService_short_name(Optional<String> service_short_name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return Objects.equals(service_short_name, service.service_short_name) && Objects.equals(service_name, service.service_name) && Objects.equals(artifact_type, service.artifact_type) && Objects.equals(docker_registry, service.docker_registry) && Objects.equals(docker_image_name, service.docker_image_name) && Objects.equals(docker_tag, service.docker_tag) && Objects.equals(force, service.force) && Objects.equals(github_repository, service.github_repository) && Objects.equals(github_branch, service.github_branch) && Objects.equals(github_hash, service.github_hash) && Objects.equals(hashes, service.hashes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service_short_name, service_name, artifact_type, docker_registry, docker_image_name, docker_tag, force, github_repository, github_branch, github_hash, hashes);
    }

    public Service () {
        service_short_name = Optional.empty();
        artifact_type = Optional.empty();
        force = Optional.empty();
        github_repository = Optional.empty();
        github_branch = Optional.empty();
        github_hash = Optional.empty();
    }
}
