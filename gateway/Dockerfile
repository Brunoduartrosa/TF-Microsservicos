FROM eclipse-temurin:21-jre-alpine
COPY target/*.jar app.jar
EXPOSE 8765
ENTRYPOINT [ "java", "-jar", "/app.jar" ]