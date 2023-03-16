FROM openjdk:17
WORKDIR /app

COPY target/dogAPI-0.0.1-SNAPSHOT.jar /app/dogAPI-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.properties /app/application.properties

EXPOSE 8080

ENTRYPOINT [ "java","-jar","dogAPI-0.0.1-SNAPSHOT.jar" ]
