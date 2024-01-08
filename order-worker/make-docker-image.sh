#!/bin/bash

./gradlew bootJar

docker rmi delivery/order-worker-service
docker build -t delivery/order-worker-service:latest .
