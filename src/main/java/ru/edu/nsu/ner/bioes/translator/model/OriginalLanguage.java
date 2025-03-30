package ru.edu.nsu.ner.bioes.translator.model;

public enum OriginalLanguage {
    Uzbek("Узбекский язык", "uz");

    private final String text;
    private final String code;

    OriginalLanguage(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public String text() {
        return text;
    }

    public String code() {
        return code;
    }
}
