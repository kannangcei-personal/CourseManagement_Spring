# Start with a base image containing Java runtime

FROM openjdk:17-jdk

 

# Set the working directory inside the container

WORKDIR /app

 

# Copy the executable JAR file and any other necessary files

COPY target/CourseProject-0.0.1-SNAPSHOT.jar .

# Expose the port on which the application will run

EXPOSE 8080

 

# Set the entry point command to run the JAR file

CMD ["java", "-jar", "CourseProject-0.0.1-SNAPSHOT.jar"]