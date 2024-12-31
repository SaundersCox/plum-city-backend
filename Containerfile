# Build time
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY pom.xml .
COPY src src
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app
VOLUME /tmp
COPY --from=build /app/target/*.jar app.jar
RUN chmod +x ./app/start-app.sh
ENTRYPOINT ["/app/start-app.sh"]
EXPOSE 8080