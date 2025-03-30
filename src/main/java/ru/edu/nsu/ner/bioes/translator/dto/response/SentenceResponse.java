package ru.edu.nsu.ner.bioes.translator.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.edu.nsu.ner.bioes.translator.dto.base.NamedEntities;
import ru.edu.nsu.ner.bioes.translator.dto.base.Sentence;

@JsonPropertyOrder({
        "id",
        "originalSentence",
        "translatedSentence",
        "namedEntities",
        "fromLanguage",
        "toLanguage",
        "status"
})
public record SentenceResponse(
        @JsonProperty("id")
        long id,

        @JsonProperty("originalSentence")
        Sentence originalSentence,

        @JsonProperty("translatedSentence")
        Sentence translatedSentence,

        @JsonProperty("namedEntities")
        NamedEntities namedEntities,

        @JsonProperty("fromLanguage")
        String fromLanguage,

        @JsonProperty("toLanguage")
        String toLanguage,

        @JsonProperty("status")
        String status
) {
}
