#!/bin/bash

# Define the base directory
BASE_DIR="freshmate_api"

# Create the directory structure
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/config"
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/controller"
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/model"
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/repository"
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/service"
mkdir -p "${BASE_DIR}/src/main/resources/static"
mkdir -p "${BASE_DIR}/src/main/resources/templates"
mkdir -p "${BASE_DIR}/src/main/resources/db/migration"
mkdir -p "${BASE_DIR}/src/test/java/org/csc325/freshmate_api/controller"
mkdir -p "${BASE_DIR}/src/test/java/org/csc325/freshmate_api/repository"
mkdir -p "${BASE_DIR}/src/test/java/org/csc325/freshmate_api/service"
mkdir -p "${BASE_DIR}/src/test/resources"

# Add .gitkeep files
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/config/.gitkeep"
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/controller/.gitkeep"
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/model/.gitkeep"
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/repository/.gitkeep"
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/service/.gitkeep"
touch "${BASE_DIR}/src/main/resources/static/.gitkeep"
touch "${BASE_DIR}/src/main/resources/templates/.gitkeep"
touch "${BASE_DIR}/src/main/resources/db/migration/.gitkeep"
touch "${BASE_DIR}/src/test/java/org/csc325/freshmate_api/controller/.gitkeep"
touch "${BASE_DIR}/src/test/java/org/csc325/freshmate_api/repository/.gitkeep"
touch "${BASE_DIR}/src/test/java/org/csc325/freshmate_api/service/.gitkeep"
touch "${BASE_DIR}/src/test/resources/.gitkeep"

# Create placeholder files
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_api/FreshmateApiApplication.java"
touch "${BASE_DIR}/src/main/resources/application.properties"
touch "${BASE_DIR}/src/test/resources/application-test.properties"
touch "${BASE_DIR}/mvnw"
touch "${BASE_DIR}/mvnw.cmd"
touch "${BASE_DIR}/pom.xml"
touch "${BASE_DIR}/HELP.md"

echo "Folder structure for freshmate_api created successfully."
