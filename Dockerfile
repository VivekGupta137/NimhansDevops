#
# Build stage
#
FROM maven:3.5-jdk-8 AS build
COPY ./app/src /usr/src/app/src
COPY ./app/pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package
#
# Package stage
#
FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/nimhans-0.0.1-SNAPSHOT.jar /usr/app/nimhans.jar
EXPOSE 8585
ENTRYPOINT ["java","-jar","/usr/app/nimhans.jar"]