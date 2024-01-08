FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/store-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} store.jar
COPY build/libs/*.jar store.jar

ENTRYPOINT ["java", "-jar", "store.jar"]
