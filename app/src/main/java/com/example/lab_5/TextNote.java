package com.example.lab_5;

public class TextNote extends Note {
    public String setTextContent;
    private String textContent;

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String newContent) {
        this.textContent = newContent;
    }

    public String getSummary() {

        return title + ": " + setTextContent + " (" + createdDate + ")";
    }
}