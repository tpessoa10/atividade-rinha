#
# Build stage
#
FROM maven:4.0.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:18-jre-slim
COPY --from=build /home/app/target/atividade-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 0000
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]