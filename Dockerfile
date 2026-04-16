# ── Build Stage ──────────────────────────────────────────────────────────────
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the root pom and all module poms first to cache dependencies
COPY pom.xml .
COPY api-gateway/pom.xml api-gateway/
COPY auth-service/pom.xml auth-service/
COPY measurement-service/pom.xml measurement-service/
COPY history-service/pom.xml history-service/

# Download dependencies (this layer is cached if poms don't change)
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY . .

# Build all modules
RUN mvn clean package -DskipTests -q

# ── Run Stage ────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# This ARG is passed from render.yaml to determine which jar to run
ARG SERVICE_NAME

# Copy the specific jar from the build stage
# Note: Maven generates jars in {module}/target/{module}-0.0.1-SNAPSHOT.jar
COPY --from=build /app/${SERVICE_NAME}/target/${SERVICE_NAME}-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Environment-aware entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
