FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime Stage
FROM amazoncorretto:17
WORKDIR /app

# Copiar el archivo JAR desde la ubicación local al contenedor
COPY target/course-*.jar /app/

ENV  DB_URL = jdbc:psotgresql://db_course:5434/db-course

EXPOSE 8081
# Ejecutar el archivo JAR
CMD java -jar -Dspring.datasource.url={DB_URL} /app/course-1.0.0-SNAPSHOT.jar
