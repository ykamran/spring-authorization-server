# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY build/libs/uaa-server-1.0.0-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 9000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
