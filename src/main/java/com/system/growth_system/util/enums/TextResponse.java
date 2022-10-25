package com.system.growth_system.util.enums;

public enum TextResponse {
    SUCCESS_STATUS("Success"),
    ERROR_STATUS("Error");

    private String value;

    TextResponse(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
