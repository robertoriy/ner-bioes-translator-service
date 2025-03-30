package ru.edu.nsu.ner.bioes.translator.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import ru.edu.nsu.ner.bioes.translator.dto.base.*;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentenceResponse;
import ru.edu.nsu.ner.bioes.translator.dto.response.SentencesResponse;
import ru.edu.nsu.ner.bioes.translator.model.BioesTag;
import ru.edu.nsu.ner.bioes.translator.model.OriginalLanguage;
import ru.edu.nsu.ner.bioes.translator.model.RequestStatus;
import ru.edu.nsu.ner.bioes.translator.model.TargetLanguage;
import ru.edu.nsu.ner.bioes.translator.utils.BioesUtility;

import java.util.ArrayList;
import java.util.List;


public class MockSentenceDao {
    public static SentencesResponse getPageOfSentences(Pageable pageable) {
        List<SentenceShort> sentences = new ArrayList<>();
        for (long i = 0; i < 100; i++) {
            SentenceShort sentenceShort = new SentenceShort(
                    i,
                    "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
                    "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
                    RequestStatus.FINISHED.text()
            );
            sentences.add(sentenceShort);
        }
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), sentences.size());

        Page<SentenceShort> pageSentences = new PageImpl<>(
                sentences.subList(start, end),
                pageable,
                sentences.size()
        );

        int percentageOfProcessedSentences = 77;
        return new SentencesResponse(
                pageSentences,
                OriginalLanguage.Uzbek.text(),
                TargetLanguage.RUSSIAN.text(),
                percentageOfProcessedSentences
        );
    }

    public static SentenceResponse getSentenceResponse(long id) {
        EntityType tagLoc = new EntityType("LOC", "green");
        EntityType tagPer = new EntityType("PER", "red");
        EntityType tagOrg = new EntityType("ORG", "blue");

        List<EntityType> tags = List.of(tagLoc, tagPer, tagOrg);

        String codeB = BioesTag.BEGIN.code();
        String codeI = BioesTag.INSIDE.code();
        String codeO = BioesTag.OUTSIDE.code();
        String codeE = BioesTag.END.code();
        String codeS = BioesTag.SINGLE.code();

        String defaultSeparator = BioesUtility.DEFAULT_BIOES_SEPARATOR;
        String emptySeparator = BioesUtility.EMPTY_BIOES_SEPARATOR;

        String originalFullSentence = "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin";
        List<Word> originalWords = List.of(
                new Word("O‘zbekiston", new Tag(codeB, defaultSeparator), tagLoc),
                new Word("Respublikasi", new Tag(codeE, defaultSeparator), tagLoc),
                new Word("Prezidentining", new Tag(codeS, defaultSeparator), tagPer),
                new Word("2023", new Tag(codeO, emptySeparator), null),
                new Word("yil", new Tag(codeO, emptySeparator), null),
                new Word("25", new Tag(codeO, emptySeparator), null),
                new Word("yanvardagi", new Tag(codeO, emptySeparator), null),
                new Word("Respublika", new Tag(codeS, defaultSeparator), tagLoc),
                new Word("ijro", new Tag(codeO, emptySeparator), null),
                new Word("etuvchi", new Tag(codeO, emptySeparator), null),
                new Word("hokimiyat", new Tag(codeB, defaultSeparator), tagOrg),
                new Word("organlari", new Tag(codeE, defaultSeparator), tagOrg),
                new Word("faoliyatini", new Tag(codeO, emptySeparator), null),
                new Word("samarali", new Tag(codeO, emptySeparator), null),
                new Word("yo‘lga", new Tag(codeO, emptySeparator), null),
                new Word("qo‘yishga", new Tag(codeO, emptySeparator), null),
                new Word("doir", new Tag(codeO, emptySeparator), null),
                new Word("birinchi", new Tag(codeO, emptySeparator), null),
                new Word("navbatdagi", new Tag(codeO, emptySeparator), null),
                new Word("tashkiliy", new Tag(codeO, emptySeparator), null),
                new Word("chora", new Tag(codeO, emptySeparator), null),
                new Word("tadbirlar", new Tag(codeO, emptySeparator), null),
                new Word("to‘g‘risida", new Tag(codeO, emptySeparator), null),
                new Word("gi", new Tag(codeO, emptySeparator), null),
                new Word("PF", new Tag(codeO, emptySeparator), null),
                new Word("14", new Tag(codeO, emptySeparator), null),
                new Word("son", new Tag(codeO, emptySeparator), null),
                new Word("ijrosini", new Tag(codeO, emptySeparator), null),
                new Word("ta’minlash", new Tag(codeO, emptySeparator), null),
                new Word("maqsadida", new Tag(codeO, emptySeparator), null),
                new Word("Oliy", new Tag(codeB, defaultSeparator), tagOrg),
                new Word("ta’lim", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("fan", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("va", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("innovatsiyalar", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("vazirligi", new Tag(codeE, defaultSeparator), tagOrg),
                new Word("faoliyatining", new Tag(codeO, emptySeparator), null),
                new Word("ustuvor", new Tag(codeO, emptySeparator), null),
                new Word("yo‘nalishlari", new Tag(codeO, emptySeparator), null),
                new Word("muvofiq", new Tag(codeO, emptySeparator), null),
                new Word("tasdiqlansin", new Tag(codeO, emptySeparator), null)
        );

        String translatedFullSentence = "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».";
        List<Word> translatedWords = List.of(
                new Word("Утвердить", new Tag(codeO, emptySeparator), null),
                new Word("приоритетные", new Tag(codeO, emptySeparator), null),
                new Word("направления", new Tag(codeO, emptySeparator), null),
                new Word("деятельности", new Tag(codeO, emptySeparator), null),
                new Word("Министерства", new Tag(codeB, defaultSeparator), tagOrg),
                new Word("высшего", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("образования", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("науки", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("и", new Tag(codeI, defaultSeparator), tagOrg),
                new Word("инноваций", new Tag(codeE, defaultSeparator), tagOrg),
                new Word("в", new Tag(codeO, emptySeparator), null),
                new Word("соответствии", new Tag(codeO, emptySeparator), null),
                new Word("с", new Tag(codeO, emptySeparator), null),
                new Word("Указом", new Tag(codeO, emptySeparator), null),
                new Word("Президента", new Tag(codeS, defaultSeparator), tagPer),
                new Word("Республики", new Tag(codeB, defaultSeparator), tagLoc),
                new Word("Узбекистан", new Tag(codeE, defaultSeparator), tagLoc),
                new Word("от", new Tag(codeO, emptySeparator), null),
                new Word("25", new Tag(codeO, emptySeparator), null),
                new Word("января", new Tag(codeO, emptySeparator), null),
                new Word("2023", new Tag(codeO, emptySeparator), null),
                new Word("года", new Tag(codeO, emptySeparator), null),
                new Word("№", new Tag(codeO, emptySeparator), null),
                new Word("14", new Tag(codeO, emptySeparator), null),
                new Word("О", new Tag(codeO, emptySeparator), null),
                new Word("первоочередных", new Tag(codeO, emptySeparator), null),
                new Word("организационных", new Tag(codeO, emptySeparator), null),
                new Word("мерах", new Tag(codeO, emptySeparator), null),
                new Word("по", new Tag(codeO, emptySeparator), null),
                new Word("эффективному", new Tag(codeO, emptySeparator), null),
                new Word("функционированию", new Tag(codeO, emptySeparator), null),
                new Word("органов", new Tag(codeO, emptySeparator), null),
                new Word("исполнительной", new Tag(codeO, emptySeparator), null),
                new Word("власти", new Tag(codeS, defaultSeparator), tagOrg),
                new Word("республики", new Tag(codeO, emptySeparator), null)
        );

        Sentence originalSentence = new Sentence(originalFullSentence, originalWords, tags);
        Sentence translatedSentence = new Sentence(translatedFullSentence, translatedWords, tags);

        NamedEntities namedEntities = new NamedEntities(
                List.of(
                        new RecognizedEntity(
                                "O‘zbekiston Respublikasi",
                                "Республики Узбекистан",
                                tagLoc
                        ),
                        new RecognizedEntity(
                                "Prezidentining",
                                "Президента",
                                tagPer
                        ),
                        new RecognizedEntity(
                                "Respublika",
                                "республики",
                                tagLoc
                        ),
                        new RecognizedEntity(
                                "hokimiyat organlari",
                                "власти",
                                tagOrg
                        ),
                        new RecognizedEntity(
                                "Oliy ta’lim fan va innovatsiyalar vazirligi",
                                "Министерства высшего образования, науки и инноваций",
                                tagOrg
                        )
                ),
                List.of(
                        new UnrecognizedEntities("sinov yozuvi", tagPer, "Тестовая запись")
                )
        );

        SentenceResponse sentenceResponse = new SentenceResponse(
                id,
                originalSentence,
                translatedSentence,
                namedEntities,
                OriginalLanguage.Uzbek.text(),
                TargetLanguage.RUSSIAN.text(),
                RequestStatus.FINISHED.text()
        );

        return sentenceResponse;
    }
}
