FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/powerplant-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} powerplant-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/powerplant-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081