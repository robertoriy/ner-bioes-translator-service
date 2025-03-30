package ru.edu.nsu.ner.bioes.translator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.nsu.ner.bioes.translator.dto.base.Language;
import ru.edu.nsu.ner.bioes.translator.dto.response.LanguagesResponse;
import ru.edu.nsu.ner.bioes.translator.model.OriginalLanguage;
import ru.edu.nsu.ner.bioes.translator.model.TargetLanguage;

import java.util.List;

@Tag(name = "Request Controller", description = "Операции с предложениям")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OperationsController {
    @GetMapping("/languages")
    public LanguagesResponse getLanguages() {
        return new LanguagesResponse(
                List.of(
                        new Language(
                                OriginalLanguage.Uzbek.text(),
                                OriginalLanguage.Uzbek.code())
                ),
                List.of(
                        new Language(
                                TargetLanguage.RUSSIAN.text(),
                                TargetLanguage.RUSSIAN.code()
                        ),
                        new Language(
                                TargetLanguage.ENGLISH.text(),
                                TargetLanguage.ENGLISH.code()
                        ),
                        new Language(
                                TargetLanguage.KAZAKH.text(),
                                TargetLanguage.KAZAKH.code()
                        )
                )
        );
    }
}
