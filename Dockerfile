FROM openjdk:11

ENV JAR_FILE=target/todo-api-*.jar

COPY ${JAR_FILE} app.jar
EXPOSE 8080

ENTRYPOINT java -jar /app.jar