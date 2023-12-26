#!/bin/bash

./gradlew bootJar

docker rmi connie/user-service
docker build -t connie/user-service:latest .
