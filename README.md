# NER BIOES Translator Service

# Запуск приложения

Компиляция и запуск приложения:

```bash
$ ./mvnw clean package
$ docker compose up --build -d 
```
---

Порт сервиса - 8080

---

По адрессу ```http://localhost:8080/swagger-ui``` доступно API приложения, автоматически сгенерированное через OpenAPI

---

# Примеры запросов

(есть в ```src/.../resources/requests```)

---
**Получить информацию по доступным языкам**
***Запросы***

```http request
GET http://localhost:8080/api/v1/languages
Accept: application/json
```

***Пример ответа***

```json
{
  "fromLanguages": [
    {
      "name": "Узбекский язык",
      "code": "uz"
    }
  ],
  "toLanguages": [
    {
      "name": "Русский язык",
      "code": "ru"
    },
    {
      "name": "Английский язык",
      "code": "en"
    },
    {
      "name": "Казахский язык",
      "code": "kk"
    }
  ]
}
```
---

**Получить список предложений**

***Запросы***

```http request
GET http://localhost:8080/api/v1/requests/1/sentences
Accept: application/json
```

```http request
GET http://localhost:8080/api/v1/requests/1/sentences?page=0&size=10&sort=id,asc
Accept: application/json
```

```http request
GET http://localhost:8080/api/v1/requests/1/sentences?page=6&size=5
Accept: application/json
```
***Пример ответа для первого запроса***

```json
{
  "sentences": {
    "content": [
      {
        "id": 0,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 1,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 2,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 3,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 4,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 5,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 6,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 7,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 8,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      },
      {
        "id": 9,
        "originalFullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
        "translatedFullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
        "status": "Обработка завершена"
      }
    ],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 10,
      "sort": {
        "sorted": true,
        "empty": false,
        "unsorted": false
      },
      "offset": 0,
      "paged": true,
      "unpaged": false
    },
    "totalPages": 10,
    "totalElements": 100,
    "last": false,
    "size": 10,
    "number": 0,
    "sort": {
      "sorted": true,
      "empty": false,
      "unsorted": false
    },
    "first": true,
    "numberOfElements": 10,
    "empty": false
  },
  "fromLanguage": "Узбекский язык",
  "toLanguage": "Русский язык",
  "percentageOfProcessedSentences": 77
}
```
---

**Получить информацию по конкретному предложению**

***Запросы***

```http request
GET http://localhost:8080/api/v1/requests/1/sentences/1
Accept: application/json
```

```http request
GET http://localhost:8080/api/v1/requests/1/sentences/54
Accept: application/json
```

***Пример ответа***

