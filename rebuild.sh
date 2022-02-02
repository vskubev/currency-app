#!/bin/sh
./gradlew build
./gradlew bootJar
docker build . -t vskubev/currency
docker push vskubev/currency
docker pull vskubev/currency