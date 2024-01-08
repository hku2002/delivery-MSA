#!/bin/bash

./gradlew bootJar

docker rmi delivery/store-service
docker build -t delivery/store-service:latest .
