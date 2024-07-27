#!/bin/bash

# Define the base directory
BASE_DIR="freshmate_client"

# Create the directory structure
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/controller"
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/model"
mkdir -p "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/view"
mkdir -p "${BASE_DIR}/src/main/resources/css"
mkdir -p "${BASE_DIR}/src/main/resources/images"
mkdir -p "${BASE_DIR}/lib"

# Add .gitkeep files
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/controller/.gitkeep"
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/model/.gitkeep"
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/view/.gitkeep"
touch "${BASE_DIR}/src/main/resources/css/.gitkeep"
touch "${BASE_DIR}/src/main/resources/images/.gitkeep"

# Create placeholder files
touch "${BASE_DIR}/src/main/java/org/csc325/freshmate_client/MainApp.java"
touch "${BASE_DIR}/src/main/resources/application.properties"
touch "${BASE_DIR}/build.gradle"
touch "${BASE_DIR}/README.md"

echo "Folder structure for freshmate_client created successfully."
