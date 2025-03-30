package ru.edu.nsu.ner.bioes.translator.model;

public enum TargetLanguage {
    RUSSIAN("Русский язык", "ru"),
    ENGLISH("Английский язык", "en"),
    KAZAKH("Казахский язык", "kk");

    private final String text;
    private final String code;

    TargetLanguage(String text, String code) {
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
