package io.github.onecx.product.store.mfe.operator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicrofrontendSpec {

    @JsonProperty("product-store")
    private String productStore;

    @JsonProperty("mfe-id")
    private String mfeId;

    @JsonProperty("base-path")
    private String basePath;
    @JsonProperty("product-name")
    private String productName;

    @JsonProperty("remote-entry")
    private String remoteEntry;

    @JsonProperty("remote-name")
    private String remoteName;

    @JsonProperty("exposed-module")
    private String exposedModule;

    @JsonProperty("display-name")
    private String displayName;

    @JsonProperty("module-type")
    private ModuleType moduleType;

    @JsonProperty("wc-tag-name")
    private String wcTagName;

    @JsonProperty("app-id")
    private String appId;

    @JsonProperty("app-version")
    private String appVersion;

    @JsonProperty("note")
    private String note;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("remote-base-url")
    private String remoteBaseUrl;

    public enum ModuleType {

        ANGULAR,
        WEBCOMPONENT;
    }

    public String getMfeId() {
        return mfeId;
    }

    public void setMfeId(String mfeId) {
        this.mfeId = mfeId;
    }

    public String getProductStore() {
        return productStore;
    }

    public void setProductStore(String productStore) {
        this.productStore = productStore;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemoteEntry() {
        return remoteEntry;
    }

    public void setRemoteEntry(String remoteEntry) {
        this.remoteEntry = remoteEntry;
    }

    public String getRemoteName() {
        return remoteName;
    }

    public void setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }

    public String getExposedModule() {
        return exposedModule;
    }

    public void setExposedModule(String exposedModule) {
        this.exposedModule = exposedModule;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public String getWcTagName() {
        return wcTagName;
    }

    public void setWcTagName(String wcTagName) {
        this.wcTagName = wcTagName;
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemoteBaseUrl() {
        return remoteBaseUrl;
    }

    public void setRemoteBaseUrl(String remoteBaseUrl) {
        this.remoteBaseUrl = remoteBaseUrl;
    }
}
