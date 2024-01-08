FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/order-worker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} order-worker.jar
COPY build/libs/*.jar order-worker.jar

ENTRYPOINT ["java", "-jar", "order-worker.jar"]
