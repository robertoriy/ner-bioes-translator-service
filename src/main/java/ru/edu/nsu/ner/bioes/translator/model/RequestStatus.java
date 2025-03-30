package ru.edu.nsu.ner.bioes.translator.model;

public enum RequestStatus {
    NOT_STARTED("Обработка не начата"),
    IN_PROGRESS("Обработка в процессе"),
    FINISHED("Обработка завершена");

    private final String text;

    RequestStatus(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
