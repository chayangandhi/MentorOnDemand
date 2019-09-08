FROM openjdk:latest

# Add Maintainer Info
LABEL maintainer="gandhichayan97@gmail.com"


ADD target/ModUser.jar ModUser.jar

# Make port 8083 available to the world outside this container
EXPOSE 8081

# Run the jar file 
ENTRYPOINT ["java","-jar","ModUser.jar"]