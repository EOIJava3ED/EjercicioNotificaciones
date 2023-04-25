FROM openjdk:21-slim
COPY target/${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]