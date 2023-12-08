package io.github.onecx.product.store.mfe.operator;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.javaoperatorsdk.operator.api.ObservedGenerationAwareStatus;

public class MicrofrontendStatus extends ObservedGenerationAwareStatus {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("appId")
    private String appId;

    @JsonProperty("appVersion")
    private String appVersion;

    @JsonProperty("appName")
    private String appName;

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("message")
    private String message;

    public enum Status {

        ERROR,

        CREATED,

        UPDATED,

        UNDEFINED;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
