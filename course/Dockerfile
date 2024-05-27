
# Runtime Stage
FROM amazoncorretto:17
WORKDIR /app

COPY target/course-*.jar /app/


EXPOSE 8081
# Ejecutar el archivo JAR
CMD java -jar /app/course-1.0.0-SNAPSHOT.jar
