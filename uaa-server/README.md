# UAA Server

## Overview

The UAA (User Account and Authentication) Server is a microservice that acts as an authorization server, handling authentication and issuing tokens. It uses Spring Boot, Spring Security, and OAuth2 for managing secure user authentication and authorization.

## Prerequisites

- Java 17
- Gradle 8.5+
- Docker (for containerization)


## Configuration

The `application.yml` file contains the necessary configuration for the UAA server, including client registration details and security settings.

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
docker build -t uaa-server .
```

## Run Docker Container
To run the Docker container, use:

```bash
docker run -p 9000:9000 uaa-server
```

## Hosts Configuration
For proper communication between the microservices, ensure you add the following entry in the /etc/hosts file:

```bash
127.0.0.1 uaa-server
```

This will allow other microservices to communicate with the UAA server using the hostname `uaa-server`.


## Contributions
Pleas feel free to fork this repository and contribute by submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License.