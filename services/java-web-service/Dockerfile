
# ===== Stage 1: Build the Application =====
FROM maven:3-amazoncorretto-17 AS build
LABEL maintainer="your-email@example.com" \
      version="1.0" \
      description="Build stage for Spring Boot Greeting Service"
# Build-time argument (can be overridden during build)
ARG build_version=1.0
# Environment variables used during build
ENV APP_HOME=/app \
    APP_VERSION=${build_version}
# Set working directory
WORKDIR $APP_HOME
# Copy the Maven descriptor and source code
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
# Run the Maven build to create the jar (skip tests for speed)
RUN mvn clean package -DskipTests



# ===== Stage 2: Create the Runtime Image =====
FROM openjdk:17-jdk-alpine
LABEL maintainer="your-email@example.com" \
      description="Runtime image for Spring Boot Greeting Service"
# Set environment variable for the runtime container
ENV APP_HOME=/app \
    SPRING_PROFILES_ACTIVE=dev
      # Set working directory for subsequent instructions
WORKDIR $APP_HOME
# Copy the built jar from the build stage into the runtime image
COPY --from=build $APP_HOME/target/java-web-service-0.0.1-SNAPSHOT.jar app.jar

# Demonstrate ADD by including an external file (example: README from a URL)
ADD https://raw.githubusercontent.com/docker-library/docs/master/openjdk/README.md /app/README.md

# Expose port 8080 for the application
EXPOSE 8080

# Define a volume for persistent data (for example, to store logs)
VOLUME ["/app/logs"]

# Set a custom stop signal for graceful shutdown (SIGTERM is standard for Java apps)
STOPSIGNAL SIGTERM

# Configure a healthcheck so Docker can monitor container health.
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD wget -q --spider http://localhost:8080/hello || exit 1

# Switch to a non-root user for better security
USER nobody

# Override the default shell for RUN instructions (optional demonstration)
SHELL ["/bin/sh", "-c"]

# Set the entrypoint so the container runs the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
# Provide default command-line arguments to the application
CMD ["--spring.profiles.active=prod"]

