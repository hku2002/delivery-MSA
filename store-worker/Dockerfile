FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/store-worker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} store-worker.jar
COPY build/libs/*.jar store-worker.jar

ENTRYPOINT ["java", "-jar", "store-worker.jar"]
