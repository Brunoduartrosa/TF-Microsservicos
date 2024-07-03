FROM eclipse-temurin:21-jre-alpine

WORKDIR app

COPY . .

RUN chmod +x target/gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "target/gateway-0.0.1-SNAPSHOT.jar" ]