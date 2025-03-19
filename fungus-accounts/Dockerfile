FROM openjdk:17-jdk-slim
LABEL authors="xqdev"

WORKDIR /app
COPY build/libs/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]