#!/bin/bash

./gradlew bootJar

docker rmi connie/webflux-gateway-service
docker build -t connie/webflux-gateway-service:latest .
