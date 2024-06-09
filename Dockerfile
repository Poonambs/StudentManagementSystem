# Use an OpenJDK base image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the compiled Java application JAR file into the container
COPY ./target/studentsystem.jar .

# Define the command to run the Java application
CMD ["java", "-jar", "studentsystem.jar"]
# Use the official MySQL base image

