#!/usr/bin/env sh
set -e

echo "Starting application"
java ${JAVA_OPTS} -Djava.security.egd=file:/development/./urandom -jar /app.jar
