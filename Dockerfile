# Use a imagem base do Eclipse Temurin JDK 21
FROM eclipse-temurin:21-alpine

# Adiciona um volume apontando para /tmp
VOLUME /tmp

# Expõe a porta que a aplicação vai rodar
EXPOSE 8080

# Define o argumento JAR_FILE com o caminho do arquivo JAR gerado pelo Maven
ARG JAR_FILE=target/gerenciamento-de-trafego-0.0.1-SNAPSHOT.jar

# Adiciona o arquivo JAR ao contêiner
ADD ${JAR_FILE} app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
