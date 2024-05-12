FROM openjdk:17-alpine AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn package

FROM openjdk:17-alpine

WORKDIR /app

COPY /target/BreastCancer-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "BreastCancer-0.0.1-SNAPSHOT.jar"]