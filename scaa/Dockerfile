FROM eclipse-temurin:21-jre-alpine

WORKDIR app

RUN apk add --no-cache maven

COPY . .

RUN mvn clean package spring-boot:repackage

ENTRYPOINT ["java", "-jar", "target/scaa-0.0.1-SNAPSHOT.jar"]