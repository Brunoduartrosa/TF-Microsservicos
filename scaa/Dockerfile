# Usar uma imagem base do Maven para construir o projeto
FROM eclipse-temurin:21 AS build

# Instalar o Maven
RUN apt-get update && apt-get install -y maven

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e outros arquivos de configuração para o diretório de trabalho
COPY pom.xml .

# Baixar as dependências do projeto (isso ajuda no cacheamento das dependências)
RUN mvn dependency:go-offline -B

# Copiar o código fonte do projeto para o diretório de trabalho
COPY src ./src

# Construir o projeto e gerar o arquivo .jar
RUN mvn clean package -DskipTests

# Usar uma imagem base do Eclipse Temurin JDK 21 para rodar a aplicação
FROM eclipse-temurin:21-jre-alpine

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo .jar do estágio de build para o estágio final
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]