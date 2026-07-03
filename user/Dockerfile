#FROM maven AS build
#WORKDIR /build
#COPY pom.xml .
#COPY src ./src
#RUN mvn package -DskipTests

#this is more like a non-prod dockerfile, for dev and test
#in production, you would use the maven build to create the jar and then use it to create the docker image

FROM eclipse-temurin:25-jdk-ubi10-minimal
WORKDIR /app
#COPY --from=build /build/target/*.jar /app/app.jar
COPY target/*.jar app.jar
EXPOSE 8888
CMD ["java","-jar","app.jar"]

# in project folder - mvnw clean package -DskipTests
# outside project folder - docker build -t config-server ./configserver\
# outside project folder - docker run --env-file configserver/.env -d --name config-server -p 8888:8888 config-server