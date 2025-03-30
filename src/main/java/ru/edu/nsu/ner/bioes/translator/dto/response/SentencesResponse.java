package ru.edu.nsu.ner.bioes.translator.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.domain.Page;
import ru.edu.nsu.ner.bioes.translator.dto.base.SentenceShort;

@JsonPropertyOrder({
        "sentences",
        "fromLanguage",
        "toLanguage",
        "percentageOfProcessedSentences"
})
public record SentencesResponse(
        @JsonProperty("sentences")
        Page<SentenceShort> sentences,

        @JsonProperty("fromLanguage")
        String fromLanguage,

        @JsonProperty("toLanguage")
        String toLanguage,

        @JsonProperty("percentageOfProcessedSentences")
        int percentageOfProcessedSentences
) {
}
