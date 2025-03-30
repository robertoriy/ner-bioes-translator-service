package ru.edu.nsu.ner.bioes.translator.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentenceResponse;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentencesResponse;
import ru.edu.nsu.ner.bioes.translator.service.SentenceService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Tag(name = "Request Controller", description = "Операции с предложениям")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RequestController {
    private final SentenceService sentenceService;

    @Operation(
            summary = "Запрос списка предложений",
            description = "Возвращает список все предложений с краткой информацией"
    )
    @GetMapping("/requests/{request_id}/sentences")
    public SentencesResponse getSentences(
            @PathVariable("request_id") long requestId,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
    ) {
        return sentenceService.getSentences(requestId, pageable);
    }

    @Operation(
            summary = "Запрос конкретного предложения",
            description = "Возвращает предложение с детальной информацией"
    )
    @GetMapping("/requests/{request_id}/sentences/{sentence_id}")
    public SentenceResponse getSentence(
            @PathVariable("request_id") long requestId,
            @PathVariable("sentence_id") long sentenceId
    ) {
        return sentenceService.getSentence(requestId, sentenceId);
    }

    @Operation(
            summary = "Скачать переведенные предложения",
            description = "Скачивает переведенные предложения с разметкой в формате CSV"
    )
    @GetMapping("/requests/{request_id}/sentences-csv")
    public ResponseEntity<Resource> downloadCsvFile(
            @PathVariable("request_id") long requestId
    ) {
        List<String[]> csvData = Arrays.asList(
                new String[]{"word", "tag"},
                new String[]{"Тестовая", "B-PER"},
                new String[]{"Запись", "E-PER"}
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Добавляем BOM для правильного определения UTF-8
        out.write(0xEF);
        out.write(0xBB);
        out.write(0xBF);
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.csv")
                .header(HttpHeaders.CONTENT_TYPE, "text/csv; charset=UTF-8")
//                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new InputStreamResource(in));
    }

    @Operation(
            summary = "Загрузить CSV файл",
            description = "Загрузить CSV файл с разметкой"
    )
    @PostMapping("/requests")
    public String uploadCsvFile(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("file") MultipartFile file
    ) {
        log.info("Translate from - {} to - {}", from, to);
        if (file.isEmpty()) {
            return "empty file";
        }

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            CsvToBean<BioesDto> csvToBean = new CsvToBeanBuilder<BioesDto>(reader)
                    .withType(BioesDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<BioesDto> bioes = csvToBean.parse();

            for (BioesDto b : bioes) {
                System.out.println(b);
            }

            return "Успешно загружено " + bioes.size() + " записей";

        } catch (IOException e) {
            return "Ошибка при обработке файла: " + e.getMessage();
        }
    }

    public class BioesDto {
        @CsvBindByName(column = "word", required = true)
        private String word;

        @CsvBindByName(column = "Tag", required = true) // Обратите внимание на регистр столбца!
        private String tag;

        // Обязательные геттеры и сеттеры
        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
