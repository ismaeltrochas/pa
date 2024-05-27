
FROM amazoncorretto:17
WORKDIR /app

COPY target/eureka-*.jar /app/


EXPOSE 8081
# Ejecutar el archivo JAR
CMD java -jar /app/eureka-1.0.0-SNAPSHOT.jar
