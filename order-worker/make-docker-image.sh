#!/bin/bash

./gradlew bootJar

docker rmi delivery/order-worker-sevice
docker build -t delivery/order-worker-sevice:latest .
