#!/bin/bash
set -e
export JAVA_HOME=/opt/render/project/java
chmod +x mvnw
./mvnw clean package
