# Build stage
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app
COPY . .
RUN ./mvnw package

# Run stage
FROM eclipse-temurin:17-jdk-alpine AS runner

WORKDIR /app
COPY --from=builder /app/target/*.jar .

CMD ["java", "-jar", "example-java-1.0-SNAPSHOT.jar"]