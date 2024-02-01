package org.tkit.onecx.product.store.mfe.operator;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicrofrontendSpec {

    @JsonProperty("appId")
    private String appId;

    @JsonProperty("appVersion")
    private String appVersion;

    @JsonProperty("appName")
    private String appName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("remoteBaseUrl")
    private String remoteBaseUrl;

    @JsonProperty("remoteEntry")
    private String remoteEntry;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("classifications")
    private Set<String> classifications;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("iconName")
    private String iconName;

    @JsonProperty("note")
    private String note;

    @JsonProperty("exposedModule")
    private String exposedModule;

    @JsonProperty("technology")
    private String technology;

    @JsonProperty("endpoints")
    private List<MicrofrontendEndpointSpec> endpoints;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemoteBaseUrl() {
        return remoteBaseUrl;
    }

    public void setRemoteBaseUrl(String remoteBaseUrl) {
        this.remoteBaseUrl = remoteBaseUrl;
    }

    public String getRemoteEntry() {
        return remoteEntry;
    }

    public void setRemoteEntry(String remoteEntry) {
        this.remoteEntry = remoteEntry;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<String> getClassifications() {
        return classifications;
    }

    public void setClassifications(Set<String> classifications) {
        this.classifications = classifications;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExposedModule() {
        return exposedModule;
    }

    public void setExposedModule(String exposedModule) {
        this.exposedModule = exposedModule;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public List<MicrofrontendEndpointSpec> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<MicrofrontendEndpointSpec> endpoints) {
        this.endpoints = endpoints;
    }

    @Override
    public String toString() {
        return "MicrofrontendSpec{" +
                "appId='" + appId + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
