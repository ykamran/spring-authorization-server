# API Key Auth Provider

## Overview

The API Key Auth Provider is a microservice that handles API key authentication. It uses Spring Boot, Spring Security, and OAuth2 for managing secure client authentication and API key retrieval.

## Prerequisites

- Java 17
- Gradle
- Docker (for containerization)


## Configuration

The `application.yml` file contains the necessary configuration for the API Key Auth Provider, including client registration details, security settings, and the API endpoint for retrieving API keys.

## Build with Gradle

To build the project, run:

```bash
./gradlew clean build
```

## Run Locally
To run the application locally, use:

```bash
./gradlew bootRun
```

## Build Docker Image
To build the Docker image, execute:

```bash
docker build -t apikey-auth-provider .
```

Run Docker Container
To run the Docker container, use:

```bash
docker run -p 9090:9090 apikey-auth-provider
```

## Contributions
Pleas feel free to fork this repository and contribute by submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License.