FROM openjdk:latest

# Add Maintainer Info
LABEL maintainer="gandhichayan97@gmail.com"


ADD target/ModMentor.jar ModMentor.jar

# Make port 8083 available to the world outside this container
EXPOSE 8082

# Run the jar file 
ENTRYPOINT ["java","-jar","ModMentor.jar"]