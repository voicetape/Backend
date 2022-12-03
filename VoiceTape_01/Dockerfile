FROM amazoncorretto:11
EXPOSE 8088
ARG JAR_FILE=build/libs/VoiceTape_01-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]