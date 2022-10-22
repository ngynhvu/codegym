package com.example.spingelectronicmailbox.model;

public class MailBox {
    private int id;
    private String language;
        private int page;
    private String spams;
    private String signature;

    public MailBox() {
    }

    public MailBox(int id, String language, int page, String spams, String signature) {
        this.id = id;
        this.language = language;
        this.page = page;
        this.spams = spams;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSpams() {
        return spams;
    }

    public void setSpams(String spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
