package io.github.onecx.product.store.mfe.operator;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.javaoperatorsdk.operator.api.ObservedGenerationAwareStatus;

public class MicrofrontendStatus extends ObservedGenerationAwareStatus {

    @JsonProperty("product-name")
    private String productName;

    @JsonProperty("mfe-id")
    private String mfeId;

    @JsonProperty("response-code")
    private int responseCode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

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

    public String getMfeId() {
        return mfeId;
    }

    public void setMfeId(String mfeId) {
        this.mfeId = mfeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
