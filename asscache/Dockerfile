FROM eclipse-temurin:21 AS build

COPY . .

RUN chmod +x target/asscache-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "target/asscache-0.0.1-SNAPSHOT.jar"]