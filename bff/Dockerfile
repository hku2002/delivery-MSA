FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/webflux-gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} webflux-gateway.jar
COPY build/libs/*.jar webflux-gateway.jar

ENTRYPOINT ["java", "-jar", "webflux-gateway.jar"]
