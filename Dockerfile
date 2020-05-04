#
# Build stage
#
FROM openjdk:8-jdk-alpine as build

WORKDIR /build
COPY ./app/pom.xml .
COPY ./app/mvnw .
COPY ./app/src src
COPY ./app/.mvn .mvn
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency  && (cd target/dependency; jar -xf ../*.jar)

# 
# Package stage
# 
FROM gcr.io/distroless/java
COPY --from=build /build/target/nimhans-0.0.1-SNAPSHOT.jar /usr/app/nimhans.jar
EXPOSE 8585
ENTRYPOINT ["java","-jar","/usr/app/nimhans.jar"]

