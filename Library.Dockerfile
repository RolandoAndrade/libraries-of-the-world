FROM maven3.6.3-openjdk-8:latest as buildstage
# Copy only pom.xml of your projects and download dependencies
COPY pom.xml /usr/app/
WORKDIR /usr/app
RUN mvn -B -f pom.xml dependency:go-offline
# Copy all other project files and build project
COPY . .
EXPOSE 3000
RUN mvn package

#----
# Final stage
#----
FROM openjdk:8-jdk
COPY --from=buildstage /usr/app/target/*.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-cp","target/libraries-of-the-world-1.0-SNAPSHOT.jar"]