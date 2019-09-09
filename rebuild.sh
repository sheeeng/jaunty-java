#!/usr/bin/env bash

IMAGE_TAG_NAME="sheeeng/jaunty-java:0.0.1"

docker run \
    --rm \
    --user 1000:1000 \
    --volume="${PWD}":/app:rw \
    --workdir=/app \
    maven:3.6-slim \
    mvn clean package \
    && docker build \
        --tag "${IMAGE_TAG_NAME}" \
        "${PWD}" \
    && docker run \
        --volume /etc/localtime:/etc/localtime:ro \
        --rm \
        -m512M \
        --publish 8080:8080 \
        "${IMAGE_TAG_NAME}"
#     --detach
# && watch curl --silent --show-error localhost:8080
