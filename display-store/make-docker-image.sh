#!/bin/bash

./gradlew bootJar

docker rmi connie/store-display-service
docker build -t connie/store-display-service:latest .
