# ---------- BUILD STAGE ----------
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copy all project files
COPY . .

# Build the application (skips tests)
RUN mvn -B -DskipTests clean package


# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose your application port
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
