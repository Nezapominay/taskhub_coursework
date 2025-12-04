FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} worker.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","worker.jar"]