package ru.edu.nsu.ner.bioes.translator.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.edu.nsu.ner.bioes.translator.dto.base.Language;

import java.util.List;

@JsonPropertyOrder({
        "fromLanguages",
        "toLanguages"
})
public record LanguagesResponse(
        @JsonProperty("fromLanguages")
        List<Language> fromLanguages,

        @JsonProperty("toLanguages")
        List<Language> toLanguages
) {
}
