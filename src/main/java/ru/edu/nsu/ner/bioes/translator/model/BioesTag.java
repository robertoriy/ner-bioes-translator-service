package ru.edu.nsu.ner.bioes.translator.model;

import ru.edu.nsu.ner.bioes.translator.utils.BioesUtility;

public enum BioesTag {
    BEGIN("B", BioesUtility.DEFAULT_BIOES_SEPARATOR),
    INSIDE("I", BioesUtility.DEFAULT_BIOES_SEPARATOR),
    OUTSIDE("O", BioesUtility.EMPTY_BIOES_SEPARATOR),
    END("E", BioesUtility.DEFAULT_BIOES_SEPARATOR),
    SINGLE("S", BioesUtility.DEFAULT_BIOES_SEPARATOR),
    ;

    private final String code;
    private final String separator;

    BioesTag(String code, String separator) {
        this.code = code;
        this.separator = separator;
    }

    public String code() {
        return code;
    }
}
