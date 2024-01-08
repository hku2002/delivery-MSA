#!/bin/bash

./gradlew bootJar

docker rmi delivery/store-worker-service
docker build -t delivery/store-worker-service:latest . ``
