# Stage 1 - Compilation
FROM maven:3.9-eclipse-temurin-25-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2 - Runtime
FROM eclipse-temurin:25-jre-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]