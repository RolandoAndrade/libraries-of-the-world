FROM maven3.6.3-openjdk-8:latest
COPY . /usr/app
WORKDIR /usr/app
EXPOSE 3000
RUN mvn package
ENTRYPOINT ["java","-cp","target/libraries-of-the-world-1.0-SNAPSHOT.jar"]