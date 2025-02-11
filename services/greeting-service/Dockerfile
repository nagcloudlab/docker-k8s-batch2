# ===== Stage 1: Build the Application =====
FROM maven:3-amazoncorretto-17 AS build
ENV APP_HOME=/app \
    APP_VERSION=${build_version} 
WORKDIR $APP_HOME    
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# ===== Stage 2: Create the Runtime Image =====
FROM eclipse-temurin:17.0.5_8-jre-focal
ENV APP_HOME=/app \
    SPRING_PROFILES_ACTIVE=prod
WORKDIR $APP_HOME
COPY --from=build $APP_HOME/target/greeting-service-0.0.1-SNAPSHOT.jar app.jar
ADD https://raw.githubusercontent.com/docker-library/docs/master/openjdk/README.md $APP_HOME/README.md
EXPOSE 8080
USER nobody
ENTRYPOINT [ "java", "-jar", "app.jar" ]
 