```json
{
  "id": 1,
  "originalSentence": {
    "fullSentence": "O‘zbekiston Respublikasi Prezidentining 2023 yil 25 yanvardagi Respublika ijro etuvchi hokimiyat organlari faoliyatini samarali yo‘lga qo‘yishga doir birinchi navbatdagi tashkiliy chora tadbirlar to‘g‘risida gi PF 14 son ijrosini ta’minlash maqsadida Oliy ta’lim fan va innovatsiyalar vazirligi faoliyatining ustuvor yo‘nalishlari muvofiq tasdiqlansin",
    "words": [
      {
        "word": "O‘zbekiston",
        "tag": {
          "prefix": "B",
          "separator": "-"
        },
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "word": "Respublikasi",
        "tag": {
          "prefix": "E",
          "separator": "-"
        },
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "word": "Prezidentining",
        "tag": {
          "prefix": "S",
          "separator": "-"
        },
        "entityType": {
          "type": "PER",
          "color": "red"
        }
      },
      {
        "word": "2023",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "yil",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "25",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "yanvardagi",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "Respublika",
        "tag": {
          "prefix": "S",
          "separator": "-"
        },
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "word": "ijro",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "etuvchi",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "hokimiyat",
        "tag": {
          "prefix": "B",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "organlari",
        "tag": {
          "prefix": "E",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "faoliyatini",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "samarali",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "yo‘lga",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "qo‘yishga",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "doir",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "birinchi",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "navbatdagi",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "tashkiliy",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "chora",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "tadbirlar",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "to‘g‘risida",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "gi",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "PF",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "14",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "son",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "ijrosini",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "ta’minlash",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "maqsadida",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "Oliy",
        "tag": {
          "prefix": "B",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "ta’lim",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "fan",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "va",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "innovatsiyalar",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "vazirligi",
        "tag": {
          "prefix": "E",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "faoliyatining",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "ustuvor",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "yo‘nalishlari",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "muvofiq",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "tasdiqlansin",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      }
    ],
    "tags": [
      {
        "type": "LOC",
        "color": "green"
      },
      {
        "type": "PER",
        "color": "red"
      },
      {
        "type": "ORG",
        "color": "blue"
      }
    ]
  },
  "translatedSentence": {
    "fullSentence": "Утвердить приоритетные направления деятельности Министерства высшего образования, науки и инноваций в соответствии с Указом Президента Республики Узбекистан от 25 января 2023 года № 14 «О первоочередных организационных мерах по эффективному функционированию органов исполнительной власти республики».",
    "words": [
      {
        "word": "Утвердить",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "приоритетные",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "направления",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "деятельности",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "Министерства",
        "tag": {
          "prefix": "B",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "высшего",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "образования",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "науки",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "и",
        "tag": {
          "prefix": "I",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "инноваций",
        "tag": {
          "prefix": "E",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "в",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "соответствии",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "с",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "Указом",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "Президента",
        "tag": {
          "prefix": "S",
          "separator": "-"
        },
        "entityType": {
          "type": "PER",
          "color": "red"
        }
      },
      {
        "word": "Республики",
        "tag": {
          "prefix": "B",
          "separator": "-"
        },
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "word": "Узбекистан",
        "tag": {
          "prefix": "E",
          "separator": "-"
        },
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "word": "от",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "25",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "января",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "2023",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "года",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "№",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "14",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "О",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "первоочередных",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "организационных",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "мерах",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "по",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "эффективному",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "функционированию",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "органов",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "исполнительной",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      },
      {
        "word": "власти",
        "tag": {
          "prefix": "S",
          "separator": "-"
        },
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "word": "республики",
        "tag": {
          "prefix": "O",
          "separator": ""
        },
        "entityType": null
      }
    ],
    "tags": [
      {
        "type": "LOC",
        "color": "green"
      },
      {
        "type": "PER",
        "color": "red"
      },
      {
        "type": "ORG",
        "color": "blue"
      }
    ]
  },
  "namedEntities": {
    "recognizedEntities": [
      {
        "originalEntity": "O‘zbekiston Respublikasi",
        "translatedEntity": "Республики Узбекистан",
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "originalEntity": "Prezidentining",
        "translatedEntity": "Президента",
        "entityType": {
          "type": "PER",
          "color": "red"
        }
      },
      {
        "originalEntity": "Respublika",
        "translatedEntity": "республики",
        "entityType": {
          "type": "LOC",
          "color": "green"
        }
      },
      {
        "originalEntity": "hokimiyat organlari",
        "translatedEntity": "власти",
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      },
      {
        "originalEntity": "Oliy ta’lim fan va innovatsiyalar vazirligi",
        "translatedEntity": "Министерства высшего образования, науки и инноваций",
        "entityType": {
          "type": "ORG",
          "color": "blue"
        }
      }
    ],
    "unrecognizedEntities": [
      {
        "originalEntity": "sinov yozuvi",
        "originalEntityType": {
          "type": "PER",
          "color": "red"
        },
        "possibleEntityTranslation": "Тестовая запись"
      }
    ]
  },
  "fromLanguage": "Узбекский язык",
  "toLanguage": "Русский язык",
  "status": "Обработка завершена"
}
```

---

**Скачать CSV файл с переводом**

***Запросы***

```http request
GET http://localhost:8080/api/v1/requests/1/sentences-csv
Accept: application/json
```

***Пример ответа***

Должен скачаться файл с содержанием

```csv
"word","tag"
"Тестовая","B-PER"
"Запись","E-PER"
```

**Загрузить CSV файл с сущностями**

***Запросы***
Запрос доходит до бэка с файлом, но в процессе парсинга падает и возвращает 500, позже исправится

```http request
POST http://localhost:8080/api/v1/requests?from=uz&to=ru
Content-Type: multipart/form-data; boundary=WebAppBoundary

--WebAppBoundary
Content-Disposition: form-data; name="file"; filename="test-file.csv"
Content-Type: text/csv

< {full-path-to-file}/test-file.csv
--WebAppBoundary--
```

***Пример ответа***

Пока пусто
```json
{
  
}
```