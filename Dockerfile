# Usa Java 24 JRE
FROM eclipse-temurin:24-jre

# Instala dockerize para esperar a MySQL
RUN wget https://github.com/jwilder/dockerize/releases/download/v0.8.0/dockerize-linux-amd64-v0.8.0.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.8.0.tar.gz \
    && rm dockerize-linux-amd64-v0.8.0.tar.gz

# Crea directorio y copia el JAR
WORKDIR /app
COPY target/escuela_patinaje-*.jar app.jar

# Expone puerto
EXPOSE 8080

# Usa dockerize para esperar a MySQL antes de iniciar la app
ENTRYPOINT ["dockerize", "-wait", "tcp://mysql:3306", "-timeout", "60s", "java", "-jar", "app.jar"]