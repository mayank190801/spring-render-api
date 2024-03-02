From eclipse-temurin:17-jdk-alpine
Volume /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
