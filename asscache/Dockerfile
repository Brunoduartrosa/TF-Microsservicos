FROM eclipse-temurin:21 AS build

RUN apk add --no-cache maven

COPY . .

RUN mvn clean package spring-boot:repackage

RUN chmod +x target/gateway-0.0.1-SNAPSHOT.jar

EXPOSE: 8082

CMD ["java", "-jar", "target/asscache-0.0.1-SNAPSHOT.jar"]