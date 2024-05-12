# Docker Build Maven Stage
FROM maven:3-openjdk-17 AS build
# Copy folder in docker
WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean install -DskipTests -Pprod
# Run spring boot in Docker
FROM openjdk:17
COPY --from=build /opt/app/target/*.jar app.jar
ENV PORT 8080
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dspring.profiles.active=prod","-Dserver.port=${PORT}","app.jar"]