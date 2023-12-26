#!/bin/bash

FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/mvc-user-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} store-display.jar
COPY build/libs/*.jar store-display.jar

ENTRYPOINT ["java", "-jar", "store-display.jar"]
