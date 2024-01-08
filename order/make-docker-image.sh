#!/bin/bash

./gradlew bootJar

docker rmi delivery/order-service
docker build -t delivery/order-service:latest .
