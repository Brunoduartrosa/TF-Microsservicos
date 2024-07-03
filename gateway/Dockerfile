FROM eclipse-temurin:21-jre-alpine

WORKDIR app

COPY . .

RUN mvn clean package spring-boot:repackage

RUN chmod +x target/gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "target/gateway-0.0.1-SNAPSHOT.jar" ]