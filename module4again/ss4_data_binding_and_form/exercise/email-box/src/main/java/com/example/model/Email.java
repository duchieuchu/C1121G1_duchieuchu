package com.example.model;

public class Email {
    private String languages;
    private Integer pageSize;
    private boolean spamsFitter;
    private String signature;

    public Email(String languages, Integer pageSize, boolean spamsFitter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFitter = spamsFitter;
        this.signature = signature;
    }

    public Email() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFitter() {
        return spamsFitter;
    }

    public void setSpamsFitter(boolean spamsFitter) {
        this.spamsFitter = spamsFitter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
