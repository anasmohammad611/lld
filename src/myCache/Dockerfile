# Use an official OpenJDK runtime as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the cache library JAR file into the container at /app
COPY target/myCache-0.0.1-SNAPSHOT.jar /app

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run your cache library application
CMD ["java", "-jar", "/app/myCache-0.0.1-SNAPSHOT.jar"]
