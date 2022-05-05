package com.example.model;

public class Email {
    private String language;
    private Integer pageSize;
    private boolean spamsFilter;
    private String signNature;

    public Email(String language, Integer pageSize, boolean spamsFilter, String signNature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signNature = signNature;
    }

    public Email() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignNature() {
        return signNature;
    }

    public void setSignNature(String signNature) {
        this.signNature = signNature;
    }
}
