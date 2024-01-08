FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/order-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} order.jar
COPY build/libs/*.jar order.jar

ENTRYPOINT ["java", "-jar", "order.jar"]
