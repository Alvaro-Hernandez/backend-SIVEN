# Usa una imagen de Maven para compilar la aplicación
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Usa una imagen de Java para ejecutar la aplicación
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/siven-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
