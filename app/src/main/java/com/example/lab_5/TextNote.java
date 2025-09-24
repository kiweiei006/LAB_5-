package com.example.lab_5;

public class TextNote extends Note {
    private String textContent;

    public TextNote(String title, String createdDate, String textContent) {
        super(title, createdDate);
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String newContent) {
        this.textContent = newContent;
    }

    @Override
    public String getSummary() {
        return title + ": " + textContent + " (" + createdDate + ")";
    }
}
