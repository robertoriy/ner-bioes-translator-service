FROM openjdk:21-jdk

WORKDIR /app

COPY target/ner-bioes-translator-service-1.jar /app/ner-bioes-translator-service.jar

ENTRYPOINT ["java","-jar","/app/ner-bioes-translator-service.jar"]